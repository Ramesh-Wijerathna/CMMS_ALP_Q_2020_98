
package CMMS.Models;

/**
 *
 * @author ransa
 */
public class Inquiry {
    private int inqID;
    private String SupUserName;
    private String name;
    private String email;
    private int conNum;
    private String subject;
    private String message;
    private String status;

    public Inquiry(String SupUserName, String name, String email, int conNum, String subject, String message, String status, int inqID) {
        this.SupUserName = SupUserName;
        this.name = name;
        this.email = email;
        this.conNum = conNum;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.inqID = inqID;
    }

    public String getSupUserName() {
        return SupUserName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getConNum() {
        return conNum;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
    
    public int getInqID() {
        return inqID;
    }
}
