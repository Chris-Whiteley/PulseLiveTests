/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulselivetests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class RectangleTest {

    public RectangleTest() {
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
     * Test of intersects method, of class Rectangle.
     */
    @Test
    public void testIntersects() {
        System.out.println("intersects");
        Rectangle r = new Rectangle(3.0, 1.0, 1.0, 3.0);
        Rectangle instance = new Rectangle(2.0, 2.0, 0.0, 4.0);
        boolean expResult = true;
        boolean result = instance.intersects(r);
        assertEquals(expResult, result);

        instance = new Rectangle(4.0, 3.0, 2.0, 5.0);
        expResult = false;
        result = instance.intersects(r);
        assertEquals(expResult, result);
    }

}
