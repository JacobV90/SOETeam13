<%@page import="source.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <title>Purchase Orders</title>
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
                        <a id="myaccount" href="Account.html">My account</a>
                    </li>
                    <li>
                        <a id="mysettings" href="Admin.html">My Settings</a>
                    </li>
                    <li>
                        <a id="myorder" href="Order.html">My order</a>
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


    <!-- Order ================================================== -->
    <div>
        <input type="hidden" name="action" value="details" />
    </div>
    <table border="1" style="width:60%" align = "center">

        <tr>
            <th align = "center">Number</th>
            <th align = "center">$Cost</th>
            <th align = "center">Order Date</th>
            <th align = "center">Delivery Date</th>
            <th align = "center">Details</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <c:set var="poNumflag" value="0"/>
                <c:forEach items="${order}" var="value">

                    <c:if test="${poNumflag == '0'}">
                        <c:set var="poNum" value="${value}"/>
                        <c:set var="poNumflag" value="1"/>
                    </c:if>
                    <td align="center">${value}</td>
                </c:forEach>


                <td>  
                    <form method="get" action="PurchaseOrderDetails">
                        <input type="submit" value="Go"/>
                        <input type="hidden" name="details" value="${poNum}"/>
                    </form>
                </td>
            </tr>
        </c:forEach>



    </table>

</body>
</html>