/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.CreditCardValidator;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "ValidateCard", urlPatterns = {"/ValidateCard"})
public class ValidateCard extends HttpServlet {

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
        String ccNumber = request.getParameter("cardNum");
        String expiryDate = request.getParameter("expiry");
        String type = request.getParameter("cardType");
        String cvv = request.getParameter("cvv");
         CreditCardValidator v = new CreditCardValidator();
        boolean valid =v.isValid(ccNumber);
        boolean expired=true;
        boolean isCVVValid=false;
        Date date = null;
        Date now  = new Date();
        try {
             date = new SimpleDateFormat("MM/yyyy").parse(expiryDate);             
             
        } catch (ParseException ex) {
            Logger.getLogger(ValidateCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if( date.getYear() == now.getYear() && date.getMonth() > now.getMonth())
        {
            expired=false;
        }
        else if(date.getYear() > now.getYear())
        {
            expired=false;
        }
        if(cvv.length() == 3 || cvv.length() == 4)
        {
            try{
            Integer.parseInt(cvv);
            isCVVValid= true;
            }
            catch(NumberFormatException e)
            {
                //ignore isCVVValid is false
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateCard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>is valid " + valid  + "</h1>");
            out.println("<h1>ex date  " + expiryDate  + "</h1>");
            out.println("<h1>ex date  " + date  + "</h1>");
            out.println("<h1>current date  " + now  + "</h1>");
            out.println("<h1> is expired  " + expired  + "</h1>");
            
            out.println("<h1>is CVV Valid  " + isCVVValid  + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
