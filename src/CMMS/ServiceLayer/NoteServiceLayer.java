package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.note;
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
 * @author ransa
 */
public class NoteServiceLayer {
    static Connection connection;
    static PreparedStatement pst;
    static Statement stm;
    static ResultSet rst;
    
    public static ArrayList <note> GetUnreadNote ( int brID )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT n.`mntID`, n.`supID`, n.`note`, n.`cost`,n.`noteViewStatus`, m.`brnID` FROM `maintenance_issue` m, `note` n WHERE m.`mntID` = n.`mntID` AND m.`brnID` = "+brID+" AND `noteViewStatus` = 'Submitted' GROUP BY m.`brnID`;");
            
            ArrayList<note> AllnoteDetails = new ArrayList<>();
            
            while ( rst.next() )
            {
                note nt = new note(rst.getString(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5));
                AllnoteDetails.add(nt);
            }
            return AllnoteDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList <note> GetUpdateNote ( int brID )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT n.`mntID`, n.`supID`, n.`note`, n.`cost`,n.`noteViewStatus`, m.`brnID` FROM `maintenance_issue` m, `note` n WHERE m.`mntID` = n.`mntID` AND m.`brnID` = "+brID+" AND `noteViewStatus` = 'Updated' GROUP BY m.`brnID`;");
            
            ArrayList<note> AllUpdatednoteDetails = new ArrayList<>();
            
            while ( rst.next() )
            {
                note nt = new note(rst.getString(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5));
                AllUpdatednoteDetails.add(nt);
            }
            return AllUpdatednoteDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList <note> GetReadNote ( int brID )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT n.`mntID`, n.`supID`, n.`note`, n.`cost`,n.`noteViewStatus`, m.`brnID` FROM `maintenance_issue` m, `note` n WHERE m.`mntID` = n.`mntID` AND m.`brnID` = "+brID+" AND `noteViewStatus` = 'Read' GROUP BY m.`brnID`;");
            
            ArrayList<note> AllReadnoteDetails = new ArrayList<>();
            
            while ( rst.next() )
            {
                note nt = new note(rst.getString(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5));
                AllReadnoteDetails.add(nt);
            }
            return AllReadnoteDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList <note> SearchNote ( String mntID, int brID )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT n.`mntID`, n.`supID`, n.`note`, n.`cost`,n.`noteViewStatus`, m.`brnID` FROM `maintenance_issue` m, `note` n WHERE m.`mntID` = n.`mntID` AND m.`brnID` = "+brID+" AND n.`mntID` = '"+mntID+"' GROUP BY m.`brnID`;");
            
            ArrayList<note> AllSearchnoteDetails = new ArrayList<>();
            
            while ( rst.next() )
            {
                note nt = new note(rst.getString(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5));
                AllSearchnoteDetails.add(nt);
            }
            return AllSearchnoteDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NoteServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean updateViewStatus ( String mntID )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            pst = connection.prepareStatement("UPDATE `note` SET `noteViewStatus`='Read' WHERE `mntID` = '"+mntID+"';");
            
            boolean result = pst.executeUpdate() > 0;
            return result;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
