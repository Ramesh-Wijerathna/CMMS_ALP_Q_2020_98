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
public class EquipInvalidWarrantyDateException extends RuntimeException 
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Warranty Date!\n (Please enter valid Warranty Date)";
    }
}
