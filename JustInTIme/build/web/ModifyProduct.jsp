<%-- 
    Document   : ModifyProduct
    Created on : Mar 27, 2016, 4:50:57 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Product</title>
    </head>
    <body>
        <h1>Modify Product</h1>
        <div  class="form">
            <form id="modifyProducForm">
                <fieldset>
                    <p><label for="txtproductNumber">Product #: </label>
                    <p><label for="txtProductName">Product Name</label><input id="prodName" type="text" name="txtProductName" size="20" tabindex="1"></p>    
                    <p><label for="txtproductQuantity">Product Quantity</label><input id="ProductQuantity" type="text" name="txtProductName" size="20" tabindex="2"></p>
                    <p><label for="productPrice">Product Price</label><input id="productPrice" name="productPrice" placeholder="" required="required" tabindex="3" type="text" size="20"></p>
                    <p><label for="productDescription">Product Description</label><input id="productDescription" name="productDescription" placeholder="" required="required" tabindex="4" type="text" size="20"></p>
                    <p><label for="image"></label><img src="url" alt="Some image"> </p>
                    <p><button id="addImage" type="button">Add Image</button> </p>
                    <p><input class="button" id="modify" type="submit" name="modifyButton" value="Modify" >  
                    <input class="button" id="delete" type="submit" name="deleteButton" value="Delete" > 
                    <input class="button" id="Cancel" type="submit" name="Cancel" value="Cancel" > </p>                    
              
                </fieldset>  

            </form>
            
            
        </div>
    </body>
</html>
