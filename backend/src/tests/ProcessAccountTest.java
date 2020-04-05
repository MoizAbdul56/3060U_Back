package tests;

import org.junit.Test;
import org.junit.runner.Result;
import process.ProcessAccount;
import user.User;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProcessAccountTest {
    @Test
    public void addAccountTest() {
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        ProcessAccount u = new ProcessAccount(testing);
        u.addAccount("01 TestFour FS 500");
        User four = new User("Testfour", "FS", 10000);
        testing.put("TestFour", four);
        assertEquals(testing, u.users);
    }
    @Test
    public void deleteAccountTest() {
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        ProcessAccount u = new ProcessAccount(testing);
        u.deleteAccount("02 TestThree FS 500");
        testing.remove("TestThree");
        assertEquals(testing, u.users);
    }
    @Test
    public void addCreditTest() {
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        ProcessAccount u = new ProcessAccount(testing);
        u.addCredit("06 TestThree FS 500");
        testing.remove("TestThree");
        three.credit = 10500;
        testing.put("TestThree", three);
        assertEquals(testing, u.users);
    }
    @Test
    public void refundTest() {
        Map<String, User> testing = new HashMap<>();
        User one = new User("TestOne", "FS", 10000);
        testing.put("TestOne", one);
        User two = new User("TestTwo", "FS", 10000);
        testing.put("TestTwo", two);
        User three = new User("TestThree", "FS", 10000);
        testing.put("TestThree", three);
        ProcessAccount u = new ProcessAccount(testing);
        u.refund("05 TestThree TestTwo 500");
        testing.remove("TestThree");
        testing.remove("TestTwo");
        three.credit = 10500;
        two.credit = 90500;
        testing.put("TestTwo", two);
        testing.put("TestThree", three);
        assertEquals(testing, u.users);
    }
}
