package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>HomePage</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom CSS -->\n");
      out.write("    <link href=\"css/heroic-features.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav id=\"navbar navbar-inverse navbar-fixed-top\" class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div id=\"container\" class=\"container\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div id=\"navbar-header\" class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span id=\"sr-only\" class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\">Welcome User</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul id=\"nav navbar-nav\" class=\"nav navbar-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"myaccount\" href=\"#\">My account</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"mysettings\" href=\"#\">My Settings</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"myorder\" href=\"#\">My order</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <ul id=\"nav navbar-nav navbar-right\" class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                    <li>\n");
      out.write("\t\t\t\t                    \t<a id=\"cart\" href=\"#\">Cart</a>\n");
      out.write("\t\t\t\t                    </li>\n");
      out.write("\t\t\t\t                    <li>\n");
      out.write("\t\t\t\t                    \t<a id=\"logout\" href=\"#\">Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Page Content -->\n");
      out.write("    <div id=\"search\" class=\"search\">\n");
      out.write("    <input type=\"text\">\n");
      out.write("    <a><a href=\"#\" class=\"btn btn-primary\">Find it</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <!-- Jumbotron Header -->\n");
      out.write("        <header id=\"jumbotron hero-spacer\" class=\"jumbotron hero-spacer\">\n");
      out.write("            <h1>Welcome to JustInTime</h1>\n");
      out.write("            <p>You can find best and cheapest products here. Hope you have a good tour.</p>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("        <!-- Title -->\n");
      out.write("        <div id=\"row\" class=\"row\">\n");
      out.write("            <div id=\"col-lg-12\" class=\"col-lg-12\">\n");
      out.write("                <h3>Product Categories</h3>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("        <!-- Page Features -->\n");
      out.write("        <div id=\"row text-center\" class=\"row text-center\">\n");
      out.write("\n");
      out.write("            <div id=\"col-md-3 col-sm-6 hero-feature\" class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div id=\"thumbnail\" class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://placehold.it/800x500\" alt=\"\">\n");
      out.write("                    <div id=\"caption\" class=\"caption\">\n");
      out.write("                        <h3>Electronics</h3>\n");
      out.write("                        <p>Labtops, TVs, Desktops, and etc here.</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a id=\"electronics\" href=\"#\" class=\"btn btn-primary\">Explore!</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"col-md-3 col-sm-6 hero-feature\" class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div id=\"thumbnail\" class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://placehold.it/800x500\" alt=\"\">\n");
      out.write("                    <div id=\"caption\" class=\"caption\">\n");
      out.write("                        <h3>Clothes</h3>\n");
      out.write("                        <p>Jackets, Coats, T-shirts, and etc here</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a id=\"clothes\" href=\"#\" class=\"btn btn-primary\">Explore!</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"col-md-3 col-sm-6 hero-feature\" class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div id=\"thumbnail\" class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://placehold.it/800x500\" alt=\"\">\n");
      out.write("                    <div id=\"caption\" class=\"caption\">\n");
      out.write("                        <h3>Books</h3>\n");
      out.write("                        <p>Textbooks, Novels, Magazines, and etc here</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a id=\"books\" href=\"#\" class=\"btn btn-primary\">Explore!</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"col-md-3 col-sm-6 hero-feature\" class=\"col-md-3 col-sm-6 hero-feature\">\n");
      out.write("                <div id=\"thumbnail\" class=\"thumbnail\">\n");
      out.write("                    <img src=\"http://placehold.it/800x500\" alt=\"\">\n");
      out.write("                    <div id=\"caption\" class=\"caption\">\n");
      out.write("                        <h3>Furnitures</h3>\n");
      out.write("                        <p>Tables, Chairs, Bookshelves, and etc here</p>\n");
      out.write("                        <p>\n");
      out.write("                            <a id=\"furniture\" href=\"#\" class=\"btn btn-primary\">Explore!</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
