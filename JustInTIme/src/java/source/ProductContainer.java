/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;

/**
 *
 * @author jacobveal
 */
public abstract class ProductContainer {
    
    private final String userEmail;
    private ArrayList<Product> productArray = null;
    
    public ProductContainer(String email){
        this.userEmail = email;
    }
    
    public void addProduct(Product item){productArray.add(item);}
    
    protected String getUserEmail(){return this.userEmail;}
    
    protected String getProductName(int i){return getProduct(i).getItemName();}
    
    protected String getProductDescription(int i){return getProduct(i).getItemDescription();}
    
    protected int getProductCount(int i){return getProduct(i).getItemCount();}
    
    protected double getPrice(int i){return getProduct(i).getTotalPrice();}
    
    protected int getProductNum(int i){return getProduct(i).getItemNo();}
    
    protected Product getProduct(int i){return productArray.get(i);}
    
    protected void removeProduct(int i){productArray.remove(i);}
    
    protected ArrayList<Product> getProducts(){return productArray;}
    
    
    
}
