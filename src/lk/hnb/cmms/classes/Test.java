/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hnb.cmms.classes;

/**
 *
 * @author kavin
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.hnb.cmms.classes.DatabaseConnection;
public class Test {
    
//     public static boolean AssignDoc() {
//        try {
//            Connection connection = DatabaseConnection.getInstance().getConnection();
//            PreparedStatement pstm = connection.prepareStatement("Insert into HeadOffice values (?,?,?)");
//
//            pstm.setObject(1, "HNB@gmail.com");
//            pstm.setObject(2, "HNB");
//            pstm.setObject(3, "HNB123");
//          
//
//            boolean result = pstm.executeUpdate() > 0;
//            return result;
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//
//    }
    
    
    
    public static void main(String[] args) {
      
        
     DatabaseConnection connection = new DatabaseConnection();
     
        
        
    }
    
    
    
    
    
    
    
    
}
