package CMMS.Utilities;
public class MntIssRecDatNullException extends RuntimeException{
    @Override
        public String getLocalizedMessage (){
        return "Invalid Maintenance Issue Record Date!\n (Record Date section can't be empty)";
    }
    
}
