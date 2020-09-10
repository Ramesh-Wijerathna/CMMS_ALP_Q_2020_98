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
import java.util.Date;
public class Inventory {
    int inID;
    String itemName;
    String model;
    String selialNumber;
    Double itemValue;
    int invNum;
    Date invDate;
    int issCount;

    public Inventory(int inID, String itemName, String model, String selialNumber, Double itemValue, int invNum, Date invDate, int issCount) {
        this.inID = inID;
        this.itemName = itemName;
        this.model = model;
        this.selialNumber = selialNumber;
        this.itemValue = itemValue;
        this.invNum = invNum;
        this.invDate = invDate;
        this.issCount = issCount;
    }

    public int getInID() {
        return inID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getModel() {
        return model;
    }

    public String getSelialNumber() {
        return selialNumber;
    }

    public Double getItemValue() {
        return itemValue;
    }

    public int getInvNum() {
        return invNum;
    }

    public Date getInvDate() {
        return invDate;
    }

    public int getIssCount() {
        return issCount;
    }
    
}
