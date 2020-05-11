import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUser {

    @BeforeAll
    static void BeginTest(){
        System.out.println("Begining Testing");
    }


    @AfterAll
    static void EndTest()
    {
        System.out.println("Testing concluded");
    }

    @Test
    void test2ArgConstructor()
    {
        User user = new User("Stephen","Kilgannon");
        assertEquals("Stephen",user.getName(),"Name Tested");
        assertEquals("Kilgannon",user.getSurname(),"Surname Tested");

    }
    @Test
    void test3ArgConstructor()
    {
        User user = new User("Stephen","Kilgannon","0871111111");
        assertEquals("Stephen",user.getName(),"Name Tested");
        assertEquals("Kilgannon",user.getSurname(),"Surname Tested");
        assertEquals("0871111111",user.getPhone(),"Phone Tested");

    }


    @Test
    void testConstructor()
    {
        User user = new User("Stephen","Kilgannon","0871111111","17 Belmont","DublinRd","Galway","28/12/94","h91efh");
        assertEquals("Stephen",user.getName(),"Name Tested");
        assertEquals("Kilgannon",user.getSurname(),"Surname Tested");
        assertEquals("0871111111",user.getPhone(),"Phone Tested");
        assertEquals("17 Belmont",user.getAddr1(),"Address Tested");
        assertEquals("DublinRd",user.getAddr2(),"Address Tested");
        assertEquals("Galway",user.getCity(),"City Tested");
        assertEquals("28/12/94",user.getDOB(),"DOB Tested");
        assertEquals("h91efh",user.getEirCode(),"Eircode Tested");

    }
}
