package ie.gmit;
/*
    Ticket class
    Joseph Ryan
    G00337523
 */
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class TicketList {

    ArrayList<Ticket> listOfDetails = new ArrayList<Ticket>();

    public void addTicket(Ticket newTicket){
        for(Ticket ticket : listOfDetails)
            if(ticket.getPassenger().equals(newTicket.getPassenger()))
                throw new InvalidParameterException("Passenger Already Booked");
            listOfDetails.add(newTicket);
    }


    public Ticket findByPassenger(String passenger) {
        for (Ticket ticket : listOfDetails) {
            if (ticket.getPassenger().equals(passenger)) {
                return ticket;
            }
        }
        return null;
    }
}
