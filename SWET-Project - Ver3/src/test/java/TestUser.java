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


    }
}
