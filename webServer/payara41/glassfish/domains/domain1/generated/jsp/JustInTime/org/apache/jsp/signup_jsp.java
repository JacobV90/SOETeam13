package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import source.Users;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Registration Form</title>\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7; IE=EmulateIE9\">\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/signup_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/signup_style1.css\" />\n");
      out.write("   \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("      <div  class=\"form\">\n");
      out.write("    \t\t<form id=\"contactform\"> \n");
      out.write("    \t\t\t<p class=\"contact\"><label for=\"firstname\">First Name</label></p> \n");
      out.write("    \t\t\t<input id=\"firstname\" name=\"firstname\" placeholder=\"First name\" required=\"required\" tabindex=\"1\" type=\"text\"> \n");
      out.write("\n");
      out.write("    \t\t\t<p class=\"contact\"><label for=\"lastname\">Last Name</label></p> \n");
      out.write("    \t\t\t<input id=\"firstname\" name=\"firstname\" placeholder=\"last name\" required=\"required\" tabindex=\"1\" type=\"text\"> \n");
      out.write("    \t\t\t \n");
      out.write("    \t\t\t<p class=\"contact\"><label for=\"email\">Email</label></p> \n");
      out.write("    \t\t\t<input id=\"email\" name=\"email\" placeholder=\"example@domain.com\" required=\"required\" type=\"email\"> \n");
      out.write("                        \n");
      out.write("                        <p class=\"contact\"><label for=\"password\">Create a password</label></p> \n");
      out.write("    \t\t\t<input type=\"password\" id=\"password\" name=\"password\" required=\"\"> \n");
      out.write("                        \n");
      out.write("                        <p class=\"contact\"><label for=\"repassword\">Confirm your password</label></p> \n");
      out.write("    \t\t\t<input type=\"password\" id=\"repassword\" name=\"repassword\" required=\"\"> \n");
      out.write("        \n");
      out.write("               <fieldset>\n");
      out.write("                 <label>Birthday</label>\n");
      out.write("                  <label class=\"month\"> \n");
      out.write("                  <select class=\"select-style\" name=\"BirthMonth\">\n");
      out.write("                  <option value=\"\">Month</option>\n");
      out.write("                  <option  value=\"01\">January</option>\n");
      out.write("                  <option value=\"02\">February</option>\n");
      out.write("                  <option value=\"03\" >March</option>\n");
      out.write("                  <option value=\"04\">April</option>\n");
      out.write("                  <option value=\"05\">May</option>\n");
      out.write("                  <option value=\"06\">June</option>\n");
      out.write("                  <option value=\"07\">July</option>\n");
      out.write("                  <option value=\"08\">August</option>\n");
      out.write("                  <option value=\"09\">September</option>\n");
      out.write("                  <option value=\"10\">October</option>\n");
      out.write("                  <option value=\"11\">November</option>\n");
      out.write("                  <option value=\"12\" >December</option>\n");
      out.write("                  </label>\n");
      out.write("                 </select>    \n");
      out.write("                <label>Day<input class=\"birthday\" maxlength=\"2\" name=\"BirthDay\"  placeholder=\"Day\" required=\"\"></label>\n");
      out.write("                <label>Year <input class=\"birthyear\" maxlength=\"4\" name=\"BirthYear\" placeholder=\"Year\" required=\"\"></label>\n");
      out.write("              </fieldset>\n");
      out.write("  \n");
      out.write("            <select class=\"select-style gender\" name=\"gender\">\n");
      out.write("            <option value=\"select\">i am..</option>\n");
      out.write("            <option value=\"m\">Male</option>\n");
      out.write("            <option value=\"f\">Female</option>\n");
      out.write("            <option value=\"others\">Other</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            \n");
      out.write("            <p class=\"contact\"><label for=\"phone\">Mobile phone</label></p> \n");
      out.write("            <input id=\"phone\" name=\"phone\" placeholder=\"phone number\" required=\"required\" type=\"text\"> <br>\n");
      out.write("            <p class=\"pin\"><label for=\"pin\">Pin Code</label></p> \n");
      out.write("            <input id=\"pin\" name=\"pin\" placeholder=\"pin code\" required=\"\" type=\"text\"> <br>\n");
      out.write("            <input class=\"button\" name=\"submit\" id=\"submit\" tabindex=\"5\" value=\"Sign me up!\" type=\"submit\"> \n");
      out.write("            \n");
      out.write("   </form> \n");
      out.write("  </div>       \n");
      out.write("\n");
      out.write("</body>\n");
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
