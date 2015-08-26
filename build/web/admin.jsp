<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Item</title>
    </head>
    <body>
        <h1> Add a Item to List in EasyBuy!!</h1>
        <form action="AddProduct" method="post" enctype="multipart/form-data">
            <p>Item name : <input type="text" name="itemname" </p>
            <p>Item details : <input type="text" name="itemdetails"</p>
            <p>Item image : <input type="file" name="itempic" </p>
            <p>Item price : <input type=text name="itemprice"</p>
            <p>Item quantity : <input type=text name="itemquantity"</p>
            <p><input type="submit" value="Add Item" </p>
        </form>
    </body>
</html>
