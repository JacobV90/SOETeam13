/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacobveal
 */
public class ProductContainer implements Serializable{
    
    private String userEmail;
    private List<Product> productArray;
    private double cartPrice = 0;
    
    public ProductContainer(){productArray = new ArrayList<>();}
    
    public ProductContainer(String email){
        productArray = new ArrayList<>();
        this.userEmail = email;
    }
    
    public void addProduct(Product item){
        cartPrice += item.getTotalPrice();
        productArray.add(item);
    }
    
    public List<Product> getProductArray(){return productArray;}
    
    public double getCartPrice(){return cartPrice;}

    protected void setUserEmail(String email){this.userEmail = email;}
    
    protected String getUserEmail(){return this.userEmail;}
    
    protected String getProductName(int i){return getProduct(i).getItemName();}
    
    protected String getProductDescription(int i){return getProduct(i).getItemDescription();}
    
    protected int getProductCount(int i){return getProduct(i).getItemCount();}
    
    
    protected int getProductNum(int i){return getProduct(i).getItemNo();}
    
    protected Product getProduct(int i){return productArray.get(i);}
    
    protected void removeProduct(int i){productArray.remove(i);}
    
    
        
}
