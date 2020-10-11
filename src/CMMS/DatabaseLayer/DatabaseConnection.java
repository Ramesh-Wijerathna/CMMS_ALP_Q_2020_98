/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rames
 */
public class DatabaseConnection {

    private Connection connection;
    private static DatabaseConnection dbcon;

    private DatabaseConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Done");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/cmmsnew", "root", "");
            System.out.println("Connection Done");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static DatabaseConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dbcon == null) {
            dbcon = new DatabaseConnection();
        }
        return dbcon;
    }

    public Connection getConnection() {
        return connection;
    }

}
