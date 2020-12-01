/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.BusinessLayer;

import CMMS.DatabaseLayer.DatabaseConnection;
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
 * @author Work
 */
public class FindMajorStat {

    static Connection connection;
    static PreparedStatement ps;
    static Statement stm;
    static ResultSet rs1;
    
    //Finding Major Issues from DB
    public static ArrayList<Maintenance_Issue> SelectFindMajor() throws SQLException{
    
        try {
            connection = DatabaseConnection.getInstance().getConnection();
            stm = connection.createStatement();
            rs1 = stm.executeQuery("SELECT * From maintenance_issue where issFlag='Major'");
            
            ArrayList<Maintenance_Issue> IssueDetails = new ArrayList<>();
            
            while (rs1.next()) {
                
                Maintenance_Issue approve = new Maintenance_Issue(rs1.getString(1), rs1.getInt(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10));
                IssueDetails.add(approve);
            }
            
            return IssueDetails;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindMajorStat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FindMajorStat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
}
