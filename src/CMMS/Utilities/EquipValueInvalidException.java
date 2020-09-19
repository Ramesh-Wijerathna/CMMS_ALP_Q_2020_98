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
public class EquipValueInvalidException extends RuntimeException
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Equipment Value!\n (Equipment Value section can't be empty or please enter valid value)";
    }
}
