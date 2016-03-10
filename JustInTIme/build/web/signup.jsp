<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : signup
    Created on : Feb 24, 2016, 12:22:08 PM
    Author     : jacobveal
--%>

<%@page import="source.Users" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE html>
<head>
    <title>Registration Form</title>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/signup_style.css" />
    <link rel="stylesheet" type="text/css" href="css/signup_style1.css" />

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
    <div  class="form">
        <form id="contactform" action = "RegisterServlet" method = "post">

            <p class="contact"><label for="firstname">First Name</label></p> 
            <input id="firstname" name="firstname" placeholder="First name" required="required" tabindex="1" type="text"> 


            <p class="contact"><label for="lastname">Last Name</label></p> 
            <input id="lastName" name="lastName" placeholder="last name" required="required" tabindex="1" type="text"> 

            <p class="contact"><label for="email">Email</label></p> 
            <input id="email" name="email" placeholder="example@domain.com" required="required" tabindex="1" type="email"> 

            <p class="contact"><label for="password">Create a password</label>
            <br>Password needs to be at least 6 to 16 characters with at least 1 lower and upper case, and 1 number
            </p>
            <input type="password" id="password" name="password" required="required" tabindex="1"> 

            <p class="contact"><label for="repassword">Confirm your password</label></p> 
            <input type="password" id="repassword" name="repassword" required="required" tabindex="1" > 

            <fieldset>
                <label>Birthday</label>
                <label class="month"> 
                    <select class="select-style" name="BirthMonth">
                        <option value="">Month</option>
                        <option value="01">January</option>
                        <option value="02">February</option>
                        <option value="03" >March</option>
                        <option value="04">April</option>
                        <option value="05">May</option>
                        <option value="06">June</option>
                        <option value="07">July</option>
                        <option value="08">August</option>
                        <option value="09">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12" >December</option>
                    </select>  
                </label>
                <label>Day<input type="number" min="1" max="31" class="birthday" name="BirthDay" 
                                  required="" tabindex="1"></label>
                <label>Year<input type="number" min="1900" max ="2002" class="birthyear" name="BirthYear" 
                                    required="" tabindex="1"></label>
            </fieldset>

            <select class="select-style gender" name="gender" >
                <option value="select">i am..</option>
                <option value="m">Male</option>
                <option value="f">Female</option>
                <option value="others">Other</option>
            </select><br><br>

            <p class="contact"><label for="phone">Mobile phone </label></p> 
            <input id="phone" name="phone" placeholder="phone number" required="required" 
                   tabindex="1" type="number"> <br>
            <p class="contact"><label for="pin">Pin Code </label></p>
            <input id="pin" name="pin" placeholder="pin code" required="required" 
                   tabindex="1" type="text"> <br>
            <input class="button" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"> 

        </form> 
    </div>       

</body>
</html>
