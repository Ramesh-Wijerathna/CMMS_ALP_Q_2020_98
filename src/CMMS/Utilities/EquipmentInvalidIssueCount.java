
package CMMS.Utilities;

public class EquipmentInvalidIssueCount extends RuntimeException {
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Equipment Issue Count!\n (Equipment Issue Count section can't be empty)";
    }
    
}
