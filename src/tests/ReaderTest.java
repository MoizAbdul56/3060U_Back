package tests;

import util.*;
import org.junit.Test;
import org.junit.runner.Result;
import process.ProcessAccount;
import user.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void readerTest(){
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        Reader r = new Reader("testRead.txt");
    }
}
