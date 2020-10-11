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
import java.util.logging.Level;
import java.util.logging.Logger;
import CMMS.Models.Supplier;

/**
 *
 * @author User
 */
public class SupplierServiceLayer
{
    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;
    
    public static boolean AddSupplier(Supplier s){
            
        try
        {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into supplier(username,password,supID,supCompName,supEmal,supConNum,supAddr) values(?,?,?,?,?,?,?)");
            
            ps.setObject(1, s.getUsername());
            ps.setObject(2, s.getPassword());
            ps.setObject(3, s.getSupID());
            ps.setObject(4, s.getSupComName());
            ps.setObject(5, s.getSupEmail());
            ps.setObject(6, s.getConNum());
            ps.setObject(7, s.getSupAddr());
            
            boolean result = ps.executeUpdate() > 0;
            return result;
            
            
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(SupplierServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
