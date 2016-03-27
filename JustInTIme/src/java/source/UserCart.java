package source;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Owner
 */
public class UserCart extends ProductContainer {
    
    private double sum;
    private final String userEmail = null;
    private ArrayList<Product> productArr; 
    
    public UserCart(String email){
        super(email);
    }
    
    //sum cost of each item from array list
    public Double getTotalPrice(){
        for (int i = 0 ; i<= productArr.size() ; i++)
        sum += getPrice(i);
        return sum;
    }
    
}
