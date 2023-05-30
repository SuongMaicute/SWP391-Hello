/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.CustomerDAO;
import Login.UserDAO;
import Login.UserDTO;
import Login.UserGoogleDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateProfile", urlPatterns = {"/UpdateProfile"})
public class UpdateProfile extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            UserDTO userDTO = (UserDTO) session.getAttribute("USERDTOBYUSERNAME");
            UserGoogleDto ggDTO = (UserGoogleDto) session.getAttribute("GOOGLE_ACC");
            String gmail_default = null;
            
            if (ggDTO != null) {
                gmail_default = ggDTO.getEmail();
            }

            if (userDTO != null) {
                gmail_default = userDTO.getEmail();
            }

            String button = request.getParameter("Change");
            System.out.println("we in Update profile Servlet" + button);
            UserDAO userDAO = new UserDAO();
            CustomerDAO cusDAO = new CustomerDAO();
            
            int accountID = userDAO.GetIDByEmail(gmail_default);
            
            switch(button){
                case "Update your name":{
                    String name= request.getParameter("Name");
                    userDAO.Update(gmail_default, name, "username");
                    System.out.println(button); break;
                    
                }
                case "Change your Gmail":{
                    System.out.println(button);
                    String gmail= request.getParameter("Gmail");
                    userDAO.Update(gmail_default, gmail, "email");
                    break;
                    
                }
                case "Change your Phone Number":{
                    String phone= request.getParameter("PhoneNumber");
                    cusDAO.UpdatePhoneNumber(accountID, phone);
                    break;
                }
            }
            
           session.setAttribute("USERDTOBYUSERNAME", userDTO);
           session.setAttribute("GOOGLE_ACC", ggDTO);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect("getDataforUserProfileController");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
