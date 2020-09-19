package CMMS.Utilities;

public class EquipIDNullException extends RuntimeException 
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Equipment ID!\n (Equipment ID section can't be empty)";
    }
}
