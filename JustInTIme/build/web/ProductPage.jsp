<%@page import="source.Product"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Products</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">

    </head>
    <nav id="navbar navbar-inverse navbar-fixed-top" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div id="container" class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div id="navbar-header" class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span id="sr-only" class="sr-only">Toggle navigation</span>
                    <span id="icon-bar" class="icon-bar"></span>
                    <span id="icon-bar" class="icon-bar"></span>
                    <span id="icon-bar" class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Welcome Product Manager</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="nav navbar-nav" class="nav navbar-nav">
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
                <ul id="nav navbar-nav navbar-right" class="nav navbar-nav navbar-right">
                    <li>
                        <a id="cart" href="#">Cart</a>
                    </li>
                    <li>
                        <a id="logout" href="#">Logout</a>
                    </li>
                </ul>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Products ================================================== -->

    <table border="1" style="width:35%" align = "center">
        <tr>
            <th align = "center">Product Name</th>
            <th align = "center">Product Number</th>
            <th align = "center">Product Price</th>
            <th align = "center">Product Availability</th>
            <th align = "center">Product Description</th>
        </tr>

        <c:forEach items="${productList}" var="product">

            <tr>
                <td align = "center"><a href="http://localhost:8080/JustInTime/HomePage.jsp">${product.itemName}</a></td>
                <td align = "center">#${product.itemNo}</td>
                <td align = "center">$${product.itemPrice}</td>
                <td align = "center">${product.itemCount}</td>
                <td align = "center">${product.itemDescription}</td>
            </tr>
        </c:forEach>
            
    </table>

    

</body>
</html>