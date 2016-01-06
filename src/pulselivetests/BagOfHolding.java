/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulselivetests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Chris
 */
public class BagOfHolding {

    static final Comparator<Item> UNIT_VALUE_DESCENDING_ORDER
            = new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return i2.unitValue().compareTo(i1.unitValue());
                }
            };

    public static List<Item> packBag(List<Item> items, int capacity) {
        List<Item> packedItems = new ArrayList<Item>();
        
        if (items == null || items.size() == 0 || capacity <= 0) {
            return packedItems;
        }
              
        // sort the items so that they are ordered by descending unit value
        List<Item> sortedItems = new ArrayList<Item>(items);
        Collections.sort(sortedItems, UNIT_VALUE_DESCENDING_ORDER);

        
        int remainingCapacity = capacity;

        for (Item i : sortedItems) {
            if (i.getSize() <= remainingCapacity) {
                packedItems.add(i);
                remainingCapacity = remainingCapacity - i.getSize();
                if (remainingCapacity == 0) {
                    break;
                }
            }
        }

        return packedItems;

    }

    public static class Item {

        // The value of the item
        private int value;

        // The size of the item, consumes capacity in the bag
        private int size;

        public Item(int value, int size) {
            if (value < 0 || size < 0) {
                throw new IllegalArgumentException();
            }
            this.value = value;
            this.size = size;
        }

        /**
         * Method added to get the unit value for sorting in descending unit value order.
         * @return 
         */
        private Double unitValue() {
            return ((double) getValue()) / getSize();
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        /**
         * @return the size
         */
        public int getSize() {
            return size;
        }

    }

}
