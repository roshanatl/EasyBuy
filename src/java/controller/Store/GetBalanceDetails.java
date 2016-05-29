/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Store;

import controller.admin.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User.Account;
import model.User.Address;
import model.Financial.Money;
import model.Store.Orders;
import model.Store.Item;
import service.AddressService.AddressServiceJPA;
import service.MoneyService.MoneyManager;
import service.OrderService.OrderManager;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "GetBalanceDetails", urlPatterns = {"/GetBalanceDetails"})
public class GetBalanceDetails extends HttpServlet {

    
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {
                
                String error = "Please login to get order details!!";
                request.setAttribute("message", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
            else
            request.getRequestDispatcher("getBalance.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("login.html").forward(request, response);
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
        // processRequest(request, response);

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
