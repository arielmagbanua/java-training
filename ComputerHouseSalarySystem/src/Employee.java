import java.util.Date;

public abstract class Employee {
    // The default base salary
    public static final double DEFAULT_BASE_SALARY = 16000;

    private String id;
    private String name;
    private String position;
    private Date dateOfBirth;
    private double baseSalary;

    public Employee() {
        baseSalary = DEFAULT_BASE_SALARY;
    }

    public Employee(String id, String name, String position, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        baseSalary = DEFAULT_BASE_SALARY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return String.format("Employee name: %s, Position: %s, Salary: %.2f", name, position, calculateSalary());
    }

    public abstract double calculateSalary();
}
