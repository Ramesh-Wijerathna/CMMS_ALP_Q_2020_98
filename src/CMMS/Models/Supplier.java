/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;

import java.util.logging.Logger;

/**
 *
 * @author kavin
 */
public class Supplier {
    String sup_ID;
    String compName;
    String supEmail;
    int supConNum;
    String supAddress;

    public Supplier(String sup_ID, String compName, String supEmail, int supConNum, String supAddress) {
        this.sup_ID = sup_ID;
        this.compName = compName;
        this.supEmail = supEmail;
        this.supConNum = supConNum;
        this.supAddress = supAddress;
    }

    public String getSup_ID() {
        return sup_ID;
    }

    public String getCompName() {
        return compName;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public int getSupConNum() {
        return supConNum;
    }

    public String getSupAddress() {
        return supAddress;
    }
    
    
}
