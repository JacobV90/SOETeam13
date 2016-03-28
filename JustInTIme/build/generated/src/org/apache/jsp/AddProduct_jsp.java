package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Product</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Add Product</h1>\n");
      out.write("        <div  class=\"form\">\n");
      out.write("            <form id=\"addProducForm\" action=\"ModifyProduct\" method=\"post\">\n");
      out.write("                <fieldset>  \n");
      out.write("                    <p><label for=\"ProductNumber\">Product #: </label>\n");
      out.write("                    <p><label for=\"ProductName\">Product Name</label><input id=\"prodName\" type=\"text\" name=\"ProductName\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"txtproductQuantity\">Product Quantity</label><input id=\"ProductQuantity\" type=\"text\" name=\"ProductQuantity\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"ProductPrice\">Product Price</label><input id=\"productPrice\" name=\"ProductPrice\" placeholder=\"\" required=\"required\" tabindex=\"3\" type=\"text\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"productDescription\">Product Description</label><input id=\"productDescription\" name=\"ProductDescription\" placeholder=\"\" required=\"required\" tabindex=\"4\" type=\"text\" size=\"20\"></p>\n");
      out.write("                    <p><label for=\"image\">Image</label><img src=\"url\" alt=\"Some txt\"> </p>\n");
      out.write("                    <p><button id=\"addImage\" type=\"button\">Add Image</button> </p>\n");
      out.write("                    <p><input class=\"button\" id=\"add\" type=\"submit\" name=\"addButton\" value=\"Add Product\" > \n");
      out.write("                        <input class=\"button\" id=\"Cancel\" type=\"submit\" name=\"Cancel\" value=\"Cancel\" ></p>\n");
      out.write("                </fieldset>  \n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
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
