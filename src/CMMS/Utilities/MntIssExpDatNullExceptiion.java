package CMMS.Utilities;
public class MntIssExpDatNullExceptiion extends RuntimeException{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Maintenance Issue Expire Date!\n (Expire Date section can't be empty)";
    }
}
