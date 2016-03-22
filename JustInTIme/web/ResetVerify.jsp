<%-- 
    Document   : ResetVerify
    Created on : Mar 9, 2016, 3:23:17 PM
    Author     : jacobveal
--%>

<%@page import="source.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Reset Password</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" href="css/style1.css">



    </head>
    <body>
        <p class="sentlink">
            A Link was sent to your email address.
            <a href="index.jsp"> Return to Login </a>
        </p>
    </body>
    <%
        String email = request.getParameter("Email");
        System.out.println(email);
        Email.sendPREmail(email);
    %>
</html>