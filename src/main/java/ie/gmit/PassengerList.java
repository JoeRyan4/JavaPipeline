package ie.gmit;
/*
    ie.gmit.Passenger class
    Ciaran Walsh
    G00321395
 */
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class PassengerList {

    ArrayList<Passenger> listOfDetails = new ArrayList<Passenger>();

    public void addPassenger(Passenger newPassenger){
        for(Passenger passenger : listOfDetails)
            if(passenger.getFirstName().equals(newPassenger.getFirstName()))
                throw new InvalidParameterException("ie.gmit.Passenger Already Booked");
        listOfDetails.add(newPassenger);
    }


    public Passenger findByFirstName(String FirstName) {
        for (Passenger passenger : listOfDetails) {
            if (passenger.getFirstName().equals(FirstName)) {
                return passenger;
            }
        }
        return null;
    }
}
