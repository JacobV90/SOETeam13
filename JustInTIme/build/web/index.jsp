<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : Feb 23, 2016, 11:20:53 PM
    Author     : jvtal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>   
        <link rel="stylesheet" href="css/index_style.css">
    </head>
    
    <body>
        
        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <h1>Just IN Time!</h1>
                </div>
                <div class ="login-form">
                    <form id ="login" action="LoginServlet" method="post">
                    <div class="control-group">
                        <input type="email" class="login-field" value="" placeholder="email" id="login-name">
                        <label class="login-field-icon fui-user" for="login-name"></label>
                    </div>
                    <div class="control-group">
                        <input type="password" class="login-field" value="" placeholder="password" id="login-pass">
                        <label class="login-field-icon fui-lock" for="login-pass"></label>
                    </div>
                    <a class="btn btn-primary btn-large btn-block" >login</a>
                    <a class="login-link" href="resetpasswd.html">Forget your password?</a>
                    <a class="registration-link" href = "signup.jsp"> Sign up here</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
