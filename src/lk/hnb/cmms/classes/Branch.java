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
public class Branch {
    int brnID;
    String brnAddr;
    int brnConNum;
    String brnEmail;
    private String userName;
    private String password;
    int brnRegionID;

    public Branch(int brnID, String brnAddr, int brnConNum, String brnEmail, String userName, String password, int brnRegionID) {
        this.brnID = brnID;
        this.brnAddr = brnAddr;
        this.brnConNum = brnConNum;
        this.brnEmail = brnEmail;
        this.userName = userName;
        this.password = password;
        this.brnRegionID = brnRegionID;
    }

    public int getBrnID() {
        return brnID;
    }

    public String getBrnAddr() {
        return brnAddr;
    }

    public int getBrnConNum() {
        return brnConNum;
    }

    public String getBrnEmail() {
        return brnEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getBrnRegionID() {
        return brnRegionID;
    }
    
    
}

