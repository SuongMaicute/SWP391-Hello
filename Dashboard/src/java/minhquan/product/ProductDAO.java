/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minhquan.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import minhquan.orders.OrdersDAO;
import minhquan.ordersItem.OrderItemDAO;
import minhquan.ordersItem.OrderItemDTO;
import minhquan.user.UserDTO;
import minhquan.util.DBHelper;

/**
 *
 * @author Minh Quan
 */
public class ProductDAO {

    private List<ProductDTO> productList;

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void searchProduct(String productSku) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO result = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * From Products WHERE sku like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,"%" + productSku + "%");
                rs = stm.executeQuery();
                while (rs.next()) {

                    String sku = rs.getString("sku");
                    String product_name = rs.getString("product_name");
                    String image = rs.getString("image");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    int category_id = rs.getInt("category_id");
                    int product_status_id = rs.getInt("product_status_id");
                    boolean is_deleted = rs.getBoolean("is_deleted");

                    
                    result = new ProductDTO(sku, product_name, image, price, quantity, description, category_id, product_status_id, is_deleted);                 
                    if (this.productList == null) {
                        productList = new ArrayList<>();
                    }
                    this.productList.add(result);
                }
            }
        } catch (Exception e) {
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
                String sku_num1 = list.get(0).getSku();
                String sku_num2 = list.get(1).getSku();
                String sku_num3 = list.get(2).getSku();
                String sku_num4 = list.get(3).getSku();
                String sku_num5 = list.get(4).getSku();
        ProductDAO productDAO = new ProductDAO();
        productDAO.searchProduct(sku_num5);
        productDAO.searchProduct(sku_num1);
        productDAO.searchProduct(sku_num2);
        productDAO.searchProduct(sku_num4);
        productDAO.searchProduct(sku_num3);
        List<ProductDTO> listProduct = productDAO.getProductList();
        System.out.println("Product :" + listProduct.size());
    }
}
