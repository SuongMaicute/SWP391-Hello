/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class RoleDTO {
    private int role;
    private String roleName;

    public RoleDTO(int role, String roleName) {
        this.role = role;
        this.roleName = roleName;
    }

    public RoleDTO() {
    }

    public int getRole() {
        return role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
}
