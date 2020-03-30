package tests;

import item.Item;
import javafx.util.Pair;
import util.Reader;
import org.junit.Test;
import org.junit.runner.Result;
import process.ProcessAccount;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ReaderTest {
    @Test
    public void readerTest(){
        List<String> testing = new ArrayList<>();
        testing.add("TestOne         FS 000010000");
        testing.add("TestTwo         FS 000010000");
        testing.add("TestThree       FS 000010000");
        Reader r = new Reader("testRead.txt");
        assertEquals(testing, r.data);
    }
    //Loop coverage with 0,1,2,3 iterations of line reading loop n the ReaderClass
    //For zero loops the fle is empty so the line while(line != null){ is not executed
    @Test
    public void readUserZero(){
        Reader r = new Reader();
        r.readUser("Zero.txt");
        Map<String, User> testing = new HashMap<>();
        assertEquals(testing.toString(), (r.users).toString());
    }
    //For One loop the file only has one line
    @Test
    public void readUserOne(){
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        Reader r = new Reader();
        r.readUser("One.txt");
        assertEquals(testing.toString(), (r.users).toString());
    }
    //For two loop the file only has two lines
    @Test
    public void readUserTwo(){
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        Reader r = new Reader();
        r.readUser("Two.txt");
        assertEquals(testing.toString(), (r.users).toString());
    }
    //For many loops the file only has three lines
    @Test
    public void readUserMany(){
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        Reader r = new Reader();
        r.readUser("testUserRead.txt");
        assertEquals(testing.toString(), (r.users).toString());
    }
    //Decision test
    //readItem will not trigger the if(line.equals("END"))
    @Test
    public void readItem(){
        Map<Pair<String,String>, Item> testing = new HashMap<>();
        Item item = new Item("guitar","seller","oldbuyer",7,300.00);
        Pair<String, String> key = new Pair<>("guitar", "seller");
        testing.put(key, item);
        Reader r = new Reader();
        r.readItem("testItemRead.txt");
        assertEquals(testing.toString(), (r.items).toString());
    }
    //readItemEnd will trigger if(line.equals("END")) so any items after it should not be added to the mao
    @Test
    public void readItemEnd(){
        Map<Pair<String,String>, Item> testing = new HashMap<>();
        Item item = new Item("guitar","seller","oldbuyer",7,300.00);
        Pair<String, String> key = new Pair<>("guitar", "seller");
        testing.put(key, item);
        Reader r = new Reader();
        r.readItem("IFTest.txt");
        assertEquals(testing.toString(), (r.items).toString());
    }
}
