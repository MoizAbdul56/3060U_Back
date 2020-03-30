// Description: This class tests the Item class
// Contains a function that tests if an Item object was converted properly into a String

package tests;

import item.Item;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ItemTest{
    @Test
    public void testToString() throws Exception {
        Item i = new Item("ball", "Alfonso", "Shawn", 1, 13);
        assertEquals(String.format("%1$-19s", "ball") + " " +
                    String.format("%1$-15s", "Alfonso") + " " +
                    String.format("%1$-15s", "Shawn") + " " +
                    String.format("%1$-3s", "001") + " " +
                    String.format("%1$-6s", "013.00"), i.toString());
    }
}