<%@page import="model.Store.Item"%>
<%@page import="java.util.List"%>
<%@page import="service.ProductAdminService.ProductManager"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="data:image/x-icon;base64,AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5Pbt/3zUqv8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGrOnv9qzp7/uunT/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1vn9/5bu+v/A9fz/6/z+f7Dmzf9qzp7/as6e/2vQov/1+/V/4eK+f8jKiP/Fx4D/AAAAAAAAAAAAAAAAAAAAANP4/X9a5Pf/WuT3/13l+P/6/fx/as6e/2rOnv+S3b3/wsJ1/5GVEf+RlRH/qKtD/wAAAAAAAAAAAAAAAAAAAADs/P5/WuT3/1rk9/9a5Pf/4fr+f5fduf9qzp7//P79f52hK/+RlRH/kZUR/77Bc/8AAAAAAAAAAAAAAAAAAAAAAAAAAHvs+f9a5Pf/WuT3/6Xw+//7/vx/s+fP//n58X+RlRH/kZUR/5ebH//x8d//AAAAAAAAAAAAAAAAAAAAAFqW9v+bv/r//v//f9X6/X/H9v3/AAAAAAAAAADt7tl/ysyN//Pz5H//+e1//8xp///47f8AAAAA4u7+/yZ28/8mdvP/Jnbz/yh38/+1z/v/AAAAAAAAAAAAAAAAAAAAAP/893/+zGz//Lk2//y5Nv/8uTb//tuX/6/N+/8mdvP/Jnbz/yZ28/8mdvP/j7n5/wAAAAAAAAAAAAAAAAAAAAD/9d7//Lw8//y5Nv/8uTb//Lk2//3ASv8AAAAA9vr/fzSA9f9YmPb//P3/f/j3/n/Z0/h/AAAAAAAAAAD//v9/9977fwAAAAD/5Kj//b5A//7fov8AAAAAAAAAAAAAAAD9/P9/wbTz/3he5v9dQOH/mIXs//78/3/s0///+N35f8UC0f/IENT/2Fjl/wAAAAAAAAAAAAAAAAAAAAAAAAAA8u/9f11A4f9dQOH/XUDh/9bQ93/Lhf7/pTT9/wAAAADIENT/xQLR/8UC0f/heOf/AAAAAAAAAAAAAAAAAAAAAN3W+X9dQOH/XUDh/11A4f/+/f9/pTP8/6Uz/P/UoP7/2E7e/8UC0f/FAtH/1UXd/wAAAAAAAAAAAAAAAAAAAAC9sfP/a1Hk/4dx6f/AtvP/y4b+/6Uz/P+lM/z/pTT9//36///ZW+H/0DHa/9VI3v8AAAAAAAAAAAAAAAAAAAAA/v3/fwAAAAAAAAAAAAAAAPv1//+lM/z/pTP8/8Z//v8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1J7+/6c4/P8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/n8AAP4/AADEMwAA4gMAAOJDAADhQwAAzdkAAAPgAAADwAAAz/EAAOFHAADiQwAA4gMAAMADAAD8PwAA/n8AAA==" rel="icon" type="image/x-icon" />
        <title>Easy Buy!</title>
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="css/style.css" rel="stylesheet">-->
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body >
        <div id="wrap">
            <div class="container-">

                <%@include file="/Header.jsp" %>
                <% String id = request.getParameter("itemid");
                    request.setAttribute("itemid", id);
                    Item myProduct = ProductManager.getProductByID(Integer.parseInt(id));
                %>
                <div class="row">
                    <div class="col-md-6">
                        <!--<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/" class="img-thumbnail" />-->
                        <%
                            out.println("<h1><img src=\"GetItemImage?id=" + id + "\" width=\"400\" height =\"400\"  border=\"1\">  </h1>");
                        %>
                        <h2>
                            <%
                                out.println(myProduct.getProductName());
                            %>
                        </h2>
                        <p>
                            <%
                                out.println(myProduct.getProductDetails());
                            %>   
                        </p>


                        <form name="_xclick" action="https://www.paypal.com/in/cgi-bin/webscr" method="post">
                            <input type="hidden" name="cmd" value="_xclick">
                            <input type="hidden" name="business" value="roshan.atl@gmail.com">
                            <input type="hidden" name="currency_code" value="INR">
                            <input type="hidden" name="item_name" value="<% out.println(myProduct.getProductName());%>">
                            <input type="hidden" name="amount" value="<% out.println(myProduct.getPrice());%>">
                            <input type="image" src="http://www.paypal.com/en_GB/i/btn/x-click-but01.gif" border="0" name="submit" alt="Make payments with PayPal - it's fast, free and secure!">
                        </form>



                    </div>
                    <div class="col-md-6">                        
                        <form role="form" action="ConfirmPurchase" method="post">                            
                            <div class="form-group">
                                <label for="InputAddress1">
                                    Delivery Address Line 1
                                </label>
                                <input type="text" name ="InputAddress1" required class="form-control" id="InputAddress1" />
                            </div>
                            <div class="form-group">
                                <label for="InputAddress2">
                                    Delivery Address Line 2
                                </label>
                                <input type="text" name ="InputAddress2" class="form-control" id="InputAddress2" />
                            </div>
                            <div class="form-group">
                                <label for="city">
                                    City
                                </label>
                                <input type="text" name ="city" required class="form-control" id="city" />              

                            </div >
                            <div class = "form-group">
                                <label for="state">
                                    State
                                </label>
                                <select name=state required class="form-control" id="state">
                                    <option value="">------------Select State------------</option>
                                    <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                                    <option value="Andhra Pradesh">Andhra Pradesh</option>
                                    <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                    <option value="Assam">Assam</option>
                                    <option value="Bihar">Bihar</option>
                                    <option value="Chandigarh">Chandigarh</option>
                                    <option value="Chhattisgarh">Chhattisgarh</option>
                                    <option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
                                    <option value="Daman and Diu">Daman and Diu</option>
                                    <option value="Delhi">Delhi</option>
                                    <option value="Goa">Goa</option>
                                    <option value="Gujarat">Gujarat</option>
                                    <option value="Haryana">Haryana</option>
                                    <option value="Himachal Pradesh">Himachal Pradesh</option>
                                    <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                                    <option value="Jharkhand">Jharkhand</option>
                                    <option value="Karnataka">Karnataka</option>
                                    <option value="Kerala">Kerala</option>
                                    <option value="Lakshadweep">Lakshadweep</option>
                                    <option value="Madhya Pradesh">Madhya Pradesh</option>
                                    <option value="Maharashtra">Maharashtra</option>
                                    <option value="Manipur">Manipur</option>
                                    <option value="Meghalaya">Meghalaya</option>
                                    <option value="Mizoram">Mizoram</option>
                                    <option value="Nagaland">Nagaland</option>
                                    <option value="Orissa">Orissa</option>
                                    <option value="Pondicherry">Pondicherry</option>
                                    <option value="Punjab">Punjab</option>
                                    <option value="Rajasthan">Rajasthan</option>
                                    <option value="Sikkim">Sikkim</option>
                                    <option value="Tamil Nadu">Tamil Nadu</option>
                                    <option value="Telingana">Telingana</option>
                                    <option value="Tripura">Tripura</option>
                                    <option value="Uttaranchal">Uttaranchal</option>
                                    <option value="Uttar Pradesh">Uttar Pradesh</option>
                                    <option value="West Bengal">West Bengal</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="zip">
                                    pin
                                </label>
                                <input type="text" name="zip" required class="form-control" id="zip"  />

                                <input type="hidden" name="itemid"  value= ${ param.itemid }   />
                            </div>
                            <div class="form-group">

                                <p class="help-block">
                                    Expected delivery in 5-7 days.
                                </p>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" /> Do a Gift Wrap (Rs 30 Extra )
                                </label>
                            </div> 
                            <%@include file="/Payment.jsp" %>
                            <button type="submit" class="btn btn-success  btn-lg">
                                Pay it 
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>



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