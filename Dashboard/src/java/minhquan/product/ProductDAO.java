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
import minhquan.ordersItem.OrderDetailDAO;
import minhquan.ordersItem.OrderDetailDTO;
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

    public ArrayList<ProductDTO> printProductList() throws ClassNotFoundException, SQLException {
        ArrayList<ProductDTO> productDashList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Product";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    float priceIn = rs.getFloat("priceIn");
                    String type = rs.getString("type");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String status = rs.getString("status");
                    String img = rs.getString("img");
                    String sku = rs.getString("sku");
                    int shopID = rs.getInt("shopID");
                    float priceOut = rs.getFloat("priceOut");
                    float pSale = rs.getFloat("pSale");
                    ProductDTO result = new 
        ProductDTO(productID, productName, priceIn, type, category, quantity, description, status, img, sku, shopID, priceOut, pSale);
                    productDashList.add(result);
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
        return productDashList;
    }

    public void searchProduct(int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductDTO result = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "SELECT * From Product WHERE productID like ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {

                    int productID = rs.getInt("productID");
                    String productName = rs.getString("productName");
                    float priceIn = rs.getFloat("priceIn");
                    String type = rs.getString("type");
                    String category = rs.getString("category");
                    int quantity = rs.getInt("quantity");
                    String description = rs.getString("description");
                    String status = rs.getString("status");
                    String img = rs.getString("img");
                    String sku = rs.getString("sku");
                    int shopID = rs.getInt("shopID");
                    float priceOut = rs.getFloat("priceOut");
                    float pSale = rs.getFloat("pSale");

                    result = new ProductDTO
        (productID, productName, priceIn, type, category, quantity, description, status, img, sku, shopID, priceOut, pSale);
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
     
        ProductDAO productDAO = new ProductDAO();
        List<ProductDTO> listProduct = productDAO.printProductList();
        OrderDetailDAO dao = new OrderDetailDAO();
        dao.getTop5Product();
        List<OrderDetailDTO> orderList = dao.getOrderItemList(); 
        productDAO.searchProduct(orderList.get(0).getProductID());
         List<ProductDTO> list = productDAO.getProductList();
         System.out.println(list);
    }
}
