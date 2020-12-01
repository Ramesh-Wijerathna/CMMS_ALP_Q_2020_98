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

public class Maintenance_Issue {

    String mntID;
    int brnID;
    String invID;
    String supID;
    String mntEmail;
    String issFlag;
    String issDetail;
    String issRecDat;
   
    String issStatus;
    String approveStatus;

    public Maintenance_Issue(String mntID, int brnID, String IntID, String supID, String MntEmail, String issFlag, String issDetail, String issRecDat, String status, String ApprovalStat) {
        this.mntID = mntID;
        this.brnID = brnID;
        this.invID = IntID;
        this.supID = supID;
        this.mntEmail = MntEmail;
        this.issFlag = issFlag;
        this.issDetail = issDetail;
        this.issRecDat = issRecDat;
       
        this.issStatus = status;
        this.approveStatus = ApprovalStat;
    }

    public String getMntID() {
        return mntID;
    }

    public int getBrnID() {
        return brnID;
    }

    public String getIntID() {
        return invID;
    }

    public String getSupID() {
        return supID;
    }

    public String getMntEmail() {
        return mntEmail;
    }

    public String getIssFlag() {
        return issFlag;
    }

    public String getIssDetail() {
        return issDetail;
    }

    public String getIssRecDat() {
        return issRecDat;
    }


    public String getStatus() {
        return issStatus;
    }

    public String getApprovalStat() {
        return approveStatus;
    }

    
    
    
    

}
