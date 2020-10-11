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

public class Maintenance_Issue {

    int mntID;
    int brnID;
    int IntID;
    int supID;
    String MntEmail;
    String issFlag;
    String issDetail;
    String issRecDat;
    String status;
    String ApprovalStat;

    public Maintenance_Issue(int mntID, int brnID, int IntID, int supID, String MntEmail, String issFlag, String issDetail, String issRecDat, String status, String ApprovalStat) {
        this.mntID = mntID;
        this.brnID = brnID;
        this.IntID = IntID;
        this.supID = supID;
        this.MntEmail = MntEmail;
        this.issFlag = issFlag;
        this.issDetail = issDetail;
        this.issRecDat = issRecDat;
        this.status = status;
        this.ApprovalStat = ApprovalStat;
    }

    public int getMntID() {
        return mntID;
    }

    public int getBrnID() {
        return brnID;
    }

    public int getIntID() {
        return IntID;
    }

    public int getSupID() {
        return supID;
    }

    public String getMntEmail() {
        return MntEmail;
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
        return status;
    }

    public String getApprovalStat() {
        return ApprovalStat;
    }

    
    
    
    

}
