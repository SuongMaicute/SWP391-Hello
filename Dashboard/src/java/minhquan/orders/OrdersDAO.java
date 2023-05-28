/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import minhquan.ordersItem.OrderItemDAO;
import minhquan.ordersItem.OrderItemDTO;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class OrdersDAO {
    
    private List<OrdersDTO> ordersList;
    
    public List<OrdersDTO> getOrderList(){
        return ordersList;
    }
    
    public void getOrders() throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrdersDTO result = null;
        
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                con = DBHelper.makeConnection();
                if (con != null) {
                    String sql = "SELECT * FROM Orders";
                    stm = con.prepareStatement(sql);
                    rs = stm.executeQuery();
                    
                    while (rs.next()) {                        
                        int order_id = rs.getInt("order_id");
                        String email = rs.getString("email");
                        String order_date = rs.getString("order_date");
                        float total = rs.getFloat("total");
                        int order_status_id = rs.getInt("order_status_id");
                        
                        result = new OrdersDTO(order_id, email, order_date, total, order_status_id);
                        if (this.ordersList == null) {
                            ordersList = new ArrayList<>();
                        }
                        this.ordersList.add(result);
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
        
     
}
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OrdersDAO dao = new OrdersDAO();
        dao.getOrders();
        List<OrdersDTO> ordersDTOs = dao.getOrderList();
        System.out.println(ordersDTOs);
    }
}
