<%-- 
    Document   : getBalance
    Created on : Sep 3, 2015, 4:15:23 PM
    Author     : megha_000
--%>


<%@page import="model.User.Account"%>
<%@page import="model.Financial.Money"%>
<%@page import="service.MoneyService.MoneyManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyBuy Balance</title>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> 
    </head>
    <body>
    <%@include file="/Header.jsp" %>
    <CENTER>
        <TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=70%>
            <TR>
                <TD><CENTER><B>
                    <FONT SIZE=+2>User</FONT>
                </B></CENTER></TD>
            <TD><CENTER><B>
                    <FONT SIZE=+2>Balance </FONT>
                </B></CENTER></TD>
            </TR>
            <TR>
                <TD>&nbsp;<FONT SIZE=+1>                    
                    ${myUser.getName()}
                    </FONT></TD>
                <TD>&nbsp;<FONT SIZE=+1>
                    <% 
                        Account myUser = (Account) session.getAttribute("myUser");
                        Money myMoney = MoneyManager.getMoneyofUser(myUser.getAccount_id());
                        if(myMoney==null)
                        out.println(" 0 Rs ");
                        else
                        out.println(myMoney.getBalance());    
                        %>
                    
                    
                    </FONT></TD>
            </TR>   
        </TABLE >
    </center>
    
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
