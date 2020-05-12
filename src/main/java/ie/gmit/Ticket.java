package ie.gmit;

public class Ticket {
    private int ticketNumber;
    private double myPrice, myTicketTime;
    private String myCruiseCo, myPassenger, myShip, myDate, myShipDestination;
    static private int counter = 0; // Creates a new ticket number every time a ticket is initialized

    // Default Constructor
    public Ticket()
    {
        counter++;
        ticketNumber = counter;
    }

    // Overloaded Constructor
    public Ticket(double myPrice, double myTicketTime, String myCruiseCo,
                  String myPassenger, int myShipNumber, String myDate, String myShipDestination)
    {
        counter++;
        ticketNumber = counter;

        this.myPrice = myPrice;
        this.myTicketTime = myTicketTime;
        this.myCruiseCo = myCruiseCo;
        this.myPassenger = myPassenger;
        myShip = Integer.toString(myShipNumber);
        this.myDate = myDate;
        this.myShipDestination = myShipDestination;
    }

    public Ticket(int ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    // Getter Methods-----------------------------------
    public int getTicketNumber()
    {
        return ticketNumber;
    }

    public double getTicketPrice()
    {
        return myPrice;
    }

    public String getMyCruiseCo()
    {
        return myCruiseCo;
    }

    public String getMyPassenger()
    {
        return myPassenger;
    }

    public String getMyShip()
    {
        return myShip;
    }

    public String getMyDate()
    {
        return myDate;
    }

    public double getMyTicketTime()
    {
        return myTicketTime;
    }

    public String getMyShipDestination()
    {
        return myShipDestination;
    }

    //Setter Method----------------------------------------------------------
    public void setMyCruiseCo(String airlineName)
    {
        myCruiseCo = airlineName;
    }

    public void setMyPassenger(String title, String firstName, String lastName)
    {
        myPassenger = title + " " + firstName + " " + lastName;
    }

    public void setMyShip(int flightNumber)
    {
        myShip = Integer.toString(flightNumber);
    }

    public void setTicketPrice(double price)
    {
        myPrice = price;
    }

    public void setMyDate(String date)
    {
        myDate = date;
    }

    public void setMyTicketTime(double ticketTime)
    {
        myTicketTime = ticketTime;
    }

    public void setMyShipDestination(String origin, String to)
    {
        myShipDestination = "from " + origin + " to " + to;
    }

    // Class Methods------

    // Cancels the ticket
    public void cancel()
    {
        myPassenger = "";
        myShip = "";
        myDate = "";
        myShipDestination = "";
        myTicketTime = 0;
    }
}
