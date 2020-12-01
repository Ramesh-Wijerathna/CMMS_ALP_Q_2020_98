/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMMS.Models;

/**
 *
 * @author kavin
 */
public class UserLogin {
    private String userName;
    private String password;
    private Boolean loginStatus;

    public UserLogin(String userName, String password, Boolean loginStatus) {
        this.userName = userName;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }
    
    
}
