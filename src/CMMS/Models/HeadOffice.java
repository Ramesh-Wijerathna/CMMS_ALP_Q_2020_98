/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;


public class HeadOffice {
   
    String userName;
    String password;
    String empID;
    String empName;
    String empEmail;

    public HeadOffice(String userName, String password, String empID, String empName, String empEmail)
    {
        this.userName = userName;
        this.password = password;
        this.empID = empID;
        this.empName = empName;
        this.empEmail = empEmail;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmpID()
    {
        return empID;
    }

    public String getEmpName()
    {
        return empName;
    }

    public String getEmpEmail()
    {
        return empEmail;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmpID(String empID)
    {
        this.empID = empID;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public void setEmpEmail(String empEmail)
    {
        this.empEmail = empEmail;
    }
    
    

    
    
}
