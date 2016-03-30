
<%-- 
    Document   : Thanks
    Created on : Mar 30, 2016, 12:30:55 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PayPage</title>

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

</head>

<body>

    <!-- Navigation -->
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
                <a class="navbar-brand">Welcome User</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="nav navbar-nav" class="nav navbar-nav">
                    <li><a id="myaccount" href="#">My account</a></li>
                    <li><a id="myorder" href="#">My order</a></li>
                </ul>
                <ul id="nav navbar-nav navbar-right" class="nav navbar-nav navbar-right">
                <li><a id="cart" href="Cart.jsp">Cart</a></li>
		<li><a id="logout" href="index.jsp">Logout</a></li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
        <!-- Page Content -->

        <div class="container">

		        <!-- Jumbotron Header -->
		        <header id="jumbotron hero-spacer" class="jumbotron hero-spacer">
		            <h1>Pay</h1>
		        </header>    
                            <p><label for="txtTotalAmount">Total Amount</label><input id="totalAmount" type="text" name="txttotalAmount" size="10"></p>
		        <form id ="Pay" action="LoginServlet" method="post">
<!--                    <p><input class="button" id="buy" type="submit" name="payAmount" value="Pay Amount"> 
                        <input class="button" id="Cancel" type="submit" name="Cancel" value="Cancel" ></p>-->
                        <p><a class="btn btn-primary" id="paylink" type="submit" href="Thanks.jsp">Pay Amount</a></p>
                        <p><a class="btn btn-primary" id="paylink" type="submit" href="homePage.jsp">Cancel</a></p>
                        </form>
                        
</html>


