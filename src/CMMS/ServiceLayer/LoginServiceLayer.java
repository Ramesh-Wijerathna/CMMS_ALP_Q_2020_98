/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import static CMMS.ServiceLayer.BranchServiceLayer.connection;
import static CMMS.ServiceLayer.RegionManagerServiceLayer.date;
import static CMMS.ServiceLayer.RegionManagerServiceLayer.ps;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceLayer {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;

    public static String[] searchEmail(String email) {
        String password = null;
        String table = null;

        String[] results = new String[2];

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();

            rs = stm.executeQuery("select * from `headoffice` where `empEmail`='" + email + "'");
            while (rs.next()) {
                password = rs.getString("password");
            }
            table = "headoffice";
            if (password == null) {
                rs = stm.executeQuery("select * from `regionmanager` where `rmEmail`='" + email + "'");
                while (rs.next()) {
                    password = rs.getString("password");
                }
                table = "regionmanager";
                if (password == null) {
                    rs = stm.executeQuery("select * from `branch` where `brnEmail`='" + email + "'");
                    while (rs.next()) {
                        password = rs.getString("password");
                    }
                    table = "branch";

                }

            }
            if (password == null) {
                System.out.println("Please enter valid Email Address");
                table = null;
            }

            results[0] = password;
            results[1] = table;

            System.out.println(table);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;

    }

    public static boolean saveLoginData(String email, String table) {
        boolean result = false;
        try {

            String userID = "";

            //Generate current date & time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String[] dateTime = new String[2];
            dateTime = dtf.format(now).split(" ");

            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();

            if (table.equals("headoffice")) {
                rs = stm.executeQuery("select * from `headoffice` where `empEmail`='" + email + "'");
                while (rs.next()) {
                    userID = rs.getString("empID");
                }

                ps = connection.prepareStatement("insert into logintable (userType,userID,loggedDate,loggedTime,loggedOutTime) values(?,?,?,?,?)");
                ps.setObject(1, table);
                ps.setObject(2, userID);
                ps.setObject(3, dateTime[0]);
                ps.setObject(4, dateTime[1]);
                ps.setObject(5, "processing");

                result = ps.executeUpdate() > 0;

            } else {
                if (table.equals("branch")) {

                    rs = stm.executeQuery("select * from `branch` where `BrnEmail`='" + email + "'");
                    while (rs.next()) {
                        userID = rs.getString("BrnID");
                    }

                    ps = connection.prepareStatement("insert into logintable (userType,userID,loggedDate,loggedTime,loggedOutTime) values(?,?,?,?,?)");
                    ps.setObject(1, table);
                    ps.setObject(2, userID);
                    ps.setObject(3, dateTime[0]);
                    ps.setObject(4, dateTime[1]);
                    ps.setObject(5, "processing");

                    result = ps.executeUpdate() > 0;

                } else {
                    if (table.equals("regionmanager")) {

                        rs = stm.executeQuery("select * from `regionmanager` where `rmEmail`='" + email + "'");
                        while (rs.next()) {
                            userID = rs.getString("rmID");
                        }

                        ps = connection.prepareStatement("insert into logintable (userType,userID,loggedDate,loggedTime,loggedOutTime) values(?,?,?,?,?)");
                        ps.setObject(1, table);
                        ps.setObject(2, userID);
                        ps.setObject(3, dateTime[0]);
                        ps.setObject(4, dateTime[1]);
                        ps.setObject(5, "processing");

                        result = ps.executeUpdate() > 0;

                    } else {
                        result = false;
                    }
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static boolean saveLogoutTime() {
        boolean result = false;
        String time = null;
        int logNum=0;
        try {
            rs = stm.executeQuery("select MAX(`logNumber`) from `logintable`");
            while (rs.next()) {
                logNum = rs.getInt(1);
            }

            System.out.println(logNum);
            //Generate current date & time
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String[] dateTime = new String[2];
            dateTime = dtf.format(now).split(" ");
            time = dateTime[1];

            connection = DatabaseConnection.getInstance().getConnection();
            ps = connection.prepareStatement("UPDATE logintable SET loggedOutTime='" + time + "' WHERE logNumber = '" + logNum + "'");

            result = ps.executeUpdate() > 0;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
