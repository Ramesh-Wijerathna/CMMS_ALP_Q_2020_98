/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Maintenance_Issue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramesh Wijerathna
 */
public class IssuessServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;
    
    
    // saved issue data in the database
    public static boolean ReportIssue(Maintenance_Issue issue) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into maintenance_issue values(?,?,?,?,?,?,?,?,?,?)");

            ps.setObject(1, issue.getMntID());
            ps.setObject(2, issue.getBrnID());
            ps.setObject(3, issue.getIntID());
            ps.setObject(4, issue.getSupID());
            ps.setObject(5, issue.getMntEmail());
            ps.setObject(6, issue.getIssFlag());
            ps.setObject(7, issue.getIssDetail());
            ps.setObject(8, issue.getIssRecDat());
            ps.setObject(9, issue.getStatus());
            ps.setObject(10, issue.getApprovalStat());

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    // search reported issues
    public static ArrayList<Maintenance_Issue> SearchIssue(String IssueID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue Where mntID ='" + IssueID + "'");

            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                IssueDetails.add(issue);

            }

            return IssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // delete reported issues
    public static boolean DeleteIssue(String MaintainID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From maintenance_issue WHERE mntID= '" + MaintainID + "' ");
            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // update reported issues
    public static boolean UpdateIssue(String MaintainID, Maintenance_Issue issue) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Update maintenance_issue set issFlag = '" + issue.getIssFlag() + "', issDetail = '" + issue.getIssDetail() + "', issRecDat = '" + issue.getIssRecDat() + "', status = '" + issue.getStatus() + "' where mntID = '" + MaintainID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // get all reported issues
    public static ArrayList<Maintenance_Issue> GetReportedIssues(int BranchID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue where brnID = '" + BranchID + "' and status = 'Reported' or status = 'Complete Confirmation Received By: Supplier' ");

            ArrayList<Maintenance_Issue> AllIssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                AllIssueDetails.add(issue);

            }

            return AllIssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    // get all completed issues
    public static ArrayList<Maintenance_Issue> GetCompletedIssues(int BranchID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue where brnID = '" + BranchID + "' and status = 'Complete Confirmation Received By:Branch' OR status LIKE 'Completed:%' ");

            ArrayList<Maintenance_Issue> AllIssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                AllIssueDetails.add(issue);

            }

            return AllIssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    // get last issue id from the database
    public static ArrayList<Maintenance_Issue> LoadLastIssue() {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue ORDER BY mntID DESC LIMIT 1");

            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                IssueDetails.add(issue);

            }

            return IssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // update issue recorded date
    public static boolean UpdateRecordDate(int MaintainID, String RecDate) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Update maintenance_issue set issRecDat = '" + RecDate + "' where mntID = '" + MaintainID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // update issue ststaus
    public static boolean UpdateStatus(String MaintainID, String Status) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Update maintenance_issue set status = '" + Status + "' where mntID = '" + MaintainID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
    
    
    // get branches issues
     public static ArrayList<Maintenance_Issue> GetOtherBranchesIssues(int BranchID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue where brnID <> '" + BranchID + "' and status = 'Reported' or status = 'Complete Confirmation Received By: Supplier' ");

            ArrayList<Maintenance_Issue> AllIssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                AllIssueDetails.add(issue);

            }

            return AllIssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    
    
    // head office issues search
    public static ArrayList<Maintenance_Issue> SearchIssue_HO(String IssueID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue Where mntID ='" + IssueID + "'");

            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                IssueDetails.add(issue);

            }

            return IssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssuessServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    

}
