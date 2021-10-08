public class Pilot {
    private String name;
    private int ageOfService;
    protected double salary;

    public Pilot(String name, int ageOfService) {
        this.name = name;
        this.ageOfService = ageOfService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeOfService() {
        return ageOfService;
    }

    public void setAgeOfService(int ageOfService) {
        this.ageOfService = ageOfService;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 140000) {
            throw new IllegalArgumentException(
                    "Invalid salary for a pilot. All pilots should have greater than 140000 salary."
            );
        }

        this.salary = salary;
    }

    @Override
    public String toString() {
        // get the type name of the object
        String type = getClass().getTypeName();

        // return the formatted string that contains the type and properties
        return String.format("Type: %s \nName: %s \nAge of Service: %d \nSalary: %.2f", type, getName(), getAgeOfService(), getSalary());
    }
}
