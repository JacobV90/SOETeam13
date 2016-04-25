/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.Serializable;

/**
 *
 * @author jacobveal
 */
public class PurchaseOrder  implements Serializable{
    
    
    private ProductContainer purchasedItems;
    private String purchaseNumber;
    
    public PurchaseOrder (){};
    
    public void setPurchasedItems(ProductContainer items){
        this.purchasedItems = items;
    }
    
    public String getPurchaseNumber(){
        return this.purchaseNumber;
    }
    
    public ProductContainer getPurchasedItems(){
        return this.purchasedItems;
    }
   
    public void setPurchaseNumber(String num){
        this.purchaseNumber = num;
    }
    
    
}
