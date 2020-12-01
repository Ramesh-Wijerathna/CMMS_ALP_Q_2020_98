/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;

/**
 *
 * @author User
 */
public class RegionManager
{
  String username;
  String password;
  String rmID;
  String rmName;
  String rmEmail;
  int conNum;
  int rmRrgID;
  String availableDay;

    public RegionManager(String username, String password, String rmID, String rmName, String rmEmail, int conNum, int rmRrgID, String availableDay)
    {
        this.username = username;
        this.password = password;
        this.rmID = rmID;
        this.rmName = rmName;
        this.rmEmail = rmEmail;
        this.conNum = conNum;
        this.rmRrgID = rmRrgID;
        this.availableDay = availableDay;
    }



    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRmID()
    {
        return rmID;
    }

    public String getRmName()
    {
        return rmName;
    }

    public String getRmEmail()
    {
        return rmEmail;
    }

    public int getConNum()
    {
        return conNum;
    }

    public int getRmRrgID()
    {
        return rmRrgID;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setRmID(String rmID)
    {
        this.rmID = rmID;
    }

    public void setRmName(String rmName)
    {
        this.rmName = rmName;
    }

    public void setRmEmail(String rmEmail)
    {
        this.rmEmail = rmEmail;
    }


    public void setConNum(int conNum)
    {
        this.conNum = conNum;
    }

    public void setRmRrgID(int rmRrgID)
    {
        this.rmRrgID = rmRrgID;
    }

    public String getAvailableDay()
    {
        return availableDay;
    }
  
  
}
