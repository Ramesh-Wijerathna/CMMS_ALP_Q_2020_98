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
public class Maintenance_Officer {
    String mntEmail;
    String mntName;
    String mntAddr;
    int mntConNum;
    int mntRegionID;

    public Maintenance_Officer(String mntEmail, String mntName, String mntAddr, int mntConNum, int mntRegionID) {
        this.mntEmail = mntEmail;
        this.mntName = mntName;
        this.mntAddr = mntAddr;
        this.mntConNum = mntConNum;
        this.mntRegionID = mntRegionID;
    }

    public String getMntEmail() {
        return mntEmail;
    }

    public String getMntName() {
        return mntName;
    }

    public String getMntAddr() {
        return mntAddr;
    }

    public int getMntConNum() {
        return mntConNum;
    }

    public int getMntRegionID() {
        return mntRegionID;
    }
    
    
}
