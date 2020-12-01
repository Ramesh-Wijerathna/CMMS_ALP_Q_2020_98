/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.ServiceLayer.EquipmentServiceLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ransa
 */
public class InventoryHealthManagement {
    static Connection connection;
    static PreparedStatement pst;
    static Statement stmt;
    static ResultSet rst;
    
    public static String CountIssues ( String invID )
    {
        try {
            //Fetching system time in miliseconds
            long present=System.currentTimeMillis();  
            //Converting system time into sql date type
            java.sql.Date cdate = new java.sql.Date(present) ;
            LocalDate CurrentDate = LocalDate.now();
            //Getting the value of the previous month
            LocalDate EndDate = CurrentDate.minusMonths( 1 );
            java.sql.Date edate;
            //Converting value into sql date type
            edate = java.sql.Date.valueOf( EndDate );
            connection = DatabaseConnection.getInstance().getConnection();
            stmt = connection.createStatement();
            rst  = stmt.executeQuery("SELECT `InID`, COUNT(`InID`) AS 'Count' FROM maintenance_issue WHERE `InID` = '"+invID+"' AND `issRecDat` BETWEEN '"+edate+"' AND '"+cdate+"' GROUP BY `InID`");
            
            int iscount = 0;
            while (rst.next())
            {
                rst.getString(1);
                iscount = rst.getInt(2);
            if ( iscount <= 3 && iscount > 0 )
            {
                return "Good";
            }
            else if ( iscount <= 5 )
            {
                return "Average";
            }
            else if ( iscount > 5 )
            {
                return "Worst";
            }
            }
            if ( iscount == 0 )
            {
                return "Excellent";
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Null";
    }
}
