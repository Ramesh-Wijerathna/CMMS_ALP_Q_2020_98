/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Branch;
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
public class BranchServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;

    public static boolean AddBranch(Branch b) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into Branch values(?,?,?,?,?,?,?)");

            ps.setObject(1, b.getBrnID());
            ps.setObject(2, b.getBrnAddr());
            ps.setObject(3, b.getBrnConNum());
            ps.setObject(4, b.getBrnEmail());
            ps.setObject(5, b.getUserName());
            ps.setObject(6, b.getPassword());
            ps.setObject(7, b.getBrnRegionID());

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Branch> SearchBranch(int BranchId) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From Branch Where ID ='" + BranchId + "' ");

            ArrayList<Branch> BranchDetails = new ArrayList<>();

            while (rs.next()) {

                Branch b = new Branch(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                BranchDetails.add(b);

            }

            return BranchDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean UpdateBranch(int BranchID, Branch b) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("UPDATE Branch SET BrnAddr='" + b.getBrnAddr() + "', BrnConNum='" + b.getBrnConNum() + "', BrnEmail='" + b.getBrnEmail() + "',BrnUserName='" + b.getUserName() + "',BrnPassword='" + b.getPassword() + "',BrnRegionID='" + b.getBrnRegionID() + "'  WHERE ID = '" + BranchID + "'");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static boolean DeleteBranch(int BranchID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From Branch WHERE ID= '" + BranchID + "' ");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

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
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static ArrayList<Maintenance_Issue> SearchIssue(int IssueID, int BranchID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue Where mntID ='" + IssueID + "' and brnID = '" + BranchID + "'");

            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                IssueDetails.add(issue);

            }

            return IssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean DeleteIssue(int MaintainID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From maintenance_issue WHERE mntID= '" + MaintainID + "' ");
            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean UpdateIssue(int MaintainID, Maintenance_Issue issue) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Update maintenance_issue set issFlag = '" + issue.getIssFlag() + "', issDetail = '" + issue.getIssDetail() + "', issRecDat = '" + issue.getIssRecDat() + "', status = '" + issue.getStatus() + "' where mntID = '" + MaintainID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
    public static ArrayList<Maintenance_Issue> GetAllIssues (int BranchID){
        
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From maintenance_issue where brnID = '"+BranchID+"' ");

            ArrayList<Maintenance_Issue> AllIssueDetails = new ArrayList<>();

            while (rs.next()) {

                Maintenance_Issue issue = new Maintenance_Issue(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                AllIssueDetails.add(issue);

            }

            return AllIssueDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    
    
    
    public static boolean UpdateRecordDate(int MaintainID, String RecDate) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Update maintenance_issue set issRecDat = '" + RecDate + "' where mntID = '" + MaintainID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
    
    
    
}
