/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.ArrayList;
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
public class XMLManagerTest {

    public XMLManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class XMLManager.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        ArrayList<String> userArray = new ArrayList<>();
        
        userArray.add("email");
        userArray.add("firstName");
        userArray.add("lastName");
        userArray.add("password");
        userArray.add("birthMonth");
        userArray.add("birthDay");
        userArray.add("birthYear");
        userArray.add("gender");
        userArray.add("phoneNumber");
        userArray.add("pinCode");
        userArray.add("role");

        XMLManager.addUser(userArray);
        //System.out.println("user name: " + XMLManager.getUser("email").get(0));
        assertEquals("email", XMLManager.getUser("email").get(0));
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUser method, of class XMLManager.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        ArrayList<String> expResult = new ArrayList<>();
        
        expResult.add("email");
        expResult.add("firstName");
        expResult.add("lastName");
        expResult.add("password");
        expResult.add("birthMonth");
        expResult.add("birthDay");
        expResult.add("birthYear");
        expResult.add("gender");
        expResult.add("phoneNumber");
        expResult.add("pinCode");
        expResult.add("role");
       
        XMLManager.addUser(expResult);
        ArrayList<String> result = XMLManager.getUser("email");
        System.out.println(expResult.get(0));
        assertEquals(expResult.get(0),result.get(0));
        // TODO review the generated test code and remove the default call to fail.
       
    }

}
