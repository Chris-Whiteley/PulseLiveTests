/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulselivetests;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pulselivetests.BagOfHolding.Item;

/**
 *
 * @author Chris
 */
public class BagOfHoldingTest {

    public BagOfHoldingTest() {
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

    @Test
    public void testPackBag() {
        // TODO review the generated test code and remove the default call to fail.
        List<Item> items = new ArrayList<Item>();

        items.add(new Item(20, 10));
        items.add(new Item(18, 8));
        items.add(new Item(15, 5));
        items.add(new Item(10, 6));
        items.add(new Item(10, 6));
        items.add(new Item(5, 4));
        items.add(new Item(5, 1));
        items.add(new Item(5, 1));
        items.add(new Item(5, 2));
        items.add(new Item(5, 1));

        List<Item> packedItems = BagOfHolding.packBag(items, 40);

        System.out.println("packBag");

        int expectedSize = 9;
        assertEquals(expectedSize, packedItems.size());

        int totalValue = 0;
        int totalSize = 0;

        for (Item i : packedItems) {
            totalValue = totalValue + i.getValue();
            totalSize = totalSize + i.getSize();
        }

        int expectedTotalValue = 93;
        int expectedTotalSize = 40;

        assertEquals(expectedTotalValue, totalValue);
        assertEquals(expectedTotalSize, totalSize);
    }

}
