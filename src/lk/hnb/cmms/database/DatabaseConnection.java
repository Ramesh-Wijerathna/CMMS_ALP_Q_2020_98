/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hnb.cmms.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rames
 */
public class DatabaseConnection {

    private static DatabaseConnection dbcon;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Class Done");
        Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12364868", "sql12364868", "NBGmt6Kh5h");
        System.out.println("Connection Done");
        connection.setReadOnly(true);
        
        Statement stm = connection.createStatement();
        
        System.out.println("Statement Done");
        
    }

}