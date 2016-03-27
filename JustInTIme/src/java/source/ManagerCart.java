/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *The manager cart holds products and provides product information
 * 
 * @author jacobveal
 */
public class ManagerCart extends ProductContainer{
    
    public ManagerCart(String email) {
        super(email);
    }
    
    /**
     * The setItemDescription sets the products description at the specified array
     * location
     * 
     * @param descr - description
     * @param index - product location in array
     */
    public void setItemDescription(String descr, int index){
        getProduct(index).setItemDescription(descr);
    }
    
    /**
     * The setItemName method sets the products name at the specified array location
     * 
     * @param name - name of the product
     * @param index - product location in array
     */
    public void setItemName(String name, int index){
        getProduct(index).setItemName(name);
    }
    
    /**
     * The setItemPrice method sets the products price at the specified array location
     * 
     * @param name - unit price of the product
     * @param index - product location in array
     */
    public void setItemPrice(Double price, int index){
        getProduct(index).setItemPrice(price);
    }
    
    /**
     * The setItemCount method sets the products quantity at the specified array location
     * 
     * @param name - amount of the product
     * @param index - product location in array
     */
    public void setItemCount(int count, int index){
        getProduct(index).setItemCount(count);
    }
    
}
