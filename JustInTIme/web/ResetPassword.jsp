<%-- 
    Document   : ResetPassword
    Created on : Mar 21, 2016, 6:01:58 PM
    Author     : jacobveal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html >
    <head>

        <meta charset="UTF-8">
        <title>Login Form</title>
        <link rel="stylesheet" href="css/style1.css">

        <script type="text/javascript">
        window.onload = function () {
            document.getElementById("password").onchange = validatePassword;
            document.getElementById("repassword").onchange = validatePassword;
        };
        function validatePassword() {
            var pass2 = document.getElementById("password").value;
            var pass1 = document.getElementById("repassword").value;
            if (pass1 !== pass2)
                document.getElementById("repassword").setCustomValidity("Passwords Don't Match");
            else
                document.getElementById("repassword").setCustomValidity('');
        //empty string means no validation error
        }
    </script>

    </head>

    <body>
        <div class="login">

            <div class="login-screen">

                <div class="app-title">
                    <h1>Reset Password</h1>
                </div>
                <div class="login-form">

                    <div class="control-group">

                        <form action = "ResetPassword" method="POST">
                            
                            <label class="login-field-icon fui-user" for="login-name">Enter your email address</label>

                            <input type="email" class="login-field" value= "" placeholder="email" id="password" name="email"/>

                            <label class="login-field-icon fui-user" for="login-name">Enter your password</label>

                            <input type="password" class="login-field" value="" placeholder="password" id="password" name="password">

                            <label class="login-field-icon fui-user" for="login-name">Confirm your password</label>

                            <input type="password" class="login-field" value="" placeholder="password" id="password" name="repassword">

                            </div>


                            <input class="btn btn-primary btn-large btn-block" type="submit" name="submit" id="submit">

                            <a class="login-link" href="login.html">Return to Login</a>

                    </div>


                </div>

            </div>


    </body>

</html>
