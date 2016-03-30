<%-- 
    Document   : ProductDetail
    Created on : Mar 27, 2016, 6:37:37 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
    </head>
    <body>
        
        <script type="text/javascript">
		function subtractQty(){
			if(document.getElementById("qty").value - 1 < 0)
				return;
			else
				 document.getElementById("qty").value--;
		}
		</script>
                
        <h1>Product Detail</h1>
        <div  class="form">
            <form id="productDescription">
                <fieldset>  
                    <p><label for="txtproductNumber">Product #: </label> <label for="txtproductNumber">Display Prod Number </label></p>
                    <p><label for="txtProductName">Product Name: </label><label for="txtproductNumber">Display Prod Name </label></p>
                    <p><label for="txtproductQuantity">Product Quantity:</label> 
                        <input type='button' name='add' onclick='javascript: document.getElementById("qty").value++;' value='+'/>
                        <input type='text' name='qty' id='qty' size="1"/>
			<input type='button' name='subtract' onclick='javascript: subtractQty();' value='-'/>
                    </p>
                    <p><label for="productPrice">Product Price: </label><label for="txtproductNumber">Display Prod Price </label></p>
                    <p><label for="productDescription">Product Description: </label><label for="txtproductNumber">Display Prod Description </label></p>
                    <p><label for="image">Image</label><img src="url" alt="Some txt"> </p>
                    <p><input class="button" id="addToCart" type="submit" name="addToCart" value="Add To Cart" > 
                    <input class="button" id="Cancel" type="submit" name="Cancel" value="Cancel" ></p>
                </fieldset>  
                        
			
            </form>

            
        </div>
    </body>
</html>
