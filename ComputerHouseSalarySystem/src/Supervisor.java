import java.util.Date;

public class Supervisor extends Employee {
    private int yearsOfExperience;

    public Supervisor(String id, String name, String position, Date dateOfBirth, int yearsOfExperience) {
       super(id, name, position, dateOfBirth);

       this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateSalary() {
        // base salary plus 3%
        double additional = (getBaseSalary() * (3.0 / 100.0));
        double salary = getBaseSalary() * (double) yearsOfExperience;

        // return the salary plus the 3%
        return salary + additional;
    }
}
