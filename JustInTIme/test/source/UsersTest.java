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
public class UsersTest {

    Users user;

    public UsersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        user = new Users("firstName", "lastName", "email", "Password1",
                "birthMonth", "17", "1990", "male", "5636769540",
                "a52240");

        user.validate();
        System.out.println("User setup");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of printUserAccountInfo method, of class Users.
     */
    @Test
    public void testPrintUserAccountInfo() {
        System.out.println("printUserAccountInfo");

        Users user = new Users("firstName", "lastName", "email", "Password1",
                "birthMonth", "17", "1990", "male", "5636769540",
                "a52240");

        System.out.println("User setup");
        Users instance = user;
        instance.printUserAccountInfo();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of validate method, of class Users.
     */
    @Test
    public void testValidate() {
        System.out.println("validate:");
        
        user = new Users("firstName", "lastName", "email", "Password1",
                "birthMonth", "17", "1990", "male", "5636769540",
                "a52240");

        Users instance = user;
        boolean result = instance.validate();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getUserDataArray method, of class Users.
     */
    @Test
    public void testGetUserDataArray() {
        System.out.println("getUserDataArray");

        Users instance = user = new Users("firstName", "lastName", "email", "Password1",
                "birthMonth", "17", "1990", "male", "5636769540",
                "a52240");
        
        ArrayList<String> expResult = new ArrayList<>();

        expResult.add("email");
        expResult.add("firstName");
        expResult.add("lastName");
        expResult.add("Password1");
        expResult.add("birthMonth");
        expResult.add("17");
        expResult.add("1990");
        expResult.add("male");
        expResult.add("5636769540");
        expResult.add("a52240");
        expResult.add("Administrator");

        ArrayList<String> result = instance.getUserDataArray();
        //System.out.println(result.get(0));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

   

}
