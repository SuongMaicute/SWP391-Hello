/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.user;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import minhquan.product.ProductDTO;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class UserDAO {
       private List<UserDTO> accountList;

        public List<UserDTO> getAccountList() {
        return accountList;
    }
    public ArrayList<UserDTO> getUserList() throws ClassNotFoundException, SQLException{
        ArrayList<UserDTO> userList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Account";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while (rs.next()) {    
                    int accountID = rs.getInt("accountID");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int role = rs.getInt("role");
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    Date regisDate = rs.getDate("regisDate");
                    String avatar = rs.getString("avatar");
                    
                  UserDTO result = new UserDTO(accountID, username, email, password, role, isDeleted, regisDate, avatar);
                    userList.add(result);
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
           return userList;
    }
    public boolean deleteUser(UserDTO user) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        int row = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "UPDATE Account "
                        + "SET isDeleted = 1"
                        + "WHERE email = ?;";
                stm = con.prepareStatement(sql);
                stm.setString(1, user.getEmail());
               row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
           return false;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        UserDTO user = new UserDTO("kitsvshack321@gmail.com", null);
        dao.deleteUser(user);
        
    }
}
