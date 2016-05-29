
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="data:image/x-icon;base64,AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5Pbt/3zUqv8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGrOnv9qzp7/uunT/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1vn9/5bu+v/A9fz/6/z+f7Dmzf9qzp7/as6e/2vQov/1+/V/4eK+f8jKiP/Fx4D/AAAAAAAAAAAAAAAAAAAAANP4/X9a5Pf/WuT3/13l+P/6/fx/as6e/2rOnv+S3b3/wsJ1/5GVEf+RlRH/qKtD/wAAAAAAAAAAAAAAAAAAAADs/P5/WuT3/1rk9/9a5Pf/4fr+f5fduf9qzp7//P79f52hK/+RlRH/kZUR/77Bc/8AAAAAAAAAAAAAAAAAAAAAAAAAAHvs+f9a5Pf/WuT3/6Xw+//7/vx/s+fP//n58X+RlRH/kZUR/5ebH//x8d//AAAAAAAAAAAAAAAAAAAAAFqW9v+bv/r//v//f9X6/X/H9v3/AAAAAAAAAADt7tl/ysyN//Pz5H//+e1//8xp///47f8AAAAA4u7+/yZ28/8mdvP/Jnbz/yh38/+1z/v/AAAAAAAAAAAAAAAAAAAAAP/893/+zGz//Lk2//y5Nv/8uTb//tuX/6/N+/8mdvP/Jnbz/yZ28/8mdvP/j7n5/wAAAAAAAAAAAAAAAAAAAAD/9d7//Lw8//y5Nv/8uTb//Lk2//3ASv8AAAAA9vr/fzSA9f9YmPb//P3/f/j3/n/Z0/h/AAAAAAAAAAD//v9/9977fwAAAAD/5Kj//b5A//7fov8AAAAAAAAAAAAAAAD9/P9/wbTz/3he5v9dQOH/mIXs//78/3/s0///+N35f8UC0f/IENT/2Fjl/wAAAAAAAAAAAAAAAAAAAAAAAAAA8u/9f11A4f9dQOH/XUDh/9bQ93/Lhf7/pTT9/wAAAADIENT/xQLR/8UC0f/heOf/AAAAAAAAAAAAAAAAAAAAAN3W+X9dQOH/XUDh/11A4f/+/f9/pTP8/6Uz/P/UoP7/2E7e/8UC0f/FAtH/1UXd/wAAAAAAAAAAAAAAAAAAAAC9sfP/a1Hk/4dx6f/AtvP/y4b+/6Uz/P+lM/z/pTT9//36///ZW+H/0DHa/9VI3v8AAAAAAAAAAAAAAAAAAAAA/v3/fwAAAAAAAAAAAAAAAPv1//+lM/z/pTP8/8Z//v8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1J7+/6c4/P8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/n8AAP4/AADEMwAA4gMAAOJDAADhQwAAzdkAAAPgAAADwAAAz/EAAOFHAADiQwAA4gMAAMADAAD8PwAA/n8AAA==" rel="icon" type="image/x-icon" />
        <title>Add new Item</title>
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="css/style.css" rel="stylesheet">-->
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/Header.jsp" %>
        <h1> Add a Item to List in EasyBuy!!</h1>
        <form action="AddProduct" method="post" enctype="multipart/form-data">
            <p> 
                <label for="itemName">Item Name </label>
                <input  id="itemName" type="text" name="itemname" required/> 
            </p>

            <p> 
                <label for="itemDetails">Item Details </label>
                <input id="itemDetails" type="text" name="itemdetails" required />
            </p>
            <p> 
                <label for="itempic">Item Picture </label>
                <input id="itempic" type="file" name="itempic" required/>
            </p>
            <p> 
                <label for="itemprice">Item Price </label>
                <input id="itemprice" type="text" name="itemprice" required/>
            </p>
            <p> 
                <label for="itemquantity">Item Quatity </label>
                <input id="itemquantity" type="text" name="itemquantity" required/>
            </p>
            
            
            <p><input type="submit" value="Add Item"/> </p>
        </form>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>
