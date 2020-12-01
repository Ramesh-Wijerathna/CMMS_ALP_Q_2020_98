/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;

import java.util.logging.Logger;


public class Supplier {
    
        String username;
        String password;
        String supID;
        String supComName;
        String supEmail;
        int conNum;
        String supAddr;

    public Supplier(String username, String password, String supID, String supComName, String supEmail, int conNum, String supAddr)
    {
        this.username = username;
        this.password = password;
        this.supID = supID;
        this.supComName = supComName;
        this.supEmail = supEmail;
        this.conNum = conNum;
        this.supAddr = supAddr;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getSupID()
    {
        return supID;
    }

    public String getSupComName()
    {
        return supComName;
    }

    public String getSupEmail()
    {
        return supEmail;
    }

    public int getConNum()
    {
        return conNum;
    }

    public String getSupAddr()
    {
        return supAddr;
    }
        
        
        

        
    
}
