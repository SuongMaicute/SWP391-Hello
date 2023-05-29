/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhilty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nhilty.model.Product;
import nhilty.model.Shop;
import nhilty.utils.DBUtils;

/**
 *
 * @author leyen
 */
public class ProductDAO {

    public Product getProduct(String id) throws SQLException {
        Product product = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select *"
                        + " from [Product] left join [Shop] on "
                        + "product.shopID = shop.shopID where productID = ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, id);

                rs = pstm.executeQuery();
                if (rs.next()) {
                   
                    product = new Product(rs.getInt("productID"),
                            rs.getString("productName"),
                            rs.getDouble("priceIn"),
                            rs.getString("type"),
                            rs.getString("category"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("status"),
                            rs.getString("img"),
                            rs.getString("sku"),
                            new Shop(rs.getInt("shopID"),
                                    rs.getString("shopName"),
                                    rs.getString("avatar"),
                                    rs.getDouble("rate"),
                                    rs.getString("contact"),
                                    rs.getInt("accountID"),
                                    rs.getInt("addressID")),
                            rs.getDouble("priceOut"),
                            rs.getDouble("pSale"));
                }
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return product;
    }

    public List<Product> getSuggestion(String relation, int limit, int page) throws SQLException {
        List<Product> suggestedList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select *"
                        + " from [Product] left join [Shop] on "
                        + " product.shopID = shop.shopID where category = ?"
                        + " order by rate " + " offset " + (page - 1) * limit + " rows "
                        + " fetch next ? rows only";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, relation);
                pstm.setInt(2, limit);

                rs = pstm.executeQuery();
                while (rs.next()) {
                    suggestedList.add(new Product(rs.getInt("productID"),
                            rs.getString("productName"),
                            rs.getDouble("priceIn"),
                            rs.getString("type"),
                            rs.getString("category"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("status"),
                            rs.getString("img"),
                            rs.getString("sku"),
                            new Shop(rs.getInt("shopID"),
                                    rs.getString("shopName"),
                                    rs.getString("avatar"),
                                    rs.getDouble("rate"),
                                    rs.getString("contact"),
                                    rs.getInt("accountID"),
                                    rs.getInt("addressID")),
                            rs.getDouble("priceOut"),
                            rs.getDouble("pSale")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return suggestedList;
    }

}
