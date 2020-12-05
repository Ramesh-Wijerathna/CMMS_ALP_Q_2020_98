package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Inquiry;
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
public class InquirySeviceLayer {
    static Connection connection;
    static PreparedStatement pst;
    static Statement stm;
    static ResultSet rst;
    
    public static ArrayList <Inquiry> GetUnreadMessages ()
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT * FROM `inquiry` WHERE `inqViewStatus` = 'Submitted';");
            
            ArrayList <Inquiry> AllInquiries = new ArrayList<>();
            
            while ( rst.next() )
            {
                Inquiry inq = new Inquiry(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8));
                AllInquiries.add (inq);
            }
            return AllInquiries;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList <Inquiry> GetReadMessages ()
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT * FROM `inquiry` WHERE `inqViewStatus` = 'Read';");
            
            ArrayList <Inquiry> AllReadInquiries = new ArrayList<>();
            
            while ( rst.next() )
            {
                Inquiry inq = new Inquiry(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8));
                AllReadInquiries.add (inq);
            }
            return AllReadInquiries;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static  ArrayList <Inquiry> SearchInquiry ( int key )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rst = stm.executeQuery("SELECT * FROM `inquiry` WHERE `inqID` = "+key+";");
            
            ArrayList <Inquiry> SearchInquiry = new ArrayList<>();
            
            while ( rst.next() )
            {
                Inquiry inq = new Inquiry(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8));
                SearchInquiry.add (inq);
            }
            return SearchInquiry;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InquirySeviceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean updateViewStatus ( int skey )
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            pst = connection.prepareStatement("UPDATE `inquiry` SET `inqViewStatus` = 'Read' WHERE `inquiry`.`inqID` = "+skey+";");
            
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
