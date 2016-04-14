<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HomePage</title>

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
                    <a class="navbar-brand">Hello ${name}, ${role}</a>
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
            <header id="jumbotron hero-spacer" class="jumbotron hero-spacer">
                <h1>Welcome to JustInTime</h1>
                <p>You can find best and cheapest products here. Hope you have a good tour.</p>
            </header>

            <hr>

            <!-- Title -->
            <div id="row" class="row">
                <div id="col-lg-12" class="col-lg-12">
                    <h3>Product Categories</h3>
                </div>
            </div>
            <!-- /.row -->

            <!-- Page Features -->
            <div id="row text-center" class="row text-center">

                <div id="col-md-3 col-sm-6 hero-feature" class="col-md-3 col-sm-6 hero-feature">
                    <div id="thumbnail" class="thumbnail">
                        <img src="http://placehold.it/800x500" alt="">
                        <div id="caption" class="caption">
                            <h3>Electronics</h3>
                            <p>Labtops, TVs, Desktops, and etc here.</p>
                            <p>
                                <a id="electronics" href="http://localhost:8080/JustInTime/ProductPage.jsp?categ=electronics" class="btn btn-primary">Explore!</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div id="hero-feature" class="col-md-3 col-sm-6 hero-feature">
                    <div id="thumbnail" class="thumbnail">
                        <img src="http://placehold.it/800x500" alt="">
                        <div id="caption" class="caption">
                            <h3>Clothes</h3>
                            <p>Jackets, Coats, T-shirts, and etc here</p>
                            <p>
                                <a id="clothes" href="#" class="btn btn-primary">Explore!</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div id="hero-feature" class="col-md-3 col-sm-6 hero-feature">
                    <div id="thumbnail" class="thumbnail">
                        <img src="http://placehold.it/800x500" alt="">
                        <div id="caption" class="caption">
                            <h3>Books</h3>
                            <p>Textbooks, Novels, Magazines, and etc here</p>
                            <p>
                                <a id="books" href="#" class="btn btn-primary">Explore!</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div id="hero-feature" class="col-md-3 col-sm-6 hero-feature">
                    <div id="thumbnail" class="thumbnail">
                        <img src="http://placehold.it/800x500" alt="">
                        <div id="caption" class="caption">
                            <h3>Furnitures</h3>
                            <p>Tables, Chairs, Bookshelves, and etc here</p>
                            <p>
                                <a id="furniture" href="#" class="btn btn-primary">Explore!</a>
                            </p>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.row -->

            <hr>
        </div>
        <!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
