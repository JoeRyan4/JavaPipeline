/*
    Passenger Test class
    Ciaran Walsh
    G00321396
 */
import ie.gmit.Passenger;
import ie.gmit.PassengerList;
import org.junit.jupiter.api.*;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PassengerTest {
    private Passenger myPassenger;
    private PassengerList list;

    @BeforeAll
    @DisplayName("Starting tests")
    public static void print(){
        System.out.println("Starting tests");
    }

    @BeforeEach
    @DisplayName("New instance of Passenger and Passenger List")
    void init(TestInfo testInfo, TestReporter testReporter)
    {
        myPassenger = new Passenger("MrMrs", "Ciaran", "Walsh");
        list = new PassengerList();
        System.out.println("timestamp = " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing Getters and Setters of Passenger")
    void testGettersAndSetters(TestInfo testInfo)
    {
        myPassenger.setTitle("MrMrs");
        assertEquals(myPassenger.getTitle(),"MrMrs");
        myPassenger.setFirstName("Ciaran");
        assertEquals(myPassenger.getFirstName(), "Ciaran");
        myPassenger.setLastName("Walsh");
        assertEquals(myPassenger.getLastName(), "Walsh");
    }

    @Disabled
    @Test
    @DisplayName("Invalid Title setter Test")
    void testTitleInvalid(TestInfo testInfo)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            myPassenger.setTitle("ze");
        });
    }

    @Disabled
    @Test
    @DisplayName("Invalid First Name setter Test")
    void testFirstNameInvalid(TestInfo testInfo)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            myPassenger.setFirstName("ze");
        });
}

    @Disabled
    @Test
    @DisplayName("Invalid Last Name setter Test")
    void testLastNameInvalid(TestInfo testInfo)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            myPassenger.setLastName("zf");
        });
    }

    @Disabled
    @Test
    @DisplayName("Invalid Constructor Test (invalid title)")
    void testConstructorTitle(TestInfo testInfo)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("MrMrs", "Ciaran", "Walsh");
        });
    }

    @Disabled
    @Test
    @DisplayName("Invalid Constructor Test (invalid firstName)")
    void testConstructorFirstName(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("NoTitle", "Ciaran", "Walsh");
        });
    }

    @Disabled
    @Test
    @DisplayName("Invalid Constructor Test (invalid lastName)")
    void testConstructorLastName(TestInfo testInfo)
    {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("NoTitle", "Ciaran", "Walsh");
        });
    }

    @Disabled
    @Test
    @DisplayName("Valid Constructor test")
    void testConstructorValid(TestInfo testInfo)
    {
        Passenger passenger1 = new Passenger("NoTitle", "Ciaran", "Walsh");
        assertEquals("Ciaran",
                passenger1.getFirstName());
        assertEquals("Walsh",passenger1.getLastName());
        assertEquals("Mr",passenger1.getTitle());
    }

    @Disabled
    @Test
    @DisplayName("Valid ArrayList Entry test")
    void testPassengerList(TestInfo testInfo)
    {
        PassengerList list = new PassengerList();
        Passenger passenger1 = new Passenger("NoTitle", "Ciaran", "Walsh");
        list.addPassenger(passenger1);
        assertEquals(passenger1,list.findByFirstName("Paul"));
    }

    @Disabled
    @Test
    @DisplayName("Invalid Arraylist Entry test")
    void testPassengerListInvalid(TestInfo testInfo)
    {
        Passenger passenger1 = new Passenger("NoTitle", "Ciaran", "Walsh");
        Passenger passenger2 = new Passenger("NoTitle", "Ciaran", "Walsh");
        list.addPassenger(passenger1);
        assertThrows(InvalidParameterException.class, () -> {
            list.addPassenger(passenger2);
        });
    }

    @Disabled
    @Test
    @DisplayName("Invalid Arraylist Search")
    void testPassengerListSearch(TestInfo testInfo)
    {
        Passenger passenger1 = new Passenger("NoTitle", "Ciaran", "Walsh");
        list.addPassenger(passenger1);
        assertEquals(null, list.findByFirstName("Ciaran"));
    }

    @AfterAll
    @DisplayName("Testing complete")
    public static void done(){
        System.out.println("Testing Complete");
    }
}
