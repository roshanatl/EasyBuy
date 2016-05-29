<% String message = (String)request.getAttribute("message");
   String error = (String)request.getAttribute("error");
   String paymentError = (String)request.getAttribute("paymenterror");
   if(message != null)
       out.println("<table style=\"background-color:#FF8C00;\">\n" +
                     "<tr>\n" +
                        "<td>"+message+"</td>\n" +
                     "</tr>\n" +
                   "</table>");        
   if(error  != null)        
        out.println("<table style=\"background-color:Red;\">\n" +
                     "<tr>\n" +
                        "<td>"+error+"</td>\n" +
                     "</tr>\n" +
                   "</table>");  
   if(paymentError  != null)        
        out.println("<table style=\"background-color:Red;\">\n" +
                     "<tr>\n" +
                        "<td>"+paymentError+"</td>\n" +
                     "</tr>\n" +
                   "</table>");     
   %>
   


