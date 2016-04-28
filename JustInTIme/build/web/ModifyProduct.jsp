<%-- 
    Document   : ModifyProduct
    Created on : Mar 27, 2016, 4:50:57 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">
        <title>Modify Product</title>
    </head>

    <nav id="navbarnavbar-inversenavbar-fixed-top" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div id="container" class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div id="navbar-header" class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span id="sr-only" class="sr-only">Toggle navigation</span>
                    <span id="icon-bar" class="icon-bar"></span>
                    <span id="icon-bar" class="icon-bar"></span>
                    <span id="icon-bar" class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Just In Time Inventories</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="navnavbar-nav" class="nav navbar-nav">
                    <li>
                        <a id="myaccount" href="#">My account</a>
                    </li>
                    <li>
                        <a id="mysettings" href="#">My Settings</a>
                    </li>
                    <li>
                        <a id="myorder" href="#">My order</a>
                    </li>
                </ul>
                <ul id="navnavbar-navnavbar-right" class="nav navbar-nav navbar-right">
                    <li>
                        <a id="cart" href="CartBufferServlet">Cart</a>
                    </li>
                    <li>
                        <a id="logout" href="LogoutServlet">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div align="center">
        <h1>Modify Product</h1>
        <div  align = "center" class="form">
            <form id="modifyProducForm" action = "ProductServlet" method="post" enctype="multipart/form-data">
                <fieldset>
                    <p><label for="txtproductNumber">Product #:</label><input id="prodNum" type="text" name="itemNum" size="20" tabindex="1"></p>
                    <p><label for="txtProductName">Product Name</label><input id="prodName" type="text" name="ProductName" size="20" tabindex="1"></p>  
                    <p><label for="productPrice">Product Price</label><input id="productPrice" name="ProductPrice" tabindex="1" type="text" size="20"></p>
                    <p><label for="txtproductQuantity">Product Quantity</label><input id="ProductQuantity" type="text" name="ProductQuantity" size="20" tabindex="1"></p>
                    <p><label for="productDescription">Product Description</label><input id="productDescription" name="ProductDescription" tabindex="1" type="text" size="20"></p>
                    <p><label for="image"><input type="file" name="file"></p>
                    <p><input class="btn-primary" id="modify" type="submit" name="submit" value="Modify"  style="width: 100px">  
                        <input class="btn-primary" id="delete" type="submit" name="submit" value="Delete"  style="width: 100px"> 
                        <input class="btn-primary" id="Cancel" type="submit" name="submit" value="Cancel"  style="width: 100px"> </p>                    

                </fieldset>  

            </form>


        </div>
    </div>
</body>
</html>