<%-- 
    Document   : AddProduct
    Created on : Mar 27, 2016, 4:50:57 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product</h1>
        <div  class="form">
            <form id="addProducForm" action="ModifyProduct" method="post">
                <fieldset>  
                    <p><label for="ProductNumber">Product #: </label>
                    <p><label for="ProductName">Product Name</label><input id="prodName" type="text" name="ProductName" size="20"></p>
                    <p><label for="txtproductQuantity">Product Quantity</label><input id="ProductQuantity" type="text" name="ProductQuantity" size="20"></p>
                    <p><label for="ProductPrice">Product Price</label><input id="productPrice" name="ProductPrice" placeholder="" required="required" tabindex="3" type="text" size="20"></p>
                    <p><label for="productDescription">Product Description</label><input id="productDescription" name="ProductDescription" placeholder="" required="required" tabindex="4" type="text" size="20"></p>
                    <p><label for="image">Image</label><img src="url" alt="Some txt"> </p>
                    <p><button id="addImage" type="button">Add Image</button> </p>
                    <p><input class="button" id="add" type="submit" name="submit" value="Add" > 
                        <input class="button" id="Cancel" type="submit" name="submit" value="Cancel" ></p>
                </fieldset>  

            </form>


        </div>
    </body>
</html>
