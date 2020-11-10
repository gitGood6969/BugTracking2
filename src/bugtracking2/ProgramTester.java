// JUnit class
// Package
package bugtracking2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProgramTester extends junit.framework.TestCase
{
    // Test Entity Class
    private bugtracking2.User u;

    // Test Controller Class
    private bugtracking2.UserLoginController c;

    @Before
    public void setUp() throws Exception
    {
        // Create Entity class
        u = new bugtracking2.User(); 

        // Create Controller class
        c = new bugtracking2.UserLoginController();
    }

    //===========================================
    @Test
    public void testSuccessfulLoginFromEntity()
    {
        String username = "debby";
        String password = "112";
        assertEquals(u.LoginStatus(username, password), true);
    }
    
    @Test
    public void testFailLoginFromEntity()
    {
        String username = "debby";
        String password = "123";
        assertEquals(u.LoginStatus(username, password), false);
    }

    @Test
    public void testGetIDFromEntity()
    {
        String username = "john";
        String password = "444";
        int[] myIntArray = {4,8};
        assertArrayEquals(u.getID(username, password), myIntArray);
    }
    //===========================================
    @Test
    public void testSuccessfulValidateUserFromController()
    {
        String username = "alice";
        String password = "333";
        assertEquals(c.ValidateUser(username, password), true);
    }

    @Test
    public void testFailValidateUserFromController()
    {
        String username = "simon";
        String password = "111";
        assertEquals(c.ValidateUser(username, password), false);
    }

    @Test
    public void testGetUserFromController()
    {
        String username = "craig";
        String password = "334";
        int[] myIntArray = {3,7};
        assertArrayEquals(u.getID(username, password), myIntArray);
    }
}