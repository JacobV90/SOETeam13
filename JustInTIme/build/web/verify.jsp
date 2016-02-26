<%-- 
    Document   : verify
    Created on : Feb 24, 2016, 10:42:46 PM
    Author     : jvtal
--%>
<%@page import="source.Users" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Verifying please wait...</h1>
        <%
          
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String repassword = request.getParameter("repassword");
                String birthMonth = request.getParameter("BirthMonth");
                String birthDay = request.getParameter("BirthDay");
                String birthYear = request.getParameter("BirthYear");
                String gender = request.getParameter("gender");
                String phoneNumber = request.getParameter("phone");
                String pinCode = request.getParameter("pin");
                
                Users user = new Users(firstName, lastName, email,password,  
                    birthMonth, birthDay, birthYear, gender, phoneNumber,
                    pinCode);
                
                user.printUserAccountInfo();
                             
            %>
    </body>
</html>
