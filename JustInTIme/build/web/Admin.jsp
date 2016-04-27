<%-- 
    Document   : Admin
    Created on : Apr 27, 2016, 11:42:20 AM
    Author     : jacobveal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="css/inline.css" rel="stylesheet">

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


    <!-- Admin ================================================== -->
    <div  style="text-align: center; height: 400px">
        <div class="floating-box">
            <table border="1"  align = "center" >

                <tr>
                    <th align = "center">Email</th>
                    <th align = "center">First Name</th>
                    <th align = "center">Last Name</th>
                    <th align = "center">Phone Number</th>
                    <th align = "center">Role</th>

                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <c:forEach items="${user}" var="value">
                            <td align = "center">${value}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="floating-box" style="width:50px"></div>


        <div class="floating-box">
            <table border="1"  align = "center" >

                <tr>
                    <th align = "center">Email</th>
                    <th align = "center">First Name</th>
                    <th align = "center">Last Name</th>
                    <th align = "center">Phone Number</th>
                    <th align = "center">Role</th>

                </tr>
                <c:forEach items="${managers}" var="user">
                    <tr>
                        <c:forEach items="${user}" var="value">
                            <td align = "center">${value}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="floating-box" style="width:50px"></div>


        <div class="floating-box">
            <table border="1"  align = "center" >

                <tr>
                    <th align = "center">Email</th>
                    <th align = "center">First Name</th>
                    <th align = "center">Last Name</th>
                    <th align = "center">Phone Number</th>
                    <th align = "center">Role</th>

                </tr>
                <c:forEach items="${admins}" var="user">
                    <tr>
                        <c:forEach items="${user}" var="value">
                            <td align = "center">${value}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="floating-box" style="width:50px"></div>
        <div class="floating-box">
            <table border="1"  align = "center" >

                <tr>
                    <th align = "center">Email</th>
                    <th align = "center">Status</th>
                    <th align = "center">Role</th>
                    <th align ="center">Promote</th>
                    <th align ="center">Demote</th>
                </tr>

                <c:forEach items="${pending}" var="user">
                    <tr>
                        <c:set var="poNumflag" value="0"/>
                        <c:forEach items="${user}" var="value">
                            <c:if test="${poNumflag == '0'}">
                                <c:set var="email" value="${value}"/>
                                <c:set var="poNumflag" value="1"/>
                            </c:if>
                            <c:set var="role" value="${value}"/>
                            <c:if test="${role == 'Manager' || role == 'Administrator'}">
                                <c:set var="Role" value="${role}"/>
                            </c:if>
                                <td align = "center">${value}</td>
                        </c:forEach>
                        <td align ="center">
                            <form action ="AdminActionServlet" method ="post">
                                <input type="hidden" name="role" value="${Role}">
                                <input type="hidden" name="user" value="${email}">
                                <input type="submit" name="action" value="promote">
                            </form>
                        </td>
                        <td align ="center">
                            <form action ="AdminActionServlet" method ="post">
                                <input type="hidden" name="role" value="${Role}">
                                <input type="hidden" name="user" value="${email}">
                                <input type="submit" name="action" value="demote">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
