/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.BusinessLayer.RegionManagerBusinessLayer;
import CMMS.Models.RegionManager;
import CMMS.DatabaseLayer.*;
import CMMS.Models.Branch;

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
 * @author User
 */
public class RegionManagerServiceLayer
{

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;

    public static boolean AddRegionManager(RegionManager r) throws ClassNotFoundException
    {

        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into regionmanager(username,password,rmID,rmName,rmEmail,rmConNum,rmRegionID,availableDay) values(?,?,?,?,?,?,?,?)");

            ps.setObject(1, r.getUsername());
            ps.setObject(2, r.getPassword());
            ps.setObject(3, r.getRmID());
            ps.setObject(4, r.getRmName());
            ps.setObject(5, r.getRmEmail());
            ps.setObject(6, r.getConNum());
            ps.setObject(7, r.getRmRrgID());
            ps.setObject(8, r.getAvailableDay());

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    //Select Major maintenance issues
    public static String date;

    public static String findMajorIssue()
    {

        String mntid = "";
        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("SELECT * FROM `maintenance_issue` WHERE `issFlag`='Major'");

            while (rs.next())
            {
                mntid = rs.getString("mntID");
                date = rs.getString("issRecDat");
            }
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mntid;
    }

    //Find Branch ID using Maintenance Issue ID
    public static int findbranchID(String key)
    {
        int id = 0;
        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("SELECT * FROM `maintenance_issue` WHERE `mntID`='" + key + "'");
            if (rs != null)
            {
                System.out.println("Got Branch ID");
            } else
            {
                System.out.println("couldn't get Branch ID");
            }

            while (rs.next())
            {
                id = rs.getInt("brnID");
            }

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RegionManagerBusinessLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerBusinessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    //Find Region ID using Branch ID
    public static int findRegionID(int id)
    {
        int result = 0;

        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();

            rs = stm.executeQuery("SELECT * FROM `branch` WHERE `brnID`='" + id + "'");

            if (rs != null)
            {
                System.out.println("Got Region ID");
            } else
            {
                System.out.println("Couldn't Get Region ID");
            }

            while (rs.next())
            {
                int rgID = rs.getInt("BrnRegionID");

                result = rgID;

            }
        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }
    
  
    public static ArrayList<String> findRegionManagers(int id, String day)
    {

        ArrayList<String> managers = new ArrayList<>();

        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            
            System.out.println("Looking for area : "+id+" and available on : "+day);

            rs = stm.executeQuery("SELECT * FROM `regionmanager` WHERE `rmRegionID`='" + id + "' and `availableDay`='" + day + "'");

            if (rs != null)
            {
                System.out.println("Got Managers");
            } else
            {
                System.out.println("Couldn't Get Managers");
            }

            while (rs.next())
            {
                managers.add(rs.getString("rmID"));

            }

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return managers;

    }

    public static boolean saveToTable(String issueID,int brnID, String issueReportedDate, int issueReportedRegionID, String assignedRMID)
    {

        boolean result = false;
        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into assignregionmanager values(?,?,?,?,?)");

            ps.setObject(1, issueID);
            ps.setObject(2, brnID);
            ps.setObject(3, issueReportedDate);
            ps.setObject(4, issueReportedRegionID);
            ps.setObject(5, assignedRMID);

            result = ps.executeUpdate() > 0;

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(RegionManagerServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }
    
    
    //Manage Region Manager Section
        public static ArrayList<RegionManager> SearchRM(String rmID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From regionmanager Where rmID ='" + rmID + "' ");

            ArrayList<RegionManager> rmDetails = new ArrayList<>();

            while (rs.next()) {

                RegionManager r = new RegionManager(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8));
                rmDetails.add(r);

            }

            return rmDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

        
            public static boolean UpdateRM(String rmID, RegionManager r) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("UPDATE regionmanager SET username='" + r.getUsername() + "', password='" + r.getPassword() + "', rmID='" + r.getRmID() + "',rmName='" + r.getRmName() + "',rmEmail='" + r.getRmEmail() + "',rmConNum='" + r.getConNum() + "',rmRegionID='" + r.getRmRrgID() + "',availableDay='" + r.getAvailableDay() + "'  WHERE rmID = '" + rmID + "'");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static boolean DeleteRM(String rmID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From regionmanager WHERE rmID= '" + rmID + "' ");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
