package week_6;

public class Employee
{
    int employeeID;
    String firstName;
    String lastName;
    int age;
    String title;
    public double salary;
    String status;

    public Employee(int employeeID)
    {
        this.employeeID =employeeID;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getAge() {
        return age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String code) {
        switch (code) {
            case "F":
                this.status = "Full-time";
                break;
            case "P":
                this.status = "Part-time";
                break;
            case "C":
                this.status = "contractor";
                break;
            case "I":
                this.status = "Intern";
                break;
            default:
                this.status = "Unknown";
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

}
