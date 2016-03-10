<%-- 
    Document   : ForgotPassword
    Created on : Mar 2, 2016, 3:40:43 PM
    Author     : jacobveal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>

        <meta charset="UTF-8">
        <title>Login Form</title>
        <link rel="stylesheet" href="css/index_style.css">

    </head>

    <body>

        <div class="login">

            <div class="login-screen">

                <div class="app-title">

                    <h1>Login</h1>
                </div>


                <div class="login-form">

                    <div class="control-group">

                        <label class="login-field-icon fui-user" for="login-name">Enter your email address</label>

                        <input type="email" class="login-field" value="" placeholder="email" id="login-name">

                    </div>


                    <a class="btn btn-primary btn-large btn-block" href="ResetVerify.jsp">Submit</a>

                    <a class="login-link" href="ResetVerify.jsp">Return to Login</a>

                </div>


            </div>

        </div>


    </body>


