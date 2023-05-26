/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try{
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con!= null){
            String sql = "select accountID,email,username,role,password,is_Delete,customer "
                    + "from Account where email=?";
            //3. create stm
            stm = con.prepareStatement(sql);
            stm.setString(1, gmail);
            //4.excute stm
            rs=stm.executeQuery();
            //5.process result 
            if(rs.next()){
                String  accountID = rs.getString("accountID");
                String  email = rs.getString("email");
                String  username = rs.getString("username");                
                Integer role = rs.getInt("role");
                String password = rs.getString("password");                 
                boolean is_Delete = rs.getBoolean("is_Delete");
                boolean customer = rs.getBoolean("customer");             
                dto = new UserDTO(accountID, email, username, 0, password, is_Delete, customer);
            }
            }else{
                
            }
            
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
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
        try{
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con!= null){
            String sql = "select accountID,email,username,role,password,is_Delete,customer "
                    + "from Account where username=? and password=?";
            //3. create stm
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            //4.excute stm
            rs=stm.executeQuery();
            //5.process result 
            if(rs.next()){
                String  accountID = rs.getString("accountID");
                String  email = rs.getString("email");               
                Integer role = rs.getInt("role");                
                boolean is_Delete = rs.getBoolean("is_Delete");
                boolean customer = rs.getBoolean("customer");             
                dto = new UserDTO(accountID, email, username, 0, password, is_Delete, customer);
            }
            }else{
                
            }
            
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
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
        try{
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con!= null){
            String sql = "insert into Account "
                    + "values (?,?,?,?,?,?,?);";
            //3. create stm
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getAccountID());
            stm.setString(2, dto.getEmail());
            stm.setString(3, dto.getUsername());
            stm.setInt(4, dto.getRole());
            stm.setBoolean(5, dto.getIs_Delete());
            stm.setBoolean(6, dto.getCustomer());
            
            //4.excute stm
            int row =stm.executeUpdate();
            //5.process result 
            if(row != 0){
                result= true;
            }
            }else{
                
            }
            
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
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
        try{
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con!= null){
            String sql = "delete from Account where email = ?";
            //3. create stm
            stm = con.prepareStatement(sql);
            stm.setString(1,gmail);
            
            //4.excute stm
            int row =stm.executeUpdate();
            //5.process result 
            if(row != 0){
                result= true;
            }
            }else{
                
            }
            
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
            
        }
        return result;
    }
    
    
    public Boolean UpdatePass(String gmail, String newPass) 
            throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        Boolean result = false;
        try{
            //1. connect BD
            con = DBHelper.makeConnection();
            //2. write sql 
            if (con!= null){
            String sql = "update Account set password = ?"
                    + " where email = ?";
            //3. create stm
            stm = con.prepareStatement(sql);
            stm.setString(1,newPass);
            stm.setString(2,gmail);
            
            //4.excute stm
            int row =stm.executeUpdate();
            //5.process result 
            if(row != 0){
                result= true;
            }
            }else{
                
            }
            
        }finally{
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
            
        }
        return result;
    }
    
    
}
