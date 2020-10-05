/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;

/**
 *
 * @author kavin
 */
import java.util.Date;
public class Inventory {
    private String inID;
    private String itemName;
    private String model;
    private String selialNumber;
    private int itemValue;
    private String invNum;
    private int supID;
    private int brnID;
    private Date invDate;
    private Date WarntDate;
    private int issCount;

    public Inventory(String inID, String itemName, String model, String selialNumber, int itemValue, String invNum, int supID, int brnID, Date WarntDate, Date invDate, int issCount) {
        this.inID = inID;
        this.itemName = itemName;
        this.model = model;
        this.selialNumber = selialNumber;
        this.itemValue = itemValue;
        this.invNum = invNum;
        this.supID = supID;
        this.brnID = brnID;
        this.WarntDate = WarntDate;
        this.invDate = invDate;
        this.issCount = issCount;
    }

    public String getInID() {
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

    public int getItemValue() {
        return itemValue;
    }

    public String getInvNum() {
        return invNum;
    }

    public int getSupID() {
        return supID;
    }

    public int getBrnID() {
        return brnID;
    }

    public Date getWarntDate() {
        return WarntDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public int getIssCount() {
        return issCount;
    }
    
}
