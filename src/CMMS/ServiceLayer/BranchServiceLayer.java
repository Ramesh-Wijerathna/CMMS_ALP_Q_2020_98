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
            rs = stm.executeQuery("Select * From branch Where BrnID ='" + BranchId + "' ");

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
            ps = connection.prepareStatement("UPDATE branch SET BrnAddr='" + b.getBrnAddr() + "', BrnConNum='" + b.getBrnConNum() + "', BrnEmail='" + b.getBrnEmail() + "',username='" + b.getUserName() + "',password='" + b.getPassword() + "',BrnRegionID='" + b.getBrnRegionID() + "'  WHERE BrnID = '" + BranchID + "'");

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
            ps = connection.prepareStatement("Delete From branch WHERE BrnID= '" + BranchID + "' ");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
}
