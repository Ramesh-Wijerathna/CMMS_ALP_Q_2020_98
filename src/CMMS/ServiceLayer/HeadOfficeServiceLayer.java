/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Branch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import CMMS.Models.HeadOffice;
import static CMMS.ServiceLayer.BranchServiceLayer.connection;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class HeadOfficeServiceLayer
{
    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;

    public static boolean AddHeadOfficeUser(HeadOffice h) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("insert into headoffice(username,password,empID,empName,empEmail) values(?,?,?,?,?)");

            ps.setObject(1, h.getUserName());
            ps.setObject(2, h.getPassword());
            ps.setObject(3, h.getEmpID());
            ps.setObject(4, h.getEmpName());
            ps.setObject(5, h.getEmpEmail());

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ArrayList<HeadOffice> SearchHO(String empId) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs = stm.executeQuery("Select * From headoffice Where empID ='" + empId + "' ");

            ArrayList<HeadOffice> HODetails = new ArrayList<>();

            while (rs.next()) {

                HeadOffice h = new HeadOffice(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                HODetails.add(h);

            }

            return HODetails;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
        public static boolean UpdateHO(String empID, HeadOffice h) {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("UPDATE headoffice SET username='" + h.getUserName() + "', password='" + h.getPassword() + "', empID='" + h.getEmpID() + "',empName='" + h.getEmpName() + "',empEmail='" + h.getEmpEmail()+ "'  WHERE empID = '" + empID + "'");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
        
        public static boolean DeleteHO(String empID) {

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("Delete From headoffice WHERE empID= '" + empID + "' ");

            boolean result = ps.executeUpdate() > 0;
            return result;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BranchServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    
}
