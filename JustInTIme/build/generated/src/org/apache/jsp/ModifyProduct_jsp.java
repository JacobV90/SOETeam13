package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ModifyProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Modify Product</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Modify Product</h1>\n");
      out.write("        <div  class=\"form\">\n");
      out.write("            <form id=\"modifyProducForm\" action = \"ModifyProduct\" method=\"post\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <p><label for=\"txtproductNumber\">Product #: </label>\n");
      out.write("                    <p><label for=\"txtProductName\">Product Name</label><input id=\"prodName\" type=\"text\" name=\"txtProductName\" size=\"20\" tabindex=\"1\"></p>    \n");
      out.write("                    <p><label for=\"txtproductQuantity\">Product Quantity</label><input id=\"ProductQuantity\" type=\"text\" name=\"txtProductName\" size=\"20\" tabindex=\"2\"></p>\n");
      out.write("                    <p><label for=\"productPrice\">Product Price</label><input id=\"productPrice\" name=\"productPrice\" placeholder=\"\" required=\"required\" tabindex=\"3\" type=\"text\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"productDescription\">Product Description</label><input id=\"productDescription\" name=\"productDescription\" placeholder=\"\" required=\"required\" tabindex=\"4\" type=\"text\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"image\"></label><img src=\"url\" alt=\"Some image\"> </p>\n");
      out.write("                    <p><button id=\"addImage\" type=\"button\">Add Image</button> </p>\n");
      out.write("                    <p><input class=\"button\" id=\"modify\" type=\"submit\" name=\"submit\" value=\"Modify\" >  \n");
      out.write("                    <input class=\"button\" id=\"delete\" type=\"submit\" name=\"submit\" value=\"Delete\" > \n");
      out.write("                    <input class=\"button\" id=\"Cancel\" type=\"submit\" name=\"submit\" value=\"Cancel\" > </p>                    \n");
      out.write("              \n");
      out.write("                </fieldset>  \n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
