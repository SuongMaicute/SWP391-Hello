/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.user;

import java.sql.Date;

/**
 *
 * @author Minh Quan
 */
public class UserDTO {

    private int accountID;
    private String username;
    private String email;
    private String password;
    private int role;
    private boolean isDeleted;
    private Date regisDate;
    private String avatar;

    public UserDTO() {
    }
     public UserDTO(String email, String password) {
      this.email = email;
      this.password = password;   
    }

    public UserDTO(int accountID, String username, String email, String password, int role, boolean isDeleted, Date regisDate, String avatar) {
        this.accountID = accountID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDeleted = isDeleted;
        this.regisDate = regisDate;
        this.avatar = avatar;
    }

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return the isDeleted
     */
    public boolean isIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the regisDate
     */
    public Date getRegisDate() {
        return regisDate;
    }

    /**
     * @param regisDate the regisDate to set
     */
    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

 

}
