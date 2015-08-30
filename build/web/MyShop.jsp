<%@page import="java.util.List"%>
<%@page import="service.ProductAdminService.ProductManager"%>
<%@page import="model.admin.Item"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Easy Buy!</title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--<link href="css/style.css" rel="stylesheet">-->
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">



    </head>


    <body >
        <div id="wrap">
            <div class="container-">
                <div class="row-fluid">
                    <div class="col-md-12">
                        <nav class="navbar navbar-inverse" role="navigation" style="color: gold">
                            <div class="navbar-header">

                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                                </button> <a class="navbar-brand" href="#">EasyBuy!</a>
                            </div>

                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li class="active">
                                        <a href="admin.jsp">Sell in EasyBuy</a>
                                    </li>
                                    <li>
                                        <a href="#">Contact</a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#">Action</a>
                                            </li>
                                            <li>
                                                <a href="#">Another action</a>
                                            </li>
                                            <li>
                                                <a href="#">Something else here</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">Separated link</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">One more separated link</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>

                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="#">Login</a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#">My Orders</a>
                                            </li>
                                            <li>
                                                <a href="#">Another action</a>
                                            </li>
                                            <li>
                                                <a href="#">Something else here</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>

                        </nav>
                    </div>
                </div>
                <div class="row-fluid">	
                    <%
                        List<Item> items = ProductManager.getAllProducts();
                        for (Item myProduct : items) {
                            out.println("<div class=\"col-md-3\">");
                            out.println("<h4>" + myProduct.getProductName() + "</h4>");
                            out.println("<h1><img src=\"GetItemImage?id=" + myProduct.getProductId() + "\" width=\"120\" height =\"150\"  border=\"0\">  </h1>");
                            out.println("<p>" + myProduct.getProductDetails() + "</p>");
                            out.println("<p>" + myProduct.getPrice() + " Rs.</p>");
                            out.println("<p><a href=\"#\" class=\"btn btn-primary btn-primary\">Buy IT</a></p>");
                            out.println("<p><a href=\"GetProductDetails?productid=" + myProduct.getProductId()
                                    + "\" class=\"btn btn-success btn-primary\">Details</a></p>");
                            out.println("</div>");
                        }
                    %>


                </div>
            </div>
        </div> 

        <div class="navbar  navbar-nav" style="background-color: #333333;color: threedface ">
            <div class="container">
                <div class="row"  >
                    <div class="col-md-12">
                        <h4>
                            Sell an Item With EasyBuy
                        </h4>
                        <p>
                            List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.

                        </p>
                        <p class="addthis_horizontal_follow_toolbox"></p>
                    </div>
                  
                    <div class="col-md-12">
                        <address style="color: greenyellow">
                            <strong>EasyBuy</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                        </address>
                    </div>
                </div>                
            </div>
        </div>                    


        <!--                    <div id="footer"  >
                                <div class="container"   >
                                    <div class="row"  >
                                        <div class="col-md-12">
                                            <h2>
                                                Sell an Item With EasyBuy
                                            </h2>
                                            <p>
                                                List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.
        
                                            </p>
                                            <p class="addthis_horizontal_follow_toolbox"></p>
                                        </div>
                                        <div class="col-md-12">
        
                                            <address>
                                                <strong>EasyBuy, Inc.</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                                            </address>
                                        </div>
        
        
                                    </div>
                                </div>
                            </div>                  -->
        <!--        <div  class="row" style="background: #DEE1E2;">
                    <div class="col-md-8">
                        <h2>
                            Sell an Item With EasyBuy
                        </h2>
                        <p>
                            List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.
        
                        </p>
                        <p class="addthis_horizontal_follow_toolbox"></p>
        
                    </div>
                    <div class="col-md-4">
        
                        <address>
                            <strong>EasyBuy, Inc.</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                        </address>
                    </div>
                </div>-->

        <!-- Go to www.addthis.com/dashboard to customize your tools -->

        <!-- Go to www.addthis.com/dashboard to customize your tools -->
        <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-55df0267066c5ea4" async="async"></script>

        <!--    <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/scripts.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>