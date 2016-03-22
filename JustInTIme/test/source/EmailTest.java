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
public class EmailTest {
    
    public EmailTest() {
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
     * Test of sendRegEmail method, of class Email.
     */
    @Test
    public void testSendRegEmail() throws Exception {
        System.out.println("sendRegEmail");
        String email = "jvtalon90@yahoo.com";
        Email.sendRegEmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sendPREmail method, of class Email.
     */
    @Test
    public void testSendPREmail() throws Exception {
        System.out.println("sendPREmail");
        String email = "jvtalon90@yahoo.com";
        Email.sendPREmail(email);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
