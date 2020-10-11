/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.ServiceLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
import CMMS.Models.Branch;
import CMMS.Models.Maintenance_Issue;
import static CMMS.ServiceLayer.BranchServiceLayer.rs;
import static CMMS.ServiceLayer.BranchServiceLayer.stm;
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
public class ApproveServiceLayer {
    
    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs;
    
    public static ArrayList<Maintenance_Issue> GetAllIssues(){
        
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
             rs = stm.executeQuery("Select * From maintenance_issue");
             
            
            ArrayList<Maintenance_Issue> IssueList = new ArrayList<>();
            
            
             while (rs.next()) {

                Maintenance_Issue b;
               // b = new Maintenance_Issue(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getDate(8),rs.getDate(9),rs.getString(10),rs.getString(11));
                // IssueList.add(b);

            }
            
            return IssueList;
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ApproveServiceLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
