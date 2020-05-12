/*
    Ticket class
    Joseph Ryan
    G00337523
 */
import static org.junit.jupiter.api.Assertions.*;
import ie.gmit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

public class ShipTest {

    private Ship myShip;

    @BeforeAll
    @DisplayName("Starting Tests")
    public static void print(){System.out.println("Starting process");}

    @BeforeEach
    @DisplayName("New instance of Ticket & TicketList")
    void init(TestInfo testInfo, TestReporter testReporter)
    {
        myShip = new Ship();
        System.out.println("timestamp = " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing Getters and Setters of Ticket")
    void testGettersAndSetters(TestInfo testInfo)
    {
        myShip.setOriginPort("Bari");
        assertEquals(myShip.getOriginPort(),"Bari");
        myShip.setDate("08/07/2020");
        assertEquals(myShip.getDate(),"08/07/2020");
        myShip.setDepartureTime("09:00");
        assertEquals(myShip.getDepartureTime(),"09:00");
        myShip.setPrice("$100");
        assertEquals(myShip.getPrice(),"$100");
    }
    //invalid setter tests (individual)
    @Test
    @DisplayName("Invalid Port setter Test")
    void testCruiseCoInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myShip.setOriginPort("l");
        });
    }

    @Test
    @DisplayName("Invalid Departure Date Test")
    void testPassengerInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myShip.setDate("160421");
        });
    }

    @Test
    @DisplayName("Invalid Departure time setter Test")
    void testDateInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myShip.setDepartureTime("1556");
        });
    }

    @Test
    @DisplayName("Invalid Price Test")
    void testPriceInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myShip.setPrice("89");
        });
    }

    //Constructors Individual error scenarios
    @Test
    @DisplayName("Invalid Constructor Test (invalid Port of origin)")
    void testConstructorOriginPort(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ship("co", "12/04/21", "09:00","$100");
        });
    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid departure date)")
    void testConstructorDate(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ship("Bari", "120421", "09:00","$100");
        });
    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid departure Time)")
    void testConstructorDepartureTime(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ship("Bari", "12/04/21", "0900","$100");
        });
    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid Ticket Price)")
    void testConstructorPrice(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ship("Bari", "12/04/21", "09:00","100");
        });
    }

    @AfterAll
    @DisplayName("Testing Complete")
    public static void done(){System.out.println("Testing complete");}

}
