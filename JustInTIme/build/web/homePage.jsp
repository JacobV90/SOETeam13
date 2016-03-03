<%-- 
    Document   : homePage
    Created on : Mar 2, 2016, 5:00:26 PM
    Author     : jacobveal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home page</title>
    </head>
    <body>
        
        <%
               String name =request.getParameter("name");
               String role =request.getParameter("role");
            
            %>
        <h1>Hello ${name} , ${role}
            
            
        </h1>
    </body>
</html>
