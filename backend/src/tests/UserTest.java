//this test is to test the User class

package tests;

import user.User;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class UserTest{
    @Test
    public void testToString() throws Exception {
        User u = new User("testUser", "AA", 100.00);
        assertEquals(String.format("%1$-15s", "testUser") + " " +
                    String.format("%1$-2s", "AA") + " " +
                    String.format("%1$9s", "000100.00")
                    , u.toString());
    }
}
