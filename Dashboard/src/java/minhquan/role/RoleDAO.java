/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import minhquan.user.UserDAO;
import minhquan.user.UserDTO;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class RoleDAO {
    
    private ArrayList<RoleDTO> roles;

    /**
     * @return the roles
     */
    public ArrayList<RoleDTO> getRoles() {
        return roles;
    }
    public ArrayList<RoleDTO> getAllRoles(List<UserDTO> userList) throws ClassNotFoundException, SQLException{
         Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM ROLE WHERE role = ?";
                stm = con.prepareStatement(sql);
                for (UserDTO user : userList) {
                    stm.setInt(1, user.getRole());
                    rs = stm.executeQuery();
                
                while (rs.next()) {
                    int role = rs.getInt("role");
                    String roleName = rs.getString("roleName");
                    RoleDTO result = new RoleDTO(role, roleName);
                    if (this.roles == null) {
                        this.roles = new ArrayList<>();
                    }
                    this.roles.add(result);
                }
            }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return this.roles;        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        List<UserDTO> user = dao.getUserList();
        RoleDAO roleDAO = new RoleDAO();
        roleDAO.getAllRoles(user);
        List<RoleDTO> roles = roleDAO.getRoles();
        System.out.println(roles);
    }
}
