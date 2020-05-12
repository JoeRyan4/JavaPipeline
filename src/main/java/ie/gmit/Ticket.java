package ie.gmit;
/*
    Ticket class
    Joseph Ryan
    G00337523
 */
public class Ticket {

    private String cruiseCo;
    private String passenger;
    private String myDate;
    private String destination;

    public Ticket(){
        this.cruiseCo = "";
        this.passenger = "";
        this.myDate = "";
        this.destination = "";
    }

    public Ticket(String cruiseCo, String passenger, String myDate, String destination){
        if((cruiseCo.length() < 5) || (passenger.length() < 1) || (!myDate.contains("/")) || (!destination.contains("C"))){
            throw new IllegalArgumentException();
        }else {
            this.cruiseCo = cruiseCo;
            this.passenger = passenger;
            this.myDate = myDate;
            this.destination = destination;
        }
    }

    public String getCruiseCo() { return cruiseCo; }

    public void setCruiseCo(String cruiseCo) {
        if (cruiseCo.length() < 5) {
            throw new IllegalArgumentException();
        } else {
            this.cruiseCo = cruiseCo;
        }
    }

    public String getPassenger() { return passenger; }

    public void setPassenger(String passenger) {
        if (passenger.length() < 3) {
            throw new IllegalArgumentException();
        } else {
            this.passenger = passenger;
        }
    }

    public String getMyDate() { return myDate; }

    public void setMyDate(String myDate) {
        if (!myDate.contains("/")) {
            throw new IllegalArgumentException();
        } else {
            this.myDate = myDate;
        }
    }

    public String getDestination() { return destination; }

    public void setDestination(String destination) {
        if (!destination.contains("C")) {
            throw new IllegalArgumentException();
        } else {
            this.destination = destination;
        }
    }
}
