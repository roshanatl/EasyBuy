<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="model.admin.Item"%>
<%@page import="service.ProductAdminService.ProductManager"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Easy Buy</title>

    <!-- Bootstrap -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    .ghabox{
    		width:100%;
    		height:380px;
    }
    .ghabox-side{
    		width:100%;
    		height:150px;
    }
    .ghabox-bottom{
    		width:100%;
    		height:300px;
    }
    </style>
  </head>
  <body style="background:#999;">
  	<p><br/></p>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
<!--                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="ghabox">

                            </div>
                        </div>
                    </div>-->
                    <%
                    List<Item> items=ProductManager.getAllProducts();
                    
                    for(Item myProduct:items)
                    {                     
                        out.println("<div class=\"row\">");
                        out.println("<div class=\"col-md-4\">");
                        out.println("<div class=\"panel panel-primary\">");
                        out.println("<div class=\"panel-heading\">");
                        out.println("<h3 class=\"panel-title\">"+myProduct.getProductName()+"</h3>");
                        out.println("</div>");
                        out.println("<div class=\"panel-body\">");
                        out.println("<div class=\"ghabox-bottom\">");
                        out.println("<h1><img src=\"GetItemImage?id=" + myProduct.getProductId() + "\" width=\"100\" height =\"100\"  border=\"1\">  </h1>");
                        out.println("<p>" + myProduct.getProductDetails() + "</p>");
                        out.println("<p>" + myProduct.getPrice() + " Rs.</p>");                        
                        out.println("<p><a href=\"#\" class=\"btn btn-primary btn-primary\">Buy IT</a></p>");                        
                        out.println("<p><a href=\"GetProductDetails?productid="+myProduct.getProductId()
                                +"\" class=\"btn btn-success btn-primary\">Details</a></p>");
                        out.println("</div>");                        
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                    }
                    %>
<!--                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title"></h3>
                                </div>
                                <div class="panel-body">
                                    <div class="ghabox-bottom">

                                    </div>
                                </div>
                            </div>
                        </div>-->

                    </div>
                </div>
            </div>
        </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>
