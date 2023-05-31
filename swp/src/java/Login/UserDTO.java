/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entity.RoleDTO;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class UserDTO {
    private int accountID;
    private String username;
    private String email;
    private String password;
    private int role ;
    private Boolean isDeleted;
    private Date regisDate;
    private String avatar;

    public UserDTO(int accountID, String username, String email, String password, int role, Boolean isDeleted, Date regisDate, String avatar) {
        this.accountID = accountID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDeleted = isDeleted;
        this.regisDate = regisDate;
        this.avatar = avatar;
    }

    public UserDTO() {
    }

    public int getAccountID() {
        return accountID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
        
    
}
