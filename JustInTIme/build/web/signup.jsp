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
<html xmlns:h="http://java.sun.com/jsf/html"
   xmlns:f="http://java.sun.com/jsf/core">
<head>
<title>Registration Form</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
        <link rel="stylesheet" type="text/css" href="css/signup_style.css" />
        <link rel="stylesheet" type="text/css" href="css/signup_style1.css" />
   
</head>
<body>
      <div  class="form">
    		<form id="contactform" action = "verify.jsp">
                    
    			<p class="contact"><label for="firstname">First Name</label></p> 
    			<input id="firstname" name="firstname" placeholder="First name" required="required" tabindex="1" type="text"> 
                         
                         
    			<p class="contact"><label for="lastname">Last Name</label></p> 
    			<input id="lastName" name="lastName" placeholder="last name" required="required" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="email">Email</label></p> 
    			<input id="email" name="email" placeholder="example@domain.com" required="required" tabindex="1"type="email"> 
                        
                        <p class="contact"><label for="password">Create a password</label></p> 
    			<input type="password" id="password" name="password" required="" tabindex="1"> 
                        
                        <p class="contact"><label for="repassword">Confirm your password</label></p> 
    			<input type="password" id="repassword" name="repassword" required="" tabindex="1" > 
        
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
                  </label>
                 </select>    
                <label>Day<input class="birthday" maxlength="2" name="BirthDay" 
                                 placeholder="Day" required="" tabindex="1"></label>
                <label>Year <input class="birthyear" maxlength="4" name="BirthYear" 
                                   placeholder="Year" required="" tabindex="1"></label>
              </fieldset>
  
            <select class="select-style gender" name="gender" >
            <option value="select">i am..</option>
            <option value="m">Male</option>
            <option value="f">Female</option>
            <option value="others">Other</option>
            </select><br><br>
            
            <p class="contact"><label for="phone">Mobile phone</label></p> 
            <input id="phone" name="phone" placeholder="phone number" required="required" 
                   tabindex="1" type="text"> <br>
            <p class="pin"><label for="pin">Pin Code</label></p> 
            <input id="pin" name="pin" placeholder="pin code" required="" 
                   tabindex="1"type="text"> <br>
            <input class="button" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"> 
            
   </form> 
  </div>       

</body>
</html>
