/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Store;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User.Account;
import model.User.Address;
import model.Financial.CreditCard;
import model.Store.Orders;
import model.Store.Item;
import service.AddressService.AddressServiceFactory;
import service.MoneyService.MoneyManager;
import service.OrderService.OrderManager;
import service.Payment.PaymentService;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "ConfirmPurchase", urlPatterns = {"/ConfirmPurchase"})
public class ConfirmPurchase extends HttpServlet {

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
        Address myAddress = new Address();
        myAddress.setAddressLine1(request.getParameter("InputAddress1"));
        myAddress.setAddressLine2(request.getParameter("InputAddress2"));
        myAddress.setCity(request.getParameter("city"));
        myAddress.setState(request.getParameter("state"));
        myAddress.setZip(Long.parseLong(request.getParameter("zip")));

        //int itemID=(Integer)request.getAttribute("itemid"); 
        HttpSession session = request.getSession(false);
        if (session != null) {
            Account myUser = (Account) session.getAttribute("myUser");
            if (myUser == null) {
                PrintWriter out = response.getWriter();
                out.println("Please login to make a purchase!!");
                request.getRequestDispatcher("login.html").forward(request, response);

            }
            int itemID = Integer.parseInt(request.getParameter("itemid"));
            Item myItem=ProductManager.getProductByID(itemID);
            
            int addreesID = AddressServiceFactory.getAddressService(true).AddAddress(myAddress);
            Orders myOder = new Orders();
            myOder.setDeliveryAddressID(addreesID);
            myOder.setItemID(itemID);
            myOder.setOrderState(0);
            myOder.setQuantity(1);
            myOder.setUserID(myUser.getAccount_id());
            myOder.setSellerID(myItem.getSellerID()); 
            
            CreditCard myCreditCard= new CreditCard();
            myCreditCard.setCardNum(request.getParameter("cardNum"));
            myCreditCard.setCardExpiry(request.getParameter("expiry"));
            myCreditCard.setCardType(request.getParameter("cardType"));
            myCreditCard.setCardCVV(request.getParameter("cvv"));
            String paymentErrorMessage=null;
            paymentErrorMessage = PaymentService.validateCard(myCreditCard);
            if(paymentErrorMessage != null  )
            {
                request.setAttribute("paymenterror", paymentErrorMessage);
                String nextPage="/BuyProduct?itemid"+itemID;
                request.getRequestDispatcher(nextPage).forward(request, response);
            }           
            OrderManager.createOrder(myOder);
            //Update balance of Seller
            MoneyManager.updateMoneyAmount(myItem.getSellerID(), myItem.getPrice());
            request.getRequestDispatcher("OrderSuccess.jsp").include(request, response);
        }
        else {            
            request.getRequestDispatcher("login.html").include(request, response);
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
