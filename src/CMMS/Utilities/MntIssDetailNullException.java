package CMMS.Utilities;
public class MntIssDetailNullException extends RuntimeException{
    @Override
    public String getLocalizedMessage (){
   
        return "Invalid Maintenance Issue Details!\n (Issue Details section can't be empty)";
    }
    
}
