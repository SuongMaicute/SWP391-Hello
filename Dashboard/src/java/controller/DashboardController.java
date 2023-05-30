/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import minhquan.orders.OrdersDAO;
import minhquan.orders.Order;
import minhquan.ordersItem.OrderDetailDAO;
import minhquan.ordersItem.OrderDetailDTO;
import minhquan.product.ProductDAO;
import minhquan.product.ProductDTO;
import minhquan.user.UserDAO;
import minhquan.user.UserDTO;

/**
 *
 * @author Minh Quan
 */
public class DashboardController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "dashboard.jsp";
        try {
            String button = request.getParameter("txtAction");

//            get Session
            HttpSession session = request.getSession();
            UserDTO currentUser = null;
            if (session != null) {
                currentUser = (UserDTO) session.getAttribute("USER");

//                get the number of User
                UserDAO userDAO = new UserDAO();
                ArrayList<UserDTO> userList = userDAO.getUserList();
                int numberOfUser = userList.size();
//                get the number of Orders
                OrdersDAO ordersDAO = new OrdersDAO();
                ordersDAO.getOrders();
                List<Order> orderList = ordersDAO.getOrderList();
                int numberOfOrders = orderList.size();
//              get the number of income
                OrderDetailDAO orderItemDAO = new OrderDetailDAO();
                float numberOfIncome = orderItemDAO.getIncome();
                int data[] = {numberOfUser, numberOfOrders};
//                Get the data for chart
                orderItemDAO.getTop5Product();
                List<OrderDetailDTO> list = orderItemDAO.getOrderItemList();
                int sku_num1 = list.get(0).getProductID();
                int sku_num2 = list.get(1).getProductID();
                int sku_num3 = list.get(2).getProductID();
                int sku_num4 = list.get(3).getProductID();
                int sku_num5 = list.get(4).getProductID();

                ProductDAO productDAO = new ProductDAO();
                productDAO.searchProduct(sku_num5);
                productDAO.searchProduct(sku_num1);
                productDAO.searchProduct(sku_num2);
                productDAO.searchProduct(sku_num4);
                productDAO.searchProduct(sku_num3);
                List<ProductDTO> listProduct = productDAO.getProductList();
                
                request.setAttribute("TOPQUANTITY", list);
                request.setAttribute("TOPPRODUCT", listProduct);
                request.setAttribute("DATA", data);
                request.setAttribute("INCOME", numberOfIncome);
                System.out.println(listProduct);
            }

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
