/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.user;

/**
 *
 * @author Minh Quan
 */
public class UserDTO {
    private String email;
    private String password;
    private String image;
    private String fullname;
    private String address;
    private String phone_number;
    private boolean is_deleted;
    private int role_id;
    
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public UserDTO() {
    }

    public UserDTO(String email, String password, String image, String fullname, String address, String phone_number, boolean is_deleted, int role_id) {
        this.email = email;
        this.password = password;
        this.image = image;
        this.fullname = fullname;
        this.address = address;
        this.phone_number = phone_number;
        this.is_deleted = is_deleted;
        this.role_id = role_id;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the is_deleted
     */
    public boolean isIs_deleted() {
        return is_deleted;
    }

    /**
     * @param is_deleted the is_deleted to set
     */
    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    /**
     * @return the role_id
     */
    public int getRole_id() {
        return role_id;
    }

    /**
     * @param role_id the role_id to set
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    /**
     * @return the phone_number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    
}
