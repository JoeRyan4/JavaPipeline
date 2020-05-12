/*
    CruiseCoTests class

    Ciaran Walsh
    G00321396
    21/02/2020
 */

import ie.gmit.CruiseCo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CruiseCoTest {
    private CruiseCo myCruiseCo;

    @BeforeAll
    @DisplayName("Starting tests")
    public static void print(){
        System.out.println("Starting tests");
    }

    @BeforeEach
    @DisplayName("New instance of CruiseCo")
    void init(TestInfo testInfo, TestReporter testReporter)
    {
        myCruiseCo = new CruiseCo ();
        System.out.println("timestamp = " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing Getters and Setters of Cruise Co Name")
    void testCruiseCoName(TestInfo testInfo)
    {
        myCruiseCo.setName("Royal Carribean");
        assertEquals(myCruiseCo.getName(),"Royal Carribean");
    }

    //public int getNumberOfShips()
    //    {
    //        return ships.size();
    //    }

    @AfterAll
    @DisplayName("Testing complete")
    public static void done(){
        System.out.println("Testing Complete");
    }
}
