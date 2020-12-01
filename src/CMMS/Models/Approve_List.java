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
public class Approve_List {
    String mntID;
    String issFlag;
    String issDetail;
    String issRecDat;
    String status;
    String ApprovalStat;

    public Approve_List(String mntID, String issFlag, String issDetail, String issRecDat, String status, String ApprovalStat) {
        this.mntID = mntID;
        this.issFlag = issFlag;
        this.issDetail = issDetail;
        this.issRecDat = issRecDat;
        this.status = status;
        this.ApprovalStat = ApprovalStat;
    }

    public String getMntID() {
        return mntID;
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
