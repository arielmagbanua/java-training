public class Manager extends Pilot {
    public Manager(String name, int ageOfService) {
        super(name, ageOfService);
    }

    @Override
    public void setSalary(double salary) {
        if (salary < 210000) {
            throw new IllegalArgumentException(
                    "Invalid salary for a manager. All managers should have greater than 210000 salary."
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
