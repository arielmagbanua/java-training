public class Flight {
    private int flightNumber;
    private String destination;
    private Pilot pilot;
    private String date;

    public Flight() {
    }

    public Flight(int flightNumber, String destination, Pilot pilot, String date) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.pilot = pilot;
        this.date = date;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Flight number: %d \ndestination: %s \npilot: %s \ndate: %s", flightNumber, destination, pilot.getName(), date);
    }

    public Flight copy() {
        Flight flight = null;

        try {
            // clone the current instance
            flight = (Flight) super.clone();
        } catch (CloneNotSupportedException e) {
            // cannot clone therefore create new instance by supplying the properties
            flight = new Flight(this.flightNumber, this.destination, this.pilot, this.date);
        }

        return flight;
    }
}
