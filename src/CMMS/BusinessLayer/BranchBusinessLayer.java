/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

import CMMS.Models.Maintenance_Issue;
import CMMS.ServiceLayer.IssuessServiceLayer;
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

    
    // get current system date
    public static String getCureentDate() {

        String date;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ldt = LocalDateTime.now();

        date = (dtf.format(ldt));

        return date;
    }

    // calculate day different between issue recorded date with the current date
    public static long DayDiffe(String issuRecordDate) {

        try {
            long DayCount;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

    // check expired issues and add to the list
    public static ArrayList<Maintenance_Issue> Check_Expire_Issue(int BranchID) {

        ArrayList<Maintenance_Issue> Expire_Issues_List = new ArrayList<>();

        ArrayList<Maintenance_Issue> allissue = IssuessServiceLayer.GetReportedIssues(BranchID);

        for (Maintenance_Issue issue : allissue) {

            if (DayDiffe(issue.getIssRecDat()) > 7 && issue.getIssFlag().equals("Major") && issue.getApprovalStat().equals("Not Approved")) {

                Expire_Issues_List.add(issue);

            } else if (DayDiffe(issue.getIssRecDat()) > 14 && issue.getIssFlag().equals("Normal") && issue.getStatus().equals("Reported")) {
                Expire_Issues_List.add(issue);

            }

        }
        return Expire_Issues_List;

    }
}
