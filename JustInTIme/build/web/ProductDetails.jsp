<%-- 
    Document   : ProductDetail
    Created on : Mar 27, 2016, 6:37:37 PM
    Author     : Owner
--%>

<%@page import="source.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <style>
            .floating-box {
                display: inline-block;
                max-width: 300px;
                max-height:300px;
                margin: 1em;
            }

            img{
                width: 100%;
                height: 100%;
            }


            .after-box {
                border: 3px solid red; 
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">


        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">
        <title>Product Detail</title>
    </head>
    <body>
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

        <div align="center" style="height:100%">
            <div class="floating-box">
                <div id="thumbnail" >
                    <img src="images/${product.imageUrl}" alt = "Image not found" class="img">
                </div>
            </div>

            <div class="floating-box">
                <div id="thumbnail"  >

                    <form id="productDescription" action = "CartServlet" method = "post">
                        <fieldset>  
                            <p><label for="txtproductNumber">Product #: </label> <label for="txtproductNumber"><c:out value="${product.itemNo}"/></label></p>
                            <p><label for="txtProductName">Name: </label> <label for="txtproductNumber"><c:out value="${product.itemName}"/></label></p>
                            <p><label for="txtproductQuantity" id = "productCount">Availability: <label><c:out value="${product.itemCount}"/></label> 
                                    <c:if test="${role == 'User'}" >
                                        <input type='button' name='add' onclick="addQty();" value='+'/>
                                        <input type='text' name='qty' id='qty' size = '4' value ="0">
                                        <input type='button' name='subtract' onclick="subtractQty();" value='-'/>
                                    </c:if>
                            </p>
                            <p><label for="productPrice">Price: </label> $<label for="txtproductNumber"><c:out value="${product.itemPrice}"/></label></p>
                            <p><label for="productPrice">Size: </label><label for="txtproductNumber"><c:out value="${product.size}"/></label></p>
                            <p><label for="productDescription">Description: </label> <label for="txtproductNumber"><c:out value="${product.itemDescription}"/></label></p>




                            <c:if test="${role.equals('User')}" >
                                <input type="hidden" name="productNumber" value="${product.itemNo}" />
                                <input type="hidden" name="action" value="addtocart" />

                                <p><input class="btn-primary" id="addToCart" type="submit" name="submit" value="addtocart" style="width: 100px" onclick='javascript: checkQty();' > </p>
                                <p>  <input class="btn-primary" id="Cancel" type="submit" name="submit" style="width: 100px" value="Cancel" ></p>
                                </c:if>

                        </fieldset>  

                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            function subtractQty() {
                var value = document.getElementById("qty").value;
                if (value <= 0) {
                    return;
                } else {
                    document.getElementById("qty").value--;
                }
            }
            function addQty() {
                var value = document.getElementById("qty").value;
                var max = <%=request.getParameter("productCount")%>;
                if (value >= max) {
                    return;
                } else {
                    document.getElementById("qty").value++;
                }
            }
        </script>
    </body>
</html>