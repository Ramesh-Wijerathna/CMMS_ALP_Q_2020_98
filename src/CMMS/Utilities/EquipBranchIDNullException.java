
package CMMS.Utilities;

public class EquipBranchIDNullException extends RuntimeException
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Branch ID!\n (Brancht ID section can't be empty)";
    }
}
