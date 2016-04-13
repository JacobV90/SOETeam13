<%-- 
    Document   : ProductDetail
    Created on : Mar 27, 2016, 6:37:37 PM
    Author     : Owner
--%>

<%@page import="source.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
    </head>
    <body>

        <h1>Product Detail</h1>
        <div  class="form">
            <form id="productDescription" action = "CartServlet" method = "post">
                <fieldset>  
                    <p><label for="txtproductNumber">Product #: </label> <label for="txtproductNumber"><c:out value="${product.itemNo}"/></label></p>
                    <p><label for="txtProductName">Product Name: </label><label for="txtproductNumber"><c:out value="${product.itemName}"/></label></p>
                    <p><label for="txtproductQuantity" id = "productCount">Product Quantity: <label><c:out value="${product.itemCount}"/></label> 
                            <input type='button' name='add' onclick="addQty();" value='+'/>
                            <input type='text' name='qty' id='qty' size = '4' value ="0">
                            <input type='button' name='subtract' onclick="subtractQty();" value='-'/>
                    </p>
                    <p><label for="productPrice">Product Price: </label><label for="txtproductNumber"><c:out value="${product.itemPrice}"/></label></p>
                    <p><label for="productDescription">Product Description: </label><label for="txtproductNumber"><c:out value="${product.itemDescription}"/></label></p>
                    <p><label for="image">Image</label><img src="url" alt="Some txt"> </p>
                    <input type="hidden" name="productNumber" value="${product.itemNo}" />
                    <input type="hidden" name="action" value="addtocart" />
                    
                    <p><input class="button" id="addToCart" type="submit" name="addToCart" value="Add To Cart" onclick='javascript: checkQty();' > 
                       <input class="button" id="Cancel" type="submit" name="Cancel" value="Cancel" ></p>
                    

                </fieldset>  

            </form>
        </div>
        <script type="text/javascript">
            function subtractQty() {
                var value = document.getElementById("qty").value;
                if (value <= 0) {
                    return;
                } else {
                    document.getElementById("qty").value--;
                }
            }
            function addQty() {
                var value = document.getElementById("qty").value;
                var max = <%=request.getParameter("productCount")%>;
                if (value >= max) {
                    return;
                } else {
                    document.getElementById("qty").value++;
                }
            }
        </script>
    </body>
</html>
