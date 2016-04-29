<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Home Page</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/heroic-features.css" rel="stylesheet">

    </head>

    <body>

        <!-- Navigation -->
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
                    <a class="navbar-brand">Hello, ${firstName}</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="navnavbar-nav" class="nav navbar-nav">
                        <li>
                            <a id="myaccount" href="Account.jsp">My account</a>
                        </li>
                        <li>
                            <a id="myorder" href="MyOrdersServlet">My orders</a>
                        </li>
                    </ul>
                    <ul id="navnavbar-navnavbar-right" class="nav navbar-nav navbar-right">
                        <li>
                            <a id="logout" href="CartBufferServlet">Cart</a>
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

        <!-- Page Content -->
        <div id="search" class="search">
            <form action = "SearchServlet" method ="post">
                <input type="text" name="Product">
                <input type ="submit" value="Search">
            </form>
        </div>
        <div class="container">

            <!-- Jumbotron Header -->
            <header id="jumbotronhero-spacer" class="jumbotron hero-spacer">
                <h1>Welcome to JustInTime</h1>
                <p>Use our search bar to find the best products at the lowest prices.</p>
            </header>
        </div>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
