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
public class HeadOffice {
   
    String empEmail;
    String empName;
    String empNo;

    public HeadOffice(String empEmail, String empName, String empNo) {
        this.empEmail = empEmail;
        this.empName = empName;
        this.empNo = empNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }
    
    
}
