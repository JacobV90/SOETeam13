<%-- 
    Document   : ProductPage
    Created on : Mar 29, 2016, 2:24:18 PM
    Author     : Owner
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<title>Product Page</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	<link rel="stylesheet" href="css/style2.css"> 
   
</head>
<body>
    <div id ="right" class="bar">
        <p><li><a id="cart" href="">Cart</a></li></p>
        <p><li><a id="logout" href="">Logout</a></li></p>
    </div>
<!-- Topbar ================================================== -->
	<div id="topbar" class="topbar">
		<h1>Manager Product</h1>
	</div>
<!-- Sidebar ================================================== -->
	<div id="sidebar" class="sidebar">
		<p><li><a id="myAccount" href="">My Account</a></li></p>
		<p><li><a id="mySettings" href="">My Settings</a></li></p>
		<p><li><a id="addProduct" href="addproduct.html">Add Product</a></li></p>
		<p><li><a id="editProduct" href="productpage.html">Edit Product</a></li></p>
                

<!-- Products ================================================== -->
<table border="1" style="width:30%" align="center">
    <tr>
    <td>Item #</td>
    <td>00001</td>		
  </tr>
    <tr>
    <td>Name</td>
    <td>MacPro</td>		
  </tr>
  <tr>
    <td>Price</td>
    <td>$600</td>		
  </tr>
  <tr>
    <td>Quantity Available</td>
    <td>10</td>
  </tr>
    <tr>
    <td>Description</td>
    <td>New Model Macbook Pro for Students</td>
  </tr>
</table>

</body>
</html>
