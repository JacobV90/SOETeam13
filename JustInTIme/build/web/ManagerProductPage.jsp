<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <title>Product</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/tables.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">
        <style>
            .dropdown {
                position: relative;
                display: inline-block;
            }
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 200px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
            }
            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>    

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
                <a class="navbar-brand">Welcome Product Manager</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <form id ="Manage" action="ModifyProduct" method="post">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="navnavbar-nav" class="nav navbar-nav">
                        <li>
                            <a id="myaccount" href="#">My account</a>
                        </li>
                        <!--                    <li>
                                                <a id="mysettings" href="#">My Settings</a>
                                            </li>-->
                        <li>
                            <a id="myorder" href="#">My order</a>
                        </li>
                        <li>
                            <a id="addproduct" href="AddProduct.jsp">Add Product</a>
                        </li>
                        <li>
                            <a id="editproduct" href="ModifyProduct.jsp">Edit Product</a>
                        </li>
                    </ul>
            </form>
            <ul id="navnavbar-navnavbar-right" class="nav navbar-nav navbar-right">
                <li>
                    <a id="logout" href="index.jsp">Logout</a>
                </li>
            </ul>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<style>
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 200px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        padding: 12px 16px;
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>    

<!-- Products ================================================== -->

<div align="center">
    <h4>Products</h4>
    <table border="1" id="table" align = "center">
        <div>
            <input type="hidden" name="action" value="details" />
            <input type="hidden" name="filter" value="manager" />

        </div


        <tr>
            <th align = "center">Product Name</th>
            <th align = "center">Product Number</th>
            <th align = "center">Product Price</th>
            <th align = "center">Product Availability</th>
            <th align = "center">Product Size</th>
            <th align = "center">Product Description</th>
        </tr>

        <c:forEach items="${productList.productArray}" var="product">
            <c:url value="/ProductServlet" var = "productDetails">
                <c:param name = "productNumber" value = "${product.itemNo}"/>
                <c:param name = "action" value = "details"/>
            </c:url>
            <tr>
                <td align = "center"><a href="${productDetails}">${product.itemName}</td>
                <td align = "center">#${product.itemNo}</td>
                <td align = "center">$${product.itemPrice}</td>
                <td align = "center">${product.itemCount}</td>
                <td align = "center">${product.size}</td>
                <td align = "center">${product.itemDescription}</td>
            </tr>

        </c:forEach>

    </table>
</div>
<div style="height:25px"></div>
<div align="center">

    <h4>Returns</h4>
    <table border="1" id="table" align = "center">
        <div>
            <input type="hidden" name="action" value="details" />
            <input type="hidden" name="filter" value="manager" />

        </div


        <tr>
            <th align = "center">Purchase Order</th>
            <th align = "center">Item Number</th>
            <th align = "center">User Email</th>
            <th align = "center">Reason for Return</th>
        </tr>

        <c:forEach items="${returns}" var="item">

            <tr>
                <td align = "center">${item[0]}</td>
                <td align = "center">${item[1]}</td>
                <td align = "center">${item[2]}</td>
                <td align = "center">${item[4]}</td>
            </tr>
            
        </c:forEach>

    </table>


</div>
</body>
</html>