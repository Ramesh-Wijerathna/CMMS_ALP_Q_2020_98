/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Inventory;
import java.sql.Connection;
import java.sql.Date;
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
public class EquipmentServiceLayer {
    
    static Connection connection;
    static PreparedStatement pst;
    static Statement stmt;
    static ResultSet rst;
    
    public static boolean AddEquipment(Inventory inv){
        
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            pst = connection.prepareStatement("INSERT INTO `inventory` (`invID`, `itmName`, `model`, `serialNo`, `value`, `invNo`, `brnID`, `supID`, `warrantyExpDate`, `invDate`, `issueCount`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            pst.setObject(1, inv.getInID());
            pst.setObject(2, inv.getItemName());
            pst.setObject(3, inv.getModel());
            pst.setObject(4, inv.getSelialNumber());
            pst.setObject(5, inv.getItemValue());
            pst.setObject(6, inv.getInvNum());
            pst.setObject(7, inv.getBrnID());
            pst.setObject(8, inv.getSupID());
            pst.setObject(9, inv.getWarntDate());
            pst.setObject(10, inv.getInvDate());
            pst.setObject(11, inv.getIssCount());
            
            boolean result = pst.executeUpdate() > 0;
            return result;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static boolean UpdateEquipment (String invID, Inventory inv1 ) {
        
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            java.sql.Date wdate = new java.sql.Date (inv1.getWarntDate().getTime());
            java.sql.Date indate = new java.sql.Date ( inv1.getInvDate().getTime());
            pst = connection.prepareStatement("UPDATE `inventory` SET `itmName`='" + inv1.getItemName() + "' ,`model`= '" + inv1.getModel() + "' ,`serialNo`= '" + inv1.getSelialNumber() + "' ,`value`= " + inv1.getItemValue() + ",`invNo`= '" + inv1.getInvNum() + "' ,`brnID`=" + inv1.getBrnID() + ", `supID`='" + inv1.getSupID() + "',`warrantyExpDate`= '" + wdate + "',`invDate`= '" + indate + "',`issueCount`=" + inv1.getIssCount() + " WHERE `invID`= '" + invID + "'");
            
            boolean result = pst.executeUpdate() > 0;
            return result;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean DeleteEquipment (String invID1)
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            pst = connection.prepareStatement("DELETE FROM `inventory` WHERE  `invID` = '" + invID1 + "'" );
        
        boolean result = pst.executeUpdate() > 0;
        return result;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ArrayList<Inventory> SearchEquipment (String invID2)
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stmt = connection.createStatement();
            rst = stmt.executeQuery("SELECT * FROM `inventory` WHERE `invID` = '" + invID2 + "'" );
            
            ArrayList<Inventory> InventoryDetails = new ArrayList<>();
            
            while (rst.next()) {
                Inventory inv = new Inventory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getInt(7), rst.getString(8), rst.getDate(9), rst.getDate(10), rst.getInt(11));
                InventoryDetails.add(inv);
            }
            return InventoryDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Inventory> GetAllEquipments ()
    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stmt = connection.createStatement();
            rst  = stmt.executeQuery("SELECT * FROM `inventory`");
            
            ArrayList <Inventory> AllequipmentDetails = new ArrayList<>();
            
            while (rst.next())
            {
                Inventory eqp = new Inventory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getString(6), rst.getInt(7), rst.getString(8), rst.getDate(9), rst.getDate(10), rst.getInt(11));
                AllequipmentDetails.add(eqp);
            }
            return AllequipmentDetails;
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
