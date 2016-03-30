<%-- 
    Document   : AddProduct
    Created on : Mar 27, 2016, 4:50:57 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>addproduct</title>


    
        <h1>Add Product</h1>
        <div  class="form">
            <form id="addProducForm" action = "ModifyProduct" method = "post">
                <fieldset>  
                    <p><label for="txtproductNumber">Product #: </label>
                    <p><label for="txtProductName">Product Name</label><input id="prodName" type="text" tabindex="1" name="txtProductName" size="20"  ></p>
                    <p><label for="txtproductQuantity">Product Quantity</label><input id="ProductQuantity" tabindex="2" type="text" name="txtProductName" size="20"  ></p>
                    <p><label for="productPrice">Product Price</label><input id="productPrice" name="productPrice"  tabindex="3" type="text" size="20"></p>
                    <p><label for="productDescription">Product Description</label><input id="productDescription" name="productDescription"  tabindex="4" type="text" size="20"></p>
                    <p><label for="image">Image</label><img src="url" alt="Some txt"> </p>
                    <p><button id="addImage" type="button">Add Image</button> </p>
                    <p><input class="button" id="add" type="submit" name="addButton" value="Add Product" ></p>
                </form>
                  
            <p><input class="btn-default" id="Cancel" type="submit" name="Cancel" value="Cancel" ></p>
            </fieldset>
        </div>
    </body>
</html>
