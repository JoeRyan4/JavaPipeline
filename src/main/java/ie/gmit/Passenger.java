package ie.gmit;
/*
    ie.gmit.Passenger class
    Ciaran Walsh
    G00321395
 */
import java.util.ArrayList;

public class Passenger {
    private String title, firstName, lastName, DOB,
            address, postCode, region, nationality, phone, email, passportNo, medic, allergy;
    private ArrayList<Ticket> myTickets = new ArrayList<Ticket>();
    private int numberOfTickets;

    // Default Constructor
    public Passenger(String title, String firstName, String lastName)
    {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        nationality = "";
        DOB = "";
        postCode = "";
        address = "";
        region = "";
        phone = "";
        email = "";
        passportNo = "";
        medic = "";
        allergy = "";
    }

    // Getter Functions-------------------------------
    public String getTitle() { return title; }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getNationality()
    {
        return nationality;
    }

    public String getDOB()
    {
        return DOB;
    }

    public String getAddress()
    {
        return address;
    }

    public String getRegion()
    {
        return region;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }

    public String getPassportNo()
    {
        return passportNo;
    }
    public String getMedic()
    {
        return medic;
    }

    public String getAllergy()
    {
        return allergy;
    }
    public int getNumberOfTickets()
    {
        return numberOfTickets;
    }

    public Ticket getTicket(int index)
    {
        return myTickets.get(index - 1);
    }

    // Setter Functions------------------------------
    public void setNationality(String n)
    {
        nationality = n;
    }

    public void setDOB(String d)
    {
        DOB = d;
    }

    public void setAddress(String a)
    {
        address = a;
    }

    public void setRegion(String r)
    {
        region = r;
    }

    public void setPostCode(String c)
    {
        postCode = c;
    }

    public void setPhone(String p)
    {
        phone = p;
    }
    public void setEmail(String e)
    {
        email = e;
    }
    public void setPassportNo(String l)
    {
        passportNo = l;
    }
    public void setMedic(String j)
    {
        medic = j;
    }
    public void setAllergy(String h)
    {
        allergy = h;
    }
    // Class Methods------------------------------------------------------------------------

    // Shows all tickets a passenger has
    public void showTickets()
    {
        for (int i = 0; i < myTickets.size(); i++)
        {
            System.out.print( (i + 1) + " " + myTickets.get(i).getMyPassenger()
                    + " booked on " + myTickets.get(i).getMyCruiseCo()
                    + ", Cruise number "+ myTickets.get(i).getMyShip()
                    + " on " + myTickets.get(i).getMyDate() + " at ");
            System.out.printf("%.02f", myTickets.get(i).getMyTicketTime() );
            System.out.print(", " + myTickets.get(i).getMyShipDestination()
                    + " cost $" + myTickets.get(i).getTicketPrice() );
            System.out.println();
        }
    }

    // Cancels the passenger's ticket t
    public void cancel(Ticket t)
    {
        for (int i = 0; i < myTickets.size(); i++)
        {
            if (t.getTicketNumber() == myTickets.get(i).getTicketNumber())
            {
                myTickets.get(i).cancel();
                myTickets.remove(i);
            }
        }
        numberOfTickets--;
    }

    /* Finds all Boats for an Cruise Company on a particular date.
     */
    public ArrayList<Ship> findShips(CruiseCo a, String date, double time, String from)
    {
        ArrayList<Ship> matchingFlights = new ArrayList<Ship>();

        a.findFlights(date, time, from);

        return matchingFlights;
    }

    // Books a ticket for a particular boat (for the passenger)
    public Ticket bookShip(String title, String firstName, String lastName, String boat, Ship f)
    {

        Ticket t = new Ticket(f.getCost(), f.getDepartureTime(), boat,
                (title + " " + firstName +  " " + lastName),
                f.getShipNumber(), f.getDate(),"from "
                + f.getOrigin() + " to " + f.getDestination() );

        f.addTicket(t);
        myTickets.add(t);
        numberOfTickets++;

        return t;
    }

    // Reports where the passenger holds a particular ticket
    public boolean holdsTicket(Ticket t)
    {
        for (int i = 0; i < myTickets.size(); i++)
        {
            if (t.getTicketNumber() == myTickets.get(i).getTicketNumber() )
                return true;
        }
        return false;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTitle() {
        setTitle ();
    }
}
