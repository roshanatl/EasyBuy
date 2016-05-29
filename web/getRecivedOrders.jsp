<%-- 
    Document   : getBalance
    Created on : Sep 3, 2015, 4:15:23 PM
    Author     : megha_000
--%>


<%@page import="model.User.Address"%>
<%@page import="service.AddressService.AddressServiceFactory"%>
<%@page import="model.Store.Item"%>
<%@page import="model.Store.Orders"%>
<%@page import="model.User.Account"%>
<%@page import="service.ProductAdminService.ProductManager"%>
<%@page import="service.OrderService.OrderManager"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyBuy Orders</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
    <%@include file="/Header.jsp" %>
     <%@include file="/Message.jsp" %>
    <CENTER>
        <TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=70%>
            <TR>
                <TD><CENTER><B>
                    <FONT SIZE=+2>Item Name </FONT>
                </B></CENTER></TD>
            <TD><CENTER><B>
                    <FONT SIZE=+2>Delivery Address  </FONT>
                </B></CENTER></TD>
            <TD><CENTER><B>
                    <FONT SIZE=+2>Order Status </FONT>
                </B></CENTER></TD>
            </TR>
            <% 
                Account myUser = (Account) session.getAttribute("myUser");
                List<Orders> myOrders = OrderManager.getAllMyRecivedOrders(myUser.getAccount_id());
                if(myOrders.isEmpty())
                {
                    out.println("<TR>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    out.println("No Orders for you");                   
                    out.println("</FONT></TD>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    out.println("</FONT></TD>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    out.println("</FONT></TD>");
                    out.println("</TR>");
                }
                for (Orders each : myOrders) {
                    Item eachProduct = ProductManager.getProductByID(each.getItemID());
                    int orderState=each.getOrderState();
                    out.println("<TR>");
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    out.println(eachProduct.getProductName());
                    out.println("</FONT></TD>");
                    
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    Address myAddress = AddressServiceFactory.getAddressService(true).getAddressByID(each.getDeliveryAddressID());
                    out.println(myAddress.getAddressLine1());
                    out.println(myAddress.getAddressLine2());
                    out.println(myAddress.getCity());
                    out.println(myAddress.getState());
                    out.println(myAddress.getZip());
                    out.println("</FONT></TD>");  
                    
                    out.println("<TD>&nbsp;<FONT SIZE=+1>");
                    if(orderState == 0)
                    {
                        out.println("Open");
                        
                        out.println("<a href=\"MakeDeliver?itemid=" + each.getOrderID()+
                                    "\" class=\"btn btn-primary btn-primary\">Deliver IT</a>");
                    }   
                    else
                        out.println("Closed");
                    out.println("</FONT></TD>");
                    out.println("</TR>");
                } %>
        </TABLE >
    </center>
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
