package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import source.Product;
import java.util.List;

public final class MyOrders_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Purchase Orders</title>\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7; IE=EmulateIE9\">\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\"/>\n");
      out.write("\t    <!-- Bootstrap Core CSS -->\n");
      out.write("\t    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\t    <!-- Custom CSS -->\n");
      out.write("\t    <link href=\"css/heroic-features.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("    <nav id=\"navbarnavbar-inversenavbar-fixed-top\" class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div id=\"container\" class=\"container\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div id=\"navbar-header\" class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span id=\"sr-only\" class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                    <span id=\"icon-bar\" class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\">Just In Time Inventories</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul id=\"navnavbar-nav\" class=\"nav navbar-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"myaccount\" href=\"Account.html\">My account</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"mysettings\" href=\"Admin.html\">My Settings</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"myorder\" href=\"Order.html\">My order</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <ul id=\"navnavbar-navnavbar-right\" class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"cart\" href=\"CartBufferServlet\">Cart</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a id=\"logout\" href=\"LogoutServlet\">Logout</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Order ================================================== -->\n");
      out.write("\n");
      out.write("<table border=\"1\" style=\"width:35%\" align = \"center\">\n");
      out.write("    <div>\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"details\" />\n");
      out.write("\n");
      out.write("    </div\n");
      out.write("    <tr>\n");
      out.write("        <th align = \"center\">Product Name</th>\n");
      out.write("        <th align = \"center\">Order Number</th>\n");
      out.write("        <th align = \"center\">Order Amount</th>\n");
      out.write("        <th align = \"center\">Order date</th>\n");
      out.write("        <th align = \"center\">Order Description</th>\n");
      out.write("\t<th align = \"center\">Order State</th>\n");
      out.write("\t<th align = \"center\">Cancel order</th>\n");
      out.write("    </tr>\n");
      out.write("    <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${productList.productArray}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"product\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <td align = \"center\"></td>\n");
      out.write("        <td align = \"center\"></td>\n");
      out.write("        <td align = \"center\"></td>\n");
      out.write("        <td align = \"center\"></td>\n");
      out.write("        <td align = \"center\"></td>\n");
      out.write("\t<th align = \"center\"></th>\n");
      out.write("\t<td align = \"center\"><a href=\"\">Cancel order</td>\n");
      out.write("        </tr>\n");
      out.write("    </c:forEach>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
