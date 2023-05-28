/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package nhilty.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhilty.dao.ProductDAO;
import nhilty.model.Product;

/**
 *
 * @author leyen
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        
        if ("detail".equals(action)) {
            String productID = request.getParameter("pid");

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(productID);

           
            if (product != null) {
                request.setAttribute("productdetail", product);
                request.setAttribute("action", "suggestedproduct");
                request.getRequestDispatcher("productdetail.jsp").forward(request, response);
            }
        }else if("suggestedproduct".equals(action)){
            
            String category = request.getParameter("category");
            ProductDAO dao = new ProductDAO();
            int suggestionProduct = 15;
            int productPerPage = 3;
            int numPage = 5;
            int curPage;
            try {
                curPage = Integer.parseInt(request.getParameter("curPage"));
            } catch (Exception e) {
                curPage = 1;
            }
            List<Product> suggestedProductList = dao.getSuggestion(category, 
                    productPerPage, curPage);
            //List of suggested product
            request.setAttribute("suggestedlist", suggestedProductList);
            //total page
            request.setAttribute("totalpage", numPage);
            //current page
            request.setAttribute("currentpage", curPage);
            request.getRequestDispatcher("productdetail.jsp")
                    .forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
