/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.birdtradingplatform.dao;

import com.birdtradingplatform.model.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class AccountDAO {
       private List<Account> accountList;

        public List<Account> getAccountList() {
        return accountList;
    }
    public ArrayList<Account> getUserList() throws ClassNotFoundException, SQLException{
        ArrayList<Account> userList = new ArrayList<>();
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
                    
                  Account result = new Account(accountID, username, email, password, role, isDeleted, username);
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
    public boolean deleteUser(Account user) throws ClassNotFoundException, SQLException{
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
        AccountDAO dao = new AccountDAO();
        Account user = new Account("kitsvshack321@gmail.com", null);
        dao.deleteUser(user);
        
    }
}
