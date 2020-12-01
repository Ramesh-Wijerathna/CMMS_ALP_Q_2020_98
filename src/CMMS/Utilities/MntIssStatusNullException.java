package CMMS.Utilities;
public class MntIssStatusNullException extends RuntimeException{
    @Override
        public String getLocalizedMessage (){
        return "Invalid Maintenance Issue Status!\n (Status section can't be empty)";
    }
    
}
