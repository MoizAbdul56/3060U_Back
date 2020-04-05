// Description: This tests the Writer class
// Contains functions that tests writing the users and items to a file

package tests;

import util.Writer;
import java.util.*;
import javafx.util.Pair;
import user.User;
import item.Item;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class WriterTest{
    @Test
    public void testWriterUsers() throws Exception {
        // Test with blank constructor returns blank
        Writer w = new Writer();
        assertEquals("", w.writerUsers());

        // Test with values returns values
        User u = new User("Ben101", "admin", 20.00);
        Map<String, User> users = new HashMap<>();
        users.put("", u);

        Writer w2 = new Writer(users);
        assertEquals("Ben101          admin 000020.00", w2.writerUsers());
    }

    @Test
    public void testWriterItems() throws Exception {
        // Test with blank constructor returns blank
        Writer w = new Writer();
        assertEquals("", w.writerItems());

        // Test with values returns values
        User u = new User("Ben101", "admin", 20.00);
        Map<String, User> users = new HashMap<>();
        users.put("", u);

        Writer w2 = new Writer(users);
        Pair<String, String> p = new Pair<>("ball", "Alfonso");
        Item i = new Item("ball", "Alfonso", "Shawn", 1, 13);
        w2.items.put(p, i);

        assertEquals(String.format("%1$-19s", "ball") + " " +
                    String.format("%1$-15s", "Alfonso") + " " +
                    String.format("%1$-15s", "Shawn") + " " +
                    String.format("%1$-3s", "001") + " " +
                    String.format("%1$-6s", "013.00"), w2.writerItems());
    }
}