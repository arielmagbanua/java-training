import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Department {
    private String name;
    private final List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public String toString() {
        // sort the employee by salary ascending
        employeeList.sort(Comparator.comparingDouble(Employee::calculateSalary));

        StringBuilder output = new StringBuilder("Department: " + name + "\n");

        for (Employee employee : employeeList) {
            String employeeOutput = String.format("%s\n", employee);
            output.append(employeeOutput);
        }

        // return the string representation of department and employees
        return output.toString();
    }
}
