
package CMMS.Utilities;

public class EquipSupIDNullException extends RuntimeException 
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Supplier ID!\n (Supplier ID section can't be empty)";
    }
}
