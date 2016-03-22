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
public class PasswordControlTest {
    
    public PasswordControlTest() {
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
     * Test of validatePass method, of class PasswordControl.
     * 
     *  -Password must be between 6 and 16 characters with at least 1 upper case
     *      and 1 numerical value
     */
    @Test
    public void testValidatePass() {
        System.out.println("validatePass");
        String pw = "Password1";
        boolean expResult = true;
        boolean result = PasswordControl.validatePass(pw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
