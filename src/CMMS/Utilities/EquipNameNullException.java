/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Utilities;

/**
 *
 * @author ransa
 */
public class EquipNameNullException extends RuntimeException
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Equipment Name!\n (Equipment Name section can't be empty)";
    }
}
