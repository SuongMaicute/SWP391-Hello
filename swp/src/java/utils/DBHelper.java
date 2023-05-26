/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class DBHelper implements Serializable {
    public static Connection makeConnection() 
            throws /*ClassNotFoundException,*/ SQLException,NamingException{
       /* //1. Load driver // dùng cách này 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // 2. create connection String
        String url ="jdbc:sqlserver://localhost:1433;databaseName=SuongMai_DBI2";
        // có instance thì thêm vào
        
        //3. open connection
        
        Connection con = DriverManager.getConnection(url, "sa", "sa");
        return con;*/
       
       
       // sd data source 
       
       
       
       //1.Contetx cua he dieu hanh 
       Context context = new InitialContext();
       
       //2. find tomcat context 
       Context tomcatContext = (Context)context.lookup("java:comp/env");
       
       //3.Find data source  -- cai sql 
     
        javax.sql.DataSource ds = (javax.sql.DataSource)tomcatContext.lookup("suongmaiDS");
        
       //4. open connection
            Connection con = ds.getConnection();
       return con ; 
       
       
    }
}
