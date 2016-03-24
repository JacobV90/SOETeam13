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
public class DBManagerTest {

    Users user;

    public DBManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        if (DBManager.initializeConnection()) {
            user = new Users("firstName", "lastName", "email", "Password1",
                    "birthMonth", "17", "1990", "m", "5636769490",
                    "a52240");
            //user.validate();
            System.out.println("User constructed");
        } else {
            System.out.println("Database failed");
        }
    }

    @After
    public void tearDown() {
        DBManager.closeConnection();

    }

    /**
     * Test of insertEntry method, of class DBManager.
     */
    @Test
    public void testInsertEntry() {
        System.out.println("insertEntry");
        String table = "user";
        ArrayList<String> entryData = user.getUserDataArray();
        boolean expResult = true;
        boolean result = DBManager.insertEntry(table, entryData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of selectEntry method, of class DBManager.
     */
    @Test
    public void testSelectEntry() {
        System.out.println("selectEntry");
        String table = "user";
        String key = "email";
        String fieldName = "Email";
        ArrayList<String> expResult = user.getUserDataArray();
        ArrayList<String> result = DBManager.selectEntry(table, fieldName, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of updateEntry method, of class DBManager.
     */
    @Test
    public void testUpdateEntry() {
        System.out.println("updateEntry");
        String table = "user";
        String keyCol = "Email";
        String key = "email";
        String colName = "FirstName";
        String value = "Jacob";
        boolean expResult = true;
        boolean result = DBManager.updateEntry(table, keyCol, key, colName, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
