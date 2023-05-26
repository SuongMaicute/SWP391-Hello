/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author Admin
 */
public class UserDTO {
    private String accountID;
    private String email;
    private String username;
    private int role;
    private String password;
    private Boolean is_Delete;
    private Boolean customer;

    public UserDTO(String accountID, String email, String username, int role, String password, Boolean is_Delete, Boolean customer) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.role = role;
        this.password = password;
        this.is_Delete = is_Delete;
        this.customer = customer;
    }

    public UserDTO() {
    }

    public String getAccountID() {
        return accountID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public int getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIs_Delete(Boolean is_Delete) {
        this.is_Delete = is_Delete;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Boolean getIs_Delete() {
        return is_Delete;
    }

    public Boolean getCustomer() {
        return customer;
    }
    
    
    
}
