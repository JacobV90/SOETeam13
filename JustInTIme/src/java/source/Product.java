package source;
/**
 *
 * @author Owner
 */
public class Product {
    
    private static int productCount = 0;
    private int itemNo;
    private String itemName;
    private int itemCount;
    private double itemPrice;
    private String itemDescription;
    
    //class constructor
    public Product(String name, int count, double price, String description)
    {
        this.itemName = name;
        this.itemCount = count;
        this.itemPrice = price;
        this.itemDescription = description;
        this.itemNo = productCount;
        ++this.productCount;
    }
    
    //setter methods
    public void setItemNo (int itemNo){ this.itemNo = itemNo; }
    public void setItemName (String name){ this.itemName = name; }
    public void setItemCount (int count) { this.itemCount = count; } 
    public void setItemPrice (double price) { this.itemPrice = price; } 
    public void setItemDescription (String description) { this.itemDescription = description; } 
    
    
    //getter methods
    public int getItemNo (){ return itemNo; }
    public String getItemName (){ return itemName; } 
    public int getItemCount () { return itemCount; } 
    public double getItemPrice () { return itemPrice ; } 
    public double getTotalPrice (){ return itemPrice * itemCount;}
    public String getItemDescription () { return itemDescription; }     
}




