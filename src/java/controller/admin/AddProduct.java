/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.User.Account;
import model.Store.Item;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB 
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100)
public class AddProduct extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        Account myUser = null;
        if (session != null) {
            myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {
                
                String error = "Please login add an Item!!";
                request.setAttribute("message", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
            else
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
        Item myProduct = new Item();
        myProduct.setProductName(request.getParameter("itemname"));
        myProduct.setProductDetails(request.getParameter("itemdetails"));
        myProduct.setProductQuantity(Integer.parseInt(request.getParameter("itemquantity")));
        myProduct.setPrice(Double.parseDouble(request.getParameter("itemprice")));
        myProduct.setSellerID(myUser.getAccount_id());
        InputStream inputStream = null;
        Part filePart = request.getPart("itempic");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            byte[] targetArray = new byte[inputStream.available()];
            inputStream.read(targetArray);
            myProduct.setProductImage(targetArray);

        }
        //File file = new File(request.getPart("itempic"));
        //Part filePart = request.getPart("itempic"); 
        //byte[] bFile = new byte[(int) file.length()];
        //FileInputStream fileInputStream = new FileInputStream(file);     
        ProductManager.addProduct(myProduct);

        String message = "Item  added  Succesfully !! ";
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp").forward(request, response);

        
        
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
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {
                
                String error = "Please login add an Item!!";
                request.setAttribute("message", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
            else
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
