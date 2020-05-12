package ie.gmit;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * The goal of this project is to create a simple simulation of a booking
 * system for a small airline that runs computer flights between two
 * cities on a daily basis. This project keeps tack of flights for the month
 * of October 2017.
 */

public class Main {

    // Generates the flights for the cruiseCo taking an Airline as a parameter
    private static CruiseCo generateShips(CruiseCo cruiseCo)
    {
        Random randomSeats = new Random();
        Random randomMinute = new Random();

        double cagHour = 5, pirHour = 5, minute = 0;
        double cagTimes[] = new double[16];
        double pirTimes[] = new double[16];

        // Generates the time for the Kennedy flights from 6am to 10pm
        for (int i = 0; i < cagTimes.length; i++)
        {
            if (cagHour > 22) { cagHour = 5; }

            cagHour++;
            minute = randomMinute.nextInt(59) + 1;
            minute /= 100.00;

            double flightTime = cagHour + minute;
            cagTimes[i] = flightTime;
        }

        // Generates the time for the Laguardia flights from 6am to 10pm
        for (int i = 0; i < pirTimes.length; i++)
        {
            if (pirHour > 22) { pirHour = 5; }

            pirHour++;
            minute = randomMinute.nextInt(60) + 1;
            minute /= 100.00;

            double flightTime = pirHour + minute;
            pirTimes[i] = flightTime;
        }

        int seats = 0, date = 1, index = 0, timeIndex = 0; // time index is used to keep track of when to start a new date

        // Generates the seating and the flights themselves
        do {
            seats = randomSeats.nextInt(300) + 150;

            cruiseCo.createFlight( (cagTimes[timeIndex]), seats, "Cagliari", "Piraeus");
            cruiseCo.getShip().setDate(date);

            index++;

            cruiseCo.createFlight( (pirTimes[timeIndex]), seats, "Piraeus", "Cagliari");
            cruiseCo.getShip().setDate(date);

            index++;
            timeIndex++;

            if (timeIndex == cagTimes.length)
            {
                timeIndex = 0;
                date++;
            }

        } while (date < 32);

        return cruiseCo;
    }

    /* Generates 10000 random passengers to fill in random flights,
     * as each flight fills up the price of the flight increases
     * if the flight does not have space, it will generate a new
     * random flight number for the passenger to book
     */
    private static void generatePassengers(CruiseCo cruiseCo)
    {
        ArrayList<Passenger> flightPassengers = new ArrayList<Passenger>();

        Random randomFlight = new Random();

        for (int i = 0; i < 10000; i++)
        {
            Passenger dummy = new Passenger("Mr.","Bobby", "Singer");
            flightPassengers.add(dummy);
            int flightNumber = randomFlight.nextInt(cruiseCo.getNumberOfShips() );

            if( cruiseCo.getShip().hasSpace() )
                cruiseCo.book(flightPassengers.get(i), cruiseCo.getShip() );
            else {
                while(!cruiseCo.getShip().hasSpace() )
                {
                    flightNumber = randomFlight.nextInt(cruiseCo.getNumberOfShips() );
                    cruiseCo.book(flightPassengers.get(i), cruiseCo.getShip() );
                }
            }
        }
    }

    public static void main(String[] args)
    {
        CruiseCo cruiseCo = new CruiseCo();
        Scanner keyboard = new Scanner(System.in);

        generateShips(cruiseCo);
        generatePassengers(cruiseCo);

        //CruiseCo.showShips(); //Uncomment to show all fights

        System.out.println("Ready to book your Cruise, enter your title (eg. Mr, Mrs, Miss etc.): ");
        String title = keyboard.nextLine();
        System.out.println("First name: ");
        String firstName = keyboard.nextLine();
        System.out.println("Last name: ");
        String lastName = keyboard.nextLine();

        Passenger p = new Passenger(title, firstName, lastName);

        System.out.println("Please enter your Date of Birth (eg. 24/12/1991): ");
        String DOB = keyboard.nextLine();
        p.setDOB(DOB);

        System.out.println("Please enter your address: ");
        String address = keyboard.nextLine();
        p.setAddress(address);

        System.out.println("Please enter your PostCode *Not Mandatory*: ");
        String postCode = keyboard.nextLine();
        p.setPostCode(postCode);

        System.out.println("Name of Region: ");
        String region = keyboard.nextLine();
        p.setRegion(region);

        System.out.println("Please enter your Nationality: ");
        String nationality = keyboard.nextLine();
        p.setNationality(nationality);

        System.out.println("Please enter your phone number: ");
        String phone = keyboard.nextLine();
        p.setPhone(phone);

        System.out.println("Please enter your email address: ");
        String email = keyboard.nextLine();
        p.setEmail(email);

        System.out.println("Please enter your passport Number: ");
        String passportNo = keyboard.nextLine();
        p.setPassportNo(passportNo);

        System.out.println("Please outline any medical issues: ");
        String medic = keyboard.nextLine();
        p.setMedic(medic);

        System.out.println("Do You have any allergies? please specify: ");
        String allergy = keyboard.nextLine();
        p.setAllergy(allergy);

        System.out.println("Ready to book your Cruise between Cagliari and Piraeus for October 2020");

        while(true)
        {
            System.out.println("Do you want to book or cancel a Cruise Destination? Answer Yes or No");
            String input = keyboard.nextLine();
            char answer = input.charAt(0);

            if ( (answer == 'Y') || (answer == 'y') ) {
                System.out.println("Enter K to cancel a flight, C for a Cruise from Cagliari, or P for a Cruise from Piraeus");
                input = keyboard.nextLine();
                answer = input.charAt(0);

                // Cancels a flight for the user
                if ( (answer == 'K') || (answer == 'k') )
                {
                    if (p.getNumberOfTickets() == 0)
                    {
                        System.out.println("You have not booked any tickets yet! ");
                        System.out.println();
                    }

                    else {

                        System.out.println("Here are the Cruise Routes you have booked, select from 1 - "
                                + p.getNumberOfTickets() + ": " );
                        p.showTickets();

                        System.out.println("Which ticket would you like to cancel?");
                        int ticketNumber = keyboard.nextInt();

                        cruiseCo.issueRefund(p.getTicket(ticketNumber));
                        p.cancel(p.getTicket(ticketNumber) );

                        keyboard.nextLine();
                    }
                }

                // Asks the user to find the flight they desire from Kennedy to Laguardia
                else if ( (answer == 'C') || (answer == 'c') )
                {
                    System.out.println("Enter the day in October that you want to fly (In range from 1 - 31): ");
                    String myDay = keyboard.nextLine();

                    System.out.println("Enter the hour you would like to fly (In range from 6 - 22): ");
                    double myHour = keyboard.nextDouble();

                    cruiseCo.findFlights(myDay, myHour, "Cagliari");
                    ArrayList<Ship> myMatchingShips = new ArrayList<Ship>();
                    for (int i = 0; i < cruiseCo.getMatchingShips().size(); i++)
                    {
                        myMatchingShips.add(cruiseCo.getMatchingShips().get(i) );
                    }

                    System.out.println("Here are the available Voyage options: ");
                    cruiseCo.showMatchingFlights();

                    System.out.println("Select the number of the CruiseShip you wish to book: ");
                    keyboard.nextLine();
                    int flightInput = keyboard.nextInt();

                    for (int i = 0; i < myMatchingShips.size(); i++)
                    {
                        if (flightInput == myMatchingShips.get(i).getShipNumber() )
                        {
                            if (myMatchingShips.get(i).hasSpace() )
                            {
                                p.bookShip(p.getTitle(), p.getFirstName(),
                                        p.getLastName(), cruiseCo.getName(), myMatchingShips.get(i) );
                                System.out.println("Successfully booked ticket!");
                                keyboard.nextLine();
                            }
                        }
                    }
                }

                // Asks the user to find the flight they desire from Laguardia to Kennedy
                else if ( (answer == 'P') || (answer == 'p') )
                {
                    System.out.println("Enter the day in October that you want to Cruise (In range from 1 - 31): ");
                    String myDay = keyboard.nextLine();

                    System.out.println("Enter the hour you would like to voyage (In range from 6 - 22): ");
                    double myHour = keyboard.nextDouble();

                    cruiseCo.findFlights(myDay, myHour, "Piraeus");
                    ArrayList<Ship> myMatchingShips = new ArrayList<Ship>();
                    for (int i = 0; i < cruiseCo.getMatchingShips().size(); i++)
                    {
                        myMatchingShips.add(cruiseCo.getMatchingShips().get(i) );
                    }

                    System.out.println("Here are the available flights: ");
                    cruiseCo.showMatchingFlights();

                    System.out.println("Type the number of the Cruise you wish to book: ");
                    keyboard.nextLine();
                    int flightInput = keyboard.nextInt();

                    for (int i = 0; i < myMatchingShips.size(); i++)
                    {
                        if (flightInput == myMatchingShips.get(i).getShipNumber() )
                        {
                            if (myMatchingShips.get(i).hasSpace() )
                            {
                                p.bookShip(p.getTitle(), p.getFirstName(),
                                        p.getLastName(), cruiseCo.getName(), myMatchingShips.get(i) );
                                System.out.println("Successfully booked ticket!");
                                keyboard.nextLine();
                            }
                        }
                    }
                }

                else System.out.println("Error, invalid choice");
            }

            // Shows the tickets and exit
            else if ( (answer == 'N') || (answer == 'n') )
            {
                System.out.println("Thank you for booking with " + cruiseCo.getName() );
                System.out.println("Here is a list of your bookings: ");
                p.showTickets();
                keyboard.close();
                System.exit(0);
            }

            else System.out.println("Error, invalid choice, please try again.");

        }
    }
}
