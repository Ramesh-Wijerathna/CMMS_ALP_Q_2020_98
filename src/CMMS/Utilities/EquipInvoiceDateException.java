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
public class EquipInvoiceDateException extends RuntimeException 
{
    @Override
    public String getLocalizedMessage ()
    {
        return "Invalid Equipment Invoice Date!\n (Equipment Invoice Date section can't be empty)";
    }
}
