/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhilty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nhilty.model.Order;
import nhilty.model.OrderHistory;
import nhilty.utils.DBUtils;

/**
 *
 * @author leyen
 */
public class OrderDAO {

    public List<OrderHistory> getOrderHistory(int accountID, String status) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<OrderHistory> list = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            if(con!=null){
//                String sql = "select * from [Order] where "
//                        + "customerID = (select customerID "
//                        + "from [customer] left join [account] "
//                        + "on [customer].accountID=?)";
                  String sql = "select * from "
                          + "orderHistory(?) as oHis "
                          + "left join orderHistoryQuantity() as oQuan "
                          + "on oHis.orderID=oQuan.orderID "
                          + "left join orderHistoryFirstProduct() as stProNa "
                          + "on oHis.orderID=stProNa.orderID";
                  if(status!=null&&!status.isBlank()){
                      sql += "where status = '" + status +"'";
                  }
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, accountID);
                rs = pstm.executeQuery();
                while(rs.next()){
                    list.add(new OrderHistory( rs.getInt("totalQuantity"), 
                            rs.getString("firstProductName"), 
                            rs.getInt("orderID"),
                            rs.getString("orderDate"), 
                            rs.getDouble("total"),
                            rs.getInt("addressShipID"),
                            rs.getString("shipDate"),
                            rs.getString("status")));
                            
                            
                         
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

}
