public class Captain extends Pilot {
    private String flightAcademy;
    private double weeklyBonus;

    public Captain(String name, int ageOfService) {
        super(name, ageOfService);
    }

    public Captain(String name, int ageOfService, String flightAcademy) {
        super(name, ageOfService);

        this.flightAcademy = flightAcademy;
    }

    public String getFlightAcademy() {
        return flightAcademy;
    }

    public void setFlightAcademy(String flightAcademy) {
        this.flightAcademy = flightAcademy;
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public String toString() {
        // get the type name of the object
        String type = getClass().getTypeName();

        // return the formatted string that contains the type and properties
        return String.format(
                "Type: %s \nAcademy: %s \nName: %s \nAge of Service: %d \nSalary: %.2f \nWeekly Bonus: %.2f",
                type, getFlightAcademy(), getName(), getAgeOfService(), getSalary(), getWeeklyBonus()
        );
    }
}
