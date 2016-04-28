<%-- 
    Document   : PODetails
    Created on : Apr 26, 2016, 10:07:52 PM
    Author     : jacobveal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="source.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .floating-box {
                display: inline-block;
                width: 300px;
                height: auto;
                margin: 1em;
            }

            img{
                max-width: 100%;
                height: auto;
            }


            .after-box {
                border: 3px solid red; 
            }
        </style>

        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>PO Details</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">

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


    <!-- Products ================================================== -->

    <div style="text-align: center" class="container">
        <c:forEach var="item" items="${purchase.purchasedItems.productArray}">
            <div id="hero-feature" class="floating-box">
                <div style="height:100%">
                        <img src="images/${item.imageUrl}" alt="Image not found" style="height:50%">                            
                        <h3>${item.itemName}</h3>
                        <p>Quantity: ${item.itemCount}</p>
                        <p>Price:$ ${item.itemPrice}</p>
                        <p>${item.itemDescription}</p>
                        <p>Delivery Date: ${item.deliveryDate}</p>
                </div>
            </div>

        </c:forEach>
    </div>




</body>
</html>