/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.HeadOffice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import CMMS.Models.Supplier;
import static CMMS.ServiceLayer.HeadOfficeServiceLayer.connection;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SupplierServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;

    public static boolean AddSupplier(Supplier s) {

        try {
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

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SupplierServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<Supplier> SearchSupplier(String supId) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From supplier Where supID ='" + supId + "' ");

            ArrayList<Supplier> SupDetails = new ArrayList<>();

            while (rs.next()) {

                Supplier s = new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                SupDetails.add(s);

            }

            return SupDetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean UpdateSupplier(String supID, Supplier s) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("UPDATE supplier SET username='" + s.getUsername() + "', password='" + s.getPassword() + "', supID='" + s.getSupID() + "',supCompName='" + s.getSupComName() + "',supEmal='" + s.getSupComName() + "',supConNum='" + s.getConNum() + "',supAddr='" + s.getSupAddr() + "'  WHERE supID = '" + supID + "'");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static boolean DeleteSupplier(String supID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From supplier WHERE supID= '" + supID + "' ");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
