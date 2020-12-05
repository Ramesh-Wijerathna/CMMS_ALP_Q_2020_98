package CMMS.Models;

/**
 *
 * @author ransa
 */
public class note {
    private String mntID;
    private String supID;
    private String details;
    private float cost;
    private String status;

    public note(String mntID, String supID, String details, float cost, String status) {
        this.mntID = mntID;
        this.supID = supID;
        this.details = details;
        this.cost = cost;
        this.status = status;
    }

    public String getMntID() {
        return mntID;
    }

    public String getSupID() {
        return supID;
    }

    public String getDetails() {
        return details;
    }

    public float getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }
    
}
