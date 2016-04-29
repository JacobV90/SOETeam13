<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : Feb 23, 2016, 11:20:53 PM
    Author     : chicheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Form</title>   
        <link rel="stylesheet" href="css/index_style.css">
    </head>

    <body>

        <div class="login">
            <div class="login-screen">
                <div class="app-title">
                    <h1>Payment</h1>
                </div>
                <div class ="login-form">
                    <h4>Total price: $${price}</h4>
                    <form id ="login" action="POServlet" method="get">
                        <div class="control-group">
                            <input type="text" class="login-field" value="" placeholder="email" id="login-name" name = "pay">
                            <label class="login-field-icon fui-user" for="login-name"></label>
                        </div>
                            <input class="btn" name="submit" id="submit" tabindex="5" value="Confirm" type="submit"> 
                        <a class="login-link" href="CartBufferServlet">Cancel</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
