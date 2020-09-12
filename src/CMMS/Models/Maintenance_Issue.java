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
    int issFlag;
    String issDetail;
    Date issRecDat;
    Date issExpDat;
    String status;
    String ApprovalStat;

    public Maintenance_Issue(int mntID, int issFlag, String issDetail, Date issRecDat, Date issExpDat, String status, String ApprovalStat) {
        this.mntID = mntID;
        this.issFlag = issFlag;
        this.issDetail = issDetail;
        this.issRecDat = issRecDat;
        this.issExpDat = issExpDat;
        this.status = status;
        this.ApprovalStat = ApprovalStat;
    }

    public int getMntID() {
        return mntID;
    }

    public int getIssFlag() {
        return issFlag;
    }

    public String getIssDetail() {
        return issDetail;
    }

    public Date getIssRecDat() {
        return issRecDat;
    }

    public Date getIssExpDat() {
        return issExpDat;
    }

    public String getStatus() {
        return status;
    }

    public String getApprovalStat() {
        return ApprovalStat;
    }
    
    
}
