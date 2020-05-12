package ie.gmit;

import java.util.ArrayList;

public class CruiseCo {
    private String name; // Name of the cruises
    private ArrayList<Ship> ships = new ArrayList<Ship>(); // Information about all of the cruises
    private ArrayList<Ship> matchingShips = new ArrayList<Ship>(); // Has all the ships from the function findShips()

    // Default Constructor
    public CruiseCo()
    {
        this.name = "Royal Carribean";
    }
    // Getter functions--------------------
    public String getName()
    {
        return name;
    }

    public Ship getShip()
    {
        int shipNumber = 0;
        return ships.get(shipNumber);
    }

    public ArrayList<Ship> getMatchingShips()
    {
        return matchingShips;
    }

    public int getNumberOfShips()
    {
        return ships.size();
    }

    // Setter Functions---------------------


    // Class Methods------------------------

    // Cancels a ticket
    public void cancel(Ticket t)
    {
        int shipNum = Integer.parseInt(t.getMyShip() );
        System.out.println(t.getMyPassenger() + " has been refunded $"
                + t.getTicketPrice() );
        ships.get(shipNum).remove(t);
    }

    public void issueRefund(Ticket t)
    {
        System.out.println(t.getMyPassenger()
                + " has been refunded $" + t.getTicketPrice() );
    }

    // Shows all the current ships and their information for this cruises
    public void showShips()
    {
        for (int i = 0; i < ships.size(); i++)
        {
            System.out.print(getName() + " " + ships.get(i).getShipNumber()
                    + " "+ ships.get(i).getDate() + " ");
            System.out.printf("%.02f", ships.get(i).getDepartureTime() );
            System.out.print( " from " + ships.get(i).getOrigin() + " to "
                    + ships.get(i).getDestination() + " ticket cost €" + ships.get(i).getCost() );
            System.out.println();
        }
    }

    // Finds all ships for a 4 hour departure window
    public ArrayList<Ship> findShips(String date, double time, String origin)
    {
        matchingShips.clear();
        for (int i = 0; i < ships.size(); i++)
        {
            if (ships.get(i).matches(date, time, origin) )
            {
                matchingShips.add(ships.get(i) );
            }
        }

        return matchingShips;
    }

    // Shows all the matching ships that the passenger requested
    public void showMatchingShips()
    {
        for (int i = 0; i < matchingShips.size(); i++)
        {
            System.out.print(getName() + " " + matchingShips.get(i).getShipNumber()
                    + " " + matchingShips.get(i).getDate() + " ");
            System.out.printf("%.2f", matchingShips.get(i).getDepartureTime() );
            System.out.print(" from " + matchingShips.get(i).getOrigin()
                    + " to " + matchingShips.get(i).getDestination()
                    + " ticket cost €" + matchingShips.get(i).getCost() );
            System.out.println();
            System.out.println("Here are the following matches on this particular day.  ");  //////
            System.out.println();
        }
    }


    public Ticket book(Passenger p, Ship s)
    {
        Ticket t = new Ticket();
        s.addTicket(t);
        p.bookShip(p.getTitle(), p.getFirstName(), p.getLastName(), name, s);
        return t;
    }

    public double cost(Ship f)
    {
        return f.getCost();
    }


    public void createFlight(double time, int numSeats, String from, String to)
    {
        Ship ship = new Ship(time, numSeats, from, to);
        ships.add(ship);
    }

    public void createShip(double cagTime, int seats, String cagliari, String piraeus) {
    }

    public void setName(String royal_carribean) {
    }

    public void findFlights(String date, double time, String from) {
    }

    public void showMatchingFlights() {
    }

    public void setNumberOfShips(int i) {
    }
}
