/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.BranchServiceLayer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramesh Wijerathna
 */
public class BranchBusinessLayer {

    public static String getCureentDate() {

        String date;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime ldt = LocalDateTime.now();

        date = (dtf.format(ldt));

        return date;
    }

    public static long DayDifferent(String issuRecordDate) {

        try {
            long DayCount;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            Date Cuurrent = dateFormat.parse(getCureentDate());
            Date RecordDate = dateFormat.parse(issuRecordDate);

            long diff = Cuurrent.getTime() - RecordDate.getTime();

            DayCount = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

            return DayCount;
        } catch (ParseException ex) {
            Logger.getLogger(BranchBusinessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static ArrayList<Maintenance_Issue> Expire_Issue_PopUp(int BranchID) {

        ArrayList<Maintenance_Issue> Expire_Issues_List = new ArrayList<>();

        ArrayList<Maintenance_Issue> allissue = BranchServiceLayer.GetAllIssues(BranchID);

        for (Maintenance_Issue issue : allissue) {

            if (DayDifferent(issue.getIssRecDat()) > 7 && issue.getIssFlag().equals("Major")) {

                Expire_Issues_List.add(issue);

            } else if (DayDifferent(issue.getIssRecDat()) > 14 && issue.getIssFlag().equals("Normal")) {
                Expire_Issues_List.add(issue);

            }

        }
        return Expire_Issues_List;

    }
}
