/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CMMS.Models.Maintenance_Issue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kavin
 */
public class ApproveServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs1;

    //Search Button, Approve Panel, Search maintenance issue
    public static ArrayList<Maintenance_Issue> SelectApprove(String mntID) throws SQLException, ClassNotFoundException {

        connection = DatabaseConnection.getInstance().getConnection();
        stm = connection.createStatement();
        rs1 = stm.executeQuery("SELECT * FROM maintenance_issue WHERE mntID='" + mntID + "'");

        ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();

        while (rs1.next()) {

            Maintenance_Issue approve = new Maintenance_Issue(rs1.getString(1), rs1.getInt(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10));
            IssueDetails.add(approve);
        }

        return IssueDetails;
    }

    public static ArrayList<Maintenance_Issue> DisplayApproveList() throws SQLException, ClassNotFoundException {

        connection = DatabaseConnection.getInstance().getConnection();
        stm = connection.createStatement();
        rs1 = stm.executeQuery("SELECT * FROM maintenance_issue"/*"WHERE mntID='mntID'"*/);

        ArrayList<Maintenance_Issue> Approvel = new ArrayList<>();

        while (rs1.next()) {

            Maintenance_Issue approve = new Maintenance_Issue(rs1.getString(1), rs1.getInt(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10));
            Approvel.add(approve);
        }

        return Approvel;
    }

    public static boolean UpdateApprovel(String mntID, String stat) throws SQLException {

        try {

            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("UPDATE maintenance_issue SET approvalStat='" + stat + "'  WHERE mntID = '" + mntID + "'");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(ManageMaintenanceIssueServiceLayer.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }
    
    public static ArrayList<Maintenance_Issue> FindApproved() throws SQLException{
    
        
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs1 = stm.executeQuery("SELECT * From maintenance_issue where approvalStat='Approved'");
            
            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();
            
            while (rs1.next()) {
                
                Maintenance_Issue approve = new Maintenance_Issue(rs1.getString(1), rs1.getInt(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10));
                IssueDetails.add(approve);
            }
            
            return IssueDetails;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApproveServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
}
