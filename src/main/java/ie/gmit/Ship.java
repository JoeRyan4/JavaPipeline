package ie.gmit;
/*
    Ship class
    Joseph Ryan
    G00337523
 */
public class Ship {
    private String originPort;
    private String date;
    private String departureTime;
    private String price;

    public Ship() {
        this.originPort = "";
        this.date = "";
        this.departureTime = "";
        this.price = "";
    }

    public Ship(String originPort, String date, String departureTime, String price) {
        if ((originPort.length() < 3) || (!date.contains("/")) || (!departureTime.contains(":")) || (!price.contains("$"))) {
            throw new IllegalArgumentException();
        } else {
            this.originPort = originPort;
            this.date = date;
            this.departureTime = departureTime;
            this.price = price;
        }
    }

    public String getOriginPort() { return originPort; }

    public void setOriginPort(String originPort) {
        if (originPort.length() < 3) {
            throw new IllegalArgumentException();
        } else {
            this.originPort = originPort;
        }
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        if (!date.contains("/")) {
            throw new IllegalArgumentException();
        } else {
            this.date = date;
        }
    }

    public String getDepartureTime() { return departureTime; }

    public void setDepartureTime(String departureTime) {
        if (!departureTime.contains(":")) {
            throw new IllegalArgumentException();
        } else {
            this.departureTime = departureTime;
        }
    }

    public String getPrice() { return price; }

    public void setPrice(String price) {
        if (!price.contains("$")) {
            throw new IllegalArgumentException();
        } else {
            this.price = price;
        }
    }
}
