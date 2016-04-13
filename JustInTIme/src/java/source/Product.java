package source;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class Product implements Serializable{

    private int itemNo;
    private String itemName;
    private int itemCount;
    private double itemPrice;
    private String itemDescription;
    private double totalPrice = itemPrice * itemCount;
    
    public Product(){
        
    }

    //class constructor
    public Product(String name, int count, double price, String description) {
        this.itemName = name;
        this.itemCount = count;
        this.itemPrice = price;
        this.itemDescription = description;
        DBManager.initializeConnection();
        this.itemNo = DBManager.getRowCount("item") + 1;
        DBManager.closeConnection();
    }

    //setter methods
    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setItemCount(int count) {
        this.itemCount = count;
    }

    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    public void setItemDescription(String description) {
        this.itemDescription = description;
    }

    //getter methods
    public int getItemNo() {
        return itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getTotalPrice() {
        return itemPrice * itemCount;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public ArrayList<String> getProduct() {

        ArrayList<String> array = new ArrayList<>();
        array.add(String.valueOf(itemNo));
        array.add(itemName);
        array.add(String.valueOf(itemPrice));
        array.add(String.valueOf(itemCount));
        array.add(itemDescription);

        return array;

    }
    
    public void createProduct(List<String> values){
        
        this.itemNo = Integer.valueOf(values.get(0));
        this.itemName = values.get(1);
        this.itemPrice = Double.valueOf(values.get(2));
        this.itemCount = Integer.valueOf(values.get(3));
        this.itemDescription = values.get(4);
    }
}
