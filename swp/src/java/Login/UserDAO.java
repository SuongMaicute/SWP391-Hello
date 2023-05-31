/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Entity.RoleDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDTO CheckLoginbyGmail(String gmail)
            throws ClassNotFoundException, SQLException, NamingException {
        UserDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "select accountID, username, email, password,Role.role,roleName,isDeleted,regisDate,avatar "
                        + "from Account,Role "
                        + "where email = ? and Account.role = Role.role";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, gmail);
                //4.excute stm
                rs = stm.executeQuery();
                //5.process result 
                if (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int role = rs.getInt("role");
                    
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    Date regisDate = rs.getDate("regisDate");
                    String avatar = rs.getString("avatar");
                    
                   dto = new UserDTO(accountID, username, email, password, role, isDeleted, regisDate, avatar);
                    System.out.print(dto.getEmail());
                }
            } else {

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
        return dto;
    }

    public UserDTO CheckLoginbyUserName(String username, String password)
            throws ClassNotFoundException, SQLException, NamingException {
        UserDTO dto = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "select accountID, username, email, password,Role.role,roleName,isDeleted,regisDate,avatar "
                        + "from Account,Role "
                        + "where username=? and password=? and Role.role = Account.role";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.excute stm
                rs = stm.executeQuery();
                //5.process result 
                if (rs.next()) {
                    int accountID = rs.getInt("accountID");
                    String email = rs.getString("email");
                    int role = rs.getInt("role");
                    
                    boolean isDeleted = rs.getBoolean("isDeleted");
                    Date regisDate = rs.getDate("regisDate");
                    String avatar = rs.getString("avatar");
                    
                   dto = new UserDTO(accountID, username, email, password, role, isDeleted, regisDate, avatar);
                    System.out.print(dto.getEmail());
                }
            } else {

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
        return dto;
    }

    public Boolean SaveUser(UserDTO dto)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        Boolean result = false;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "insert into Account values(?,?,?, ?,?,?,?)";
                //3. create stm
                stm = con.prepareStatement(sql);
                // stm.setInt(1,1);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getEmail());
                stm.setString(3, dto.getPassword());
                stm.setInt(4,dto.getRole());
                stm.setBoolean(5, dto.getIsDeleted());
                stm.setDate(6, dto.getRegisDate());
                stm.setString(7, dto.getAvatar());

                //4.excute stm
                int row = stm.executeUpdate();
                //5.process result 
                if (row != 0) {
                    result = true;
                }
            } else {

            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return result;
    }

    public Boolean DeleteUser(String gmail)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        Boolean result = false;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "delete from Account where email = ?";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, gmail);

                //4.excute stm
                int row = stm.executeUpdate();
                //5.process result 
                if (row != 0) {
                    result = true;
                }
            } else {

            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return result;
    }

    public Boolean Update(String gmail, String newValue, String Column)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        Boolean result = false;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "update Account set " + Column + " = ?"
                        + " where email = ?";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, newValue);
                stm.setString(2, gmail);

                //4.excute stm
                int row = stm.executeUpdate();
                //5.process result 
                if (row != 0) {
                    result = true;
                }
            } else {

            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return result;
    }

    public int GetIDByEmail(String gmail)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "select accountID  from Account where email = ?";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, gmail);

                //4.excute stm
                rs = stm.executeQuery();
                //5.process result 
                if (rs.next()) {
                    result = rs.getInt("accountID");
                }
            } else {

            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return result;
    }

    public ArrayList GetPoint_PhoneNum(String gmail)
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        Boolean result = false;
        ResultSet rs = null;
        ArrayList returnValue = new ArrayList<>();

        try {
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con != null) {
                String sql = "select phoneNumber,point " +
                    "from Account, Customer " +
                    "where Account.accountID = Customer.accountID "
                    + "and email = ?";
                //3. create stm
                stm = con.prepareStatement(sql);
                stm.setString(1, gmail);

                //4.excute stm
                rs = stm.executeQuery();
                //5.process result 
                if (rs.next()) {
                    returnValue.add(rs.getString("PhoneNumber"));
                    returnValue.add(rs.getInt("Point"));

                    System.out.println("laj nha dang owr DAO ");
                    System.out.println(returnValue);
                } else {
                    System.out.println("null rS");
                }
            } else {

            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return returnValue;
    }
    /*
    
     */

}
