package source;

import java.util.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * The "Product" class is the product model in which it represents a product.
 * This is class is used as a Java Bean to provide information to clients.
 *
 * @author Jacob
 */
public class Product implements Serializable {

    private int itemNo;
    private String itemName;
    private int itemCount;
    private double itemPrice;
    private String itemDescription;
    private double totalPrice = 0;
    private String deliveryDate = null;
    private String size;
    private long deliveryTime = 0;
    private String imageUrl = null;

    /**
     * Default constructor
     */
    public Product() {
       
    }

    /**
     * Creates a product object from 4 passed in parameters.
     *
     * @param name - name of the product
     * @param count - number of products
     * @param price - unit price of product
     * @param description - description of the product
     */
    public Product(String name, int count, double price, String size, String description) {
        
        this.itemName = name;
        this.itemCount = count;
        this.itemPrice = price;
        this.itemDescription = description;
        this.size = size;
        DBManager.initializeConnection();
        this.itemNo = DBManager.getRowCount("item") + 1;
        DBManager.closeConnection();

        switch(size){
            case "small":
                deliveryTime = 3;
                break;
            case "medium":
                deliveryTime = 5;
                break;
            case "large":
                deliveryTime = 7;
                break;
            default:
                deliveryTime = 5;
        }
    }

    /**
     * Sets the item number for this product
     *
     * @param itemNo - the item number
     */
    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * Sets the item name for this type of product
     *
     * @param name - the name of the product
     */
    public void setItemName(String name) {
        this.itemName = name;
    }

    /**
     * Sets the item count for this type of product
     *
     * @param count - number of items
     */
    public void setItemCount(int count) {
        this.itemCount = count;
    }

    /**
     * Sets the unit price for this type of product
     *
     * @param price
     */
    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    /**
     * Sets the item description for this type of product
     *
     * @param description
     */
    public void setItemDescription(String description) {
        this.itemDescription = description;
    }

    /**
     * Gets the item number for this product
     *
     * @return - the item number
     */
    public int getItemNo() {
        return itemNo;
    }

    /**
     * Gets the item name for this type of product
     *
     * @return - the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get the item count for this type of product
     *
     * @return - the item count
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Gets the item unit price for this type of product
     *
     * @return - the product unit price
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * Gets the total price for this type of product
     *
     * @return - total price for products
     */
    public double getTotalPrice() {
        return itemPrice * itemCount;
    }

    /**
     * Gets the products description
     *
     * @return - product description
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Gets the products size
     *
     * @return
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Sets the products size
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setImageUrl(String url){
        this.imageUrl = url;
    }
    
    public String getImageUrl(){
        return this.imageUrl;
    }

    /**
     * Gets the delivery date for this product
     *
     * @return
     */
    public long getDeliveryTime() {
        return this.deliveryTime;
    }

    /**
     * Sets the products size
     *
     * @param size
     */
    public void setDeliveryTime(int date) {
        this.deliveryTime = date;
    }
    
    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets this products values in a list format
     *
     * @return - an ArrayList containing the products information
     */
    public ArrayList<String> getProduct() {

        ArrayList<String> array = new ArrayList<>();
        array.add(String.valueOf(itemNo));
        array.add(itemName);
        array.add(String.valueOf(itemPrice));
        array.add(String.valueOf(itemCount));
        array.add(size);
        array.add(itemDescription);
        array.add(imageUrl);
        array.add(deliveryDate);
        return array;

    }

    /**
     * Creates a product from a passed in list containing product information
     *
     * @param values - list of string values containing product information
     */
    public void createProduct(List<String> values) {
        this.itemNo = Integer.valueOf(values.get(0));
        this.itemName = values.get(1);
        this.itemPrice = Double.valueOf(values.get(2));
        this.itemCount = Integer.valueOf(values.get(3));
        this.size = values.get(4);
        this.itemDescription = values.get(5);
        this.imageUrl = values.get(6);
    }
}
