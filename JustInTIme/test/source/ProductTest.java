/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacobveal
 */
public class ProductTest {
    
    Product product;
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        product = new Product("Computer",1,15,"Mac");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setItemNo method, of class Product.
     */
    @Test
    public void testSetItemNo() {
        System.out.println("setItemNo");
        int itemNo = 0;
        Product instance = null;
        instance.setItemNo(itemNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemName method, of class Product.
     */
    @Test
    public void testSetItemName() {
        System.out.println("setItemName");
        String name = "";
        Product instance = null;
        instance.setItemName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemCount method, of class Product.
     */
    @Test
    public void testSetItemCount() {
        System.out.println("setItemCount");
        int count = 0;
        Product instance = null;
        instance.setItemCount(count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemPrice method, of class Product.
     */
    @Test
    public void testSetItemPrice() {
        System.out.println("setItemPrice");
        double price = 0.0;
        Product instance = null;
        instance.setItemPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemDescription method, of class Product.
     */
    @Test
    public void testSetItemDescription() {
        System.out.println("setItemDescription");
        String description = "";
        Product instance = null;
        instance.setItemDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemNo method, of class Product.
     */
    @Test
    public void testGetItemNo() {
        System.out.println("getItemNo");
        Product instance = product;
        int expResult = 0;
        int result = instance.getItemNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getItemName method, of class Product.
     */
    @Test
    public void testGetItemName() {
        System.out.println("getItemName");
        Product instance = null;
        String expResult = "";
        String result = instance.getItemName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemCount method, of class Product.
     */
    @Test
    public void testGetItemCount() {
        System.out.println("getItemCount");
        Product instance = null;
        int expResult = 0;
        int result = instance.getItemCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemPrice method, of class Product.
     */
    @Test
    public void testGetItemPrice() {
        System.out.println("getItemPrice");
        Product instance = null;
        double expResult = 0.0;
        double result = instance.getItemPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class Product.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Product instance = null;
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemDescription method, of class Product.
     */
    @Test
    public void testGetItemDescription() {
        System.out.println("getItemDescription");
        Product instance = null;
        String expResult = "";
        String result = instance.getItemDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
