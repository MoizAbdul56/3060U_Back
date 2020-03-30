// Description: This tests the ProcessItem class
// Contains functions that tests creating an items object through bid and advertise functions


package tests;

import java.util.*;
import process.ProcessItem;
import item.Item;
import javafx.util.Pair;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ProcessItemTest{
    @Test
    public void testAdvertise() throws Exception {
        Map<Pair<String, String>, Item> items = new HashMap<>();
        ProcessItem pi = new ProcessItem(items);


        Pair<String, String> p = new Pair<>("flower             ", "Elijah");
        Item i = new Item("flower", "Elijah", "", 2, 50);
        Map<Pair<String, String>, Item> itemsMatch = new HashMap<>();
        itemsMatch.put(p, i);
        String transaction = "03 flower              Elijah          002 050.00"; 
        
        assertEquals(itemsMatch, pi.advertise(transaction));
    }

    @Test
    public void testBid() throws Exception {
        Map<Pair<String, String>, Item> items = new HashMap<>();
        ProcessItem pi = new ProcessItem(items);


        Pair<String, String> p = new Pair<>("flower             ", "Elijah");
        Item i = new Item("flower", "Elijah", "Shawn", 2, 50);
        Map<Pair<String, String>, Item> itemsMatch = new HashMap<>();
        itemsMatch.put(p, i);
        String transaction = "03 flower              Elijah          buyer          002 050.00"; 
        
        assertEquals(itemsMatch, pi.bid(transaction));
    }
}