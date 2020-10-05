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
 * @author ransa
 */
public class DatabaseConnection1 {
    private final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=cmmsdb;user=root;"
            + "password=";
    private Connection conn;
    private static DatabaseConnection1 instance;
    
    private DatabaseConnection1()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DatabaseConnection1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnection1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static DatabaseConnection1 getSingleConnection()
    {
        try
        {
            if (instance == null)
            {
                instance = new DatabaseConnection1();
                return instance;
            } else if (instance.conn.isClosed())
            {
                instance = new DatabaseConnection1();
                return instance;
            } else
            {
                return instance;
            }
        } catch (SQLException ex)
        {
            System.out.println("Error with DB");
            return null;
        }
    }
    
    public boolean ExecuteQuery ( String query )
    {
        try
        {
            Statement st = conn.createStatement();
            int result = st.executeUpdate(query);
            boolean status = (result>0);
            return status;
        } catch (SQLException ex)
        {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
