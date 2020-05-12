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

public class TicketTest {

    private Ticket myTicket;
    private TicketList list;

    @BeforeAll
    @DisplayName("Starting Tests")
    public static void print(){System.out.println("Starting process");}

    @BeforeEach
    @DisplayName("New instance of Ticket & TicketList")
    void init(TestInfo testInfo, TestReporter testReporter)
    {
        myTicket = new Ticket();
        list = new TicketList();
        System.out.println("timestamp = " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing Getters and Setters of Ticket")
    void testGettersAndSetters(TestInfo testInfo)
    {
        myTicket.setCruiseCo("Costal");
        assertEquals(myTicket.getCruiseCo(),"Costal");
        myTicket.setPassenger("Matthew");
        assertEquals(myTicket.getPassenger(),"Matthew");
        myTicket.setMyDate("10/10/2020");
        assertEquals(myTicket.getMyDate(),"10/10/2020");
        myTicket.setDestination(("Calagari"));
        assertEquals(myTicket.getDestination(),"Calagari");
    }
    //invalid setter tests (individual)
    @Test
    @DisplayName("Invalid CruiseCo setter Test")
    void testCruiseCoInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
         myTicket.setCruiseCo("la");
        });
    }

    @Test
    @DisplayName("Invalid passenger setter Test")
    void testPassengerInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTicket.setPassenger("c");
        });
    }

    @Test
    @DisplayName("Invalid date setter Test")
    void testDateInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTicket.setMyDate("1234");
        });
    }

    @Test
    @DisplayName("Invalid date setter Test")
    void testDestinationInvalid(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myTicket.setDestination("Donegal");
        });
    }


    //Constructors Individual error scenarios
    @Test
    @DisplayName("Invalid Constructor Test (invalid CruiseCo)")
    void testConstructorCruiseCo(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ticket("col", "Matthew", "10/10/2020","Calagari");
        });

    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid Passenger)")
    void testConstructorPassenger(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ticket("Costal", "", "10/10/2020","Calagari");
        });

    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid Date)")
    void testConstructorMyDate(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ticket("Costal", "Matthew", "10102020","Calagari");
        });

    }

    @Test
    @DisplayName("Invalid Constructor Test (invalid Destination)")
    void testConstructorDestination(TestInfo testInfo)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Ticket("Costal", "Matthew", "10/10/2020","London");
        });

    }

    //ArrayList Tests

    @Test
    @DisplayName("valid ArrayList Entry test")
    void testTicketList(TestInfo testInfo)
    {
        TicketList list = new TicketList();
        Ticket ticket1 = new Ticket("Costal","Matthew","10/10/2020","Calagari");
        list.addTicket(ticket1);
        assertEquals(ticket1,list.findByPassenger("Matthew"));
    }

    @Test
    @DisplayName("valid ArrayList Entry test")
    void testTicketListInvalid(TestInfo testInfo)
    {
        Ticket ticket1 = new Ticket("Costal","Matthew","10/10/2020","Calagari");
        Ticket ticket2 = new Ticket("Costal","Matthew","10/10/2020","Calagari");
        list.addTicket(ticket1);
        Assertions.assertThrows(InvalidParameterException.class, () ->{
           list.addTicket(ticket2);
        });
    }
    @Test
    @DisplayName("Invalid Array search")
    void testTicketListSearch(TestInfo testInfo)
    {
        Ticket ticket1 = new Ticket("Costal","Matthew","10/10/2020","Calagari");
        list.addTicket(ticket1);
        assertEquals(null,list.findByPassenger("James"));
    }

    @AfterAll
    @DisplayName("Testing Complete")
    public static void done(){System.out.println("Testing complete");}


}
