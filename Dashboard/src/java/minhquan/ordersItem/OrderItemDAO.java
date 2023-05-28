/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.ordersItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import minhquan.orders.OrdersDTO;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class OrderItemDAO {
    
    public List<OrderItemDTO> orderItemList;
    
    public List<OrderItemDTO> getOrderItemList(){
        return orderItemList;
    }
    
    public float getIncome() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrderItemDTO result = null;
        try {
            con = DBHelper.makeConnection();
              if (con != null) {
            String sql = "SELECT SUM(subtotal) AS Income FROM [MonShop].[dbo].[OrderItem]";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            if (rs.next()) {
                float subtotal = rs.getFloat("Income");
                return subtotal;
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
        return 0;
    }
    public void getTop5Product() throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrderItemDTO result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
               String sql = "SELECT top 5 [order_item_id],[order_id],[sku],[quantity],[price],[subtotal] FROM [MonShop].[dbo].[OrderItem] ORDER BY quantity DESC;";
               stm = con.prepareStatement(sql);
               rs = stm.executeQuery();
               
                while (rs.next()) {                    
                    int order_item_id = rs.getInt("order_item_id");
                    int order_id = rs.getInt("order_item_id");
                    String sku = rs.getString("sku");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    float subtotal = rs.getFloat("subtotal");
                    result = new OrderItemDTO(order_item_id, order_id, sku, quantity, price, subtotal);
                    if (this.orderItemList == null) {
                        orderItemList = new ArrayList<>();
                    }
                    orderItemList.add(result);
                    
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
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        OrderItemDAO dao = new OrderItemDAO();
        dao.getTop5Product();
        List<OrderItemDTO> list = dao.getOrderItemList();
        System.out.println(list.size());
    }
}
