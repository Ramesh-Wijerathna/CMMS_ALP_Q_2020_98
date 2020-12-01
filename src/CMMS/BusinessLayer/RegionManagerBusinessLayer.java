/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

import CMMS.ServiceLayer.RegionManagerServiceLayer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionManagerBusinessLayer {

    //Allocate Region Managers to Maintenance Issue
    public static void assignRegionManager() {
        System.out.println("Started");

        RegionManagerServiceLayer rmsl = new RegionManagerServiceLayer();
        String assignedRMID = "";

        //Find Major Maintenence Issues
        String mntID = rmsl.findMajorIssue();

        if (mntID.length()>0) {
            try {
                System.out.println("Issue Found");
                
                //Get Branch ID using Maintenance Issue ID
                int brnID = rmsl.findbranchID(mntID);
                System.out.println(brnID);
                
                //Get Region ID using Branch ID
                int rID = rmsl.findRegionID(brnID);
                System.out.println(rID);
                
                //Assign managers
                ArrayList<String> resultOfManagers = new ArrayList<>();
                
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(rmsl.date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date1);
                
                int passday = calendar.get(Calendar.DAY_OF_WEEK);
                
                resultOfManagers = rmsl.findRegionManagers(rID, findDay(passday));
                
                for (int i = 0; i < resultOfManagers.size(); i++) 
                {
                    System.out.print(resultOfManagers.get(i) + " ");
                    assignedRMID = resultOfManagers.get(i);
                }
                
                
                //Save assigned managers to table
                boolean res = rmsl.saveToTable(mntID, brnID, rmsl.date, rID, assignedRMID);
            } catch (ParseException ex) {
                Logger.getLogger(RegionManagerBusinessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Issue Not Found");
        }

    }

    private static String findDay(int date) {
        String day = "";

        if (date == 2) {
            day = "Monday";
        } else {
            if (date == 3) {
                day = "Tuesday";
            } else {
                if (date == 4) {
                    day = "Wednesday";
                } else {
                    if (date == 5) {
                        day = "Thursday";
                    } else {
                        if (date == 6) {
                            day = "Friday";
                        } else {
                            if (date == 7) {
                                day = "Saturday";
                            } else {
                                day = "sunday";
                            }
                        }
                    }
                }
            }

        }
        return day;
    }

}
