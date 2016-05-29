<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!--<div class="row-fluid">
    <div class="col-md-12">-->
        <nav class="navbar navbar-inverse " role="navigation" style="color: gold">
            <div class="navbar-header">

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button> <a style="color: chartreuse"class="navbar-brand" href="index.jsp">EasyBuy!</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="AddProduct">Sell in EasyBuy</a>
                    </li>
                    <li>
                        <a href="#"></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Seller Options<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="GetBalanceDetails">EasyBuy Balance</a>
                            </li>
                            <li>
                                <a href="GetSellerOrderDetails">My Received Orders</a>
                            </li>

                            <li class="divider">
                            </li>
                            <li>
                                <a href="#">How do I get EasyBuy Balance?</a>
                            </li>

                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <c:choose>
                            <c:when test="${myUser.getAccount_id() > 0 }">                                             
                                <a href="#">${myUser.getName()}</a>                                            
                            </c:when>
                            <c:otherwise>                                            
                                <a href="login.jsp">Login</a>                                              
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Options<strong class="caret"></strong></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="GetOrderDetails">My Orders</a>
                            </li>
                            <c:if test="${myUser.getAccount_id() > 0 }"> 
                                <li>
                                    <a href="Logout">Logout</a>
                                </li>
                            </c:if>                                            

                        </ul>
                    </li>
                </ul>
            </div>

        </nav>
<!--    </div>
</div>-->

