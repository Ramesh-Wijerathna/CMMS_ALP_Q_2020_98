package CMMS.Utilities;
public class MntIssIDlNullException extends RuntimeException{
    
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Maintenance ID!\n (Maintenance ID section can't be empty)";
    }
    
}
