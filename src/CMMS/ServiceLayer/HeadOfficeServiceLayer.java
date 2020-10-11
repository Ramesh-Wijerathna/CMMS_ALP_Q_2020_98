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
import CMMS.Models.HeadOffice;

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
}
