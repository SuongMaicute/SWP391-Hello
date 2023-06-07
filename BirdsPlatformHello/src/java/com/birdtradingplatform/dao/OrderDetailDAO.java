/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.birdtradingplatform.dao;

import com.birdtradingplatform.model.Order;
import com.birdtradingplatform.model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.birdtradingplatform.utils.DBHelper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Minh Quan
 */
public class OrderDetailDAO {

   public List<OrderDetail> orderItemList;
    public Map<Integer, String> mapImg;

    public List<OrderDetail> getOrderItemList() {
        return orderItemList;
    }

    public Map<Integer, String> getMapImg() {
        return mapImg;
    }


    public float getIncome() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrderDetail result = null;
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

    public void getTop5Product() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        OrderDetail result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT TOP (5) [orderDetailID],[quantity],[price],[productID],[orderID] FROM [BirdPlatform].[dbo].[OrderDetail] ORDER BY quantity DESC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderDetailID = rs.getInt("orderDetailID");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    int productID = rs.getInt("productID");
                    float orderID = rs.getInt("orderID");
                    result = new OrderDetail(orderDetailID, quantity, price, productID, orderID);
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
  public List<OrderDetail> getImgByOrderID(List<Order> orders) throws ClassNotFoundException, SQLException {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        OrderDetail result = null;
        if (this.mapImg == null) {
            mapImg = new HashMap<>();
        }
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT TOP (1000) [orderDetailID] "
                        + "      ,[OrderDetail].[quantity] "
                        + "      ,[OrderDetail].[price] "
                        + "      ,[OrderDetail].[productID] "
                        + "      ,[orderID], "
                        + "	  img "
                        + "  FROM [BirdPlatform].[dbo].[OrderDetail], Product  "
                        + "  where [OrderDetail].productID = Product.productID";
                // for (Order order : orders) {
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderDetailID = rs.getInt("orderDetailID");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");
                    int productID = rs.getInt("productID");
                    int orderID = rs.getInt("orderID");
                    String img = rs.getString("img");

                    result = new OrderDetail(orderDetailID, quantity, price, productID, orderID);
                    orderDetails.add(result);

                    mapImg.put(orderID, img);
                }
            }
            //}
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
        return orderDetails;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        OrderDetailDAO dao = new OrderDetailDAO();
        dao.getTop5Product();
        List<OrderDetail> list = dao.getOrderItemList(); 
        System.out.println(list);
    }
}
