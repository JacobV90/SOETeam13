<%-- 
    Document   : Cart
    Created on : Mar 29, 2016, 5:35:45 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
<!--        <link rel="stylesheet" href="css/style2.css">-->
        <title>Cart</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <%
            String name = request.getParameter("name");
            String role = request.getParameter("role");
        %>

    </head>
    <!-- Navigation -->
    <body>
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
                    <a class="navbar-brand">Hello ${name}, ${role}</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="nav navbar-nav" class="nav navbar-nav">
                        <li>
                            <a id="myaccount" href="#">My account</a>
                        </li>
                        <li>
                            <a id="homepage" href="HomePage.jsp">Home</a>
                        </li>
                        <li>
                            <a id="logout" href="LogoutServlet">Logout</a>
                        </li>
                        
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <hr>
        <!-- Title -->
        <div id="row" class="row">
            <div id="col-lg-12" class="col-lg-12">
                <div id="search" class="search">
                    <form action = "SearchServlet" method ="post">
                        <input type="text" name="Product">
                        <input type ="submit" value="Search">
                    </form>
                </div><h2>Cart</h2>
            </div>
        </div>
        <!-- /.row -->        
        <!-- Page Features -->
       

                <c:forEach items = "${Cart.productArray}" var ="product">

                    <div id="thumbnail" class="thumbnail">

                        <img src="images/${product.imageUrl}" alt="Image not found" width ="500" height="350">
                        <div id="caption" class="caption">
                            <h3>${product.itemName}</h3>
                            <p>${product.itemCount}</p> 
                            <p>Total: $${product.totalPrice}</p>
                            <form action ="CartServlet" method ="post">
                                <input type="hidden" name="action" value="deletefromcart">
                                <input type="hidden" name="productNumber" value="${product.itemNo}">
                                <input type = "submit" value="Remove">
                            </form>
                        </div>

                    </div>


                </c:forEach>


            <div>
                <p>Total Price -> $${Cart.cartPrice}</p>
                <!--                    <p><input class="button" id="buy" type="submit" name="payAmount" value="Pay" ></p>
                                    <p><input class="button" id="Cancel" type="submit" name="Cancel" value="Cancel" ></p>-->
                
                <form name = "pay"  action = "POBufferServlet" method="post">
                    
                    <p><input class="btn btn-primary" id="pay" type = "submit" name="Pay"></p>
                    <p><a class="btn btn-primary" id="cancel" href="homePage.jsp">Cancel</a></p>
                    
                </form>      
            </div>

            <!-- jQuery -->
            <script src="js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="js/bootstrap.min.js"></script>
    </body>
</html>

