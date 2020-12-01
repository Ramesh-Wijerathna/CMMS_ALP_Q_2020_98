/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

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
 * @author Work
 */
public class FindLogedRegionMgr {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs1, rs2;

    //Approve Button, Approve Panel, Find and Allocate loged in Region Manager
    public static void SelectFindLoged(String mntID) {
        String email = null;
        String rmEmail = "";

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs2 = stm.executeQuery("SELECT * FROM `assignregionmanager` WHERE `IssueID` ='" + mntID + "'");

            //ArrayList<ApproveList> IssueDetails = new ArrayList<>();

            /*for (Maintenance_Issue al : IssueDetails) {
                rs1.getString(5);
            }*/
            while (rs2.next()) {
                email = rs2.getString("AssignedRegionManagerID");
            }
            //System.out.println(email);
            
            rs1 = stm.executeQuery("SELECT * FROM `regionmanager` WHERE `rmID` ='" + email + "'");
            while (rs1.next()) {
                rmEmail = rs1.getString("rmEmail");
            }
            //System.out.println(rmEmail);

            ps = connection.prepareStatement("UPDATE maintenance_issue SET `mntEmail`='" + rmEmail + "' WHERE `mntID`='" + mntID + "'");
            boolean result = false;
            result = ps.executeUpdate() > 0;

            //return IssueDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindMajorStat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FindMajorStat.class.getName()).log(Level.SEVERE, null, ex);
        }

        //return null;
    }

}
