package CMMS.Utilities;
public class MntIssFlagNullException extends RuntimeException{
    @Override
    public String getLocalizedMessage (){
    
        return "Invalid Maintenance Issue Flag!\n (Issue Flag section can't be empty)";
    }
    
}
