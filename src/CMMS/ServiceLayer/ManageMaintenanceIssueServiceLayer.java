/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Approve_List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kavin
 */
public class ManageMaintenanceIssueServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;
    public static ArrayList<Approve_List> SearchIssue;

    public static void ReportMntIssue(Approve_List mi) {
        try {

            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Insert into testme values(?,?,?,?,?,?)");

            ps.setObject(1, mi.getMntID());
            ps.setObject(2, mi.getIssFlag());
            ps.setObject(3, mi.getIssDetail());
            ps.setObject(4, mi.getIssRecDat());
            ps.setObject(5, mi.getStatus());
            ps.setObject(6, mi.getApprovalStat());

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMaintenanceIssueServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Update Issue Button, Manage Maintain Panel, Update DB from Reg Mgr
    public static boolean UpdateMntIssue(String mntID, Approve_List mo) throws SQLException {

        try {

            connection = DatabaseConnection.getInstance().getConnection();

            String pattern = "yyyy/MM/dd";
            String dateInString = new SimpleDateFormat(pattern).format(new Date());

            ps = connection.prepareStatement("UPDATE maintenance_issue SET mntID='" + mo.getMntID() + "', issFlag='" + mo.getIssFlag() + "', issDetail='" + mo.getIssDetail() + "',issRecDat='" + dateInString + "',status='" + mo.getStatus() + "',approvalStat='" + mo.getApprovalStat() + "'  WHERE mntID = '" + mntID + "'");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(ManageMaintenanceIssueServiceLayer.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }
    
    //Update Issue Button, Manage Maintain Panel, Remove Loged in Reg Mgr and Approvedstat
    public static boolean UpdateRMEmail(String mntID, String email) throws SQLException {

        try {

            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("UPDATE maintenance_issue SET mntEmail='" + email + "'  WHERE mntID = '" + mntID + "'");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(ManageMaintenanceIssueServiceLayer.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

    //Delete Issue Button, Manage Maintain Panel, Delete a maintenance issue
    public static boolean DeleteMntIssue(String mntID) {

        try {

            connection = DatabaseConnection.getInstance().getConnection();

            ps = connection.prepareStatement("Delete From maintenance_issue WHERE mntID= '" + mntID + "' ");

            boolean result = ps.executeUpdate() > 0;

            return result;

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(ManageMaintenanceIssueServiceLayer.class.getName()).log(Level.SEVERE, null, ex);

        }

        return false;

    }

    //Search Button, Manage Maintain Panel, Search a maintenance issue
    public static ArrayList<Approve_List> SearchMntIssue(String mntID) throws SQLException, ClassNotFoundException {

        connection = DatabaseConnection.getInstance().getConnection();
        stm = connection.createStatement();
        rs = stm.executeQuery("SELECT * FROM maintenance_issue WHERE mntID='" + mntID + "'");

        ArrayList<Approve_List> IssueDetails = new ArrayList<>();

        while (rs.next()) {

            Approve_List issue = new Approve_List(rs.getString(1), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            IssueDetails.add(issue);
        }

        return IssueDetails;
    }
}
