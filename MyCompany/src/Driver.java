import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // a. Insert a new Employee into the table
        System.out.println("a. Insert a new Employee into the table");
        Database db = new Database("my_company", "homestead", "secret");
        int rowsAffected = db.insertEmployee(new Employee("Xerxes Doe", "john@strose.edu", "Test Street, Albany, NY", "Coder"));
        System.out.println("rows affected: " + rowsAffected);
        printAllEmployees(db);

        // b. Update an existing Employee in the table
        System.out.println("b. Update an existing Employee in the table");
        // update the first employee
        List<Employee> employees = db.getAllEmployees();
        Employee firstEmployee = employees.get(0);
        rowsAffected = db.updateEmployee(
                firstEmployee.getId(),
                new Employee(firstEmployee.getName(), "test@test.com", "test address, NY", "None")
                );
        System.out.println("rows affected: " + rowsAffected);
        printAllEmployees(db);

        // c. Select All Employees from the table
        System.out.println("c. Select All Employees from the table");
        printAllEmployees(db);

        // d. Delete an Employee from the table
        System.out.println("d. Delete an Employee from the table");
        employees = db.getAllEmployees();
        Employee secondEmployee = employees.get(1);
        // execute delete
        int deleted = db.deleteEmployee(secondEmployee.getId());
        System.out.println("rows deleted: " + deleted);
        printAllEmployees(db);

        // e. Select and Employee from the table using en Employee name from user input
        System.out.println("e. Select and Employee from the table using en Employee name from user input");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        Employee employee = db.selectByName(name);
        System.out.println(employee);
    }

    public static void printAllEmployees(Database db) {
        // output the contents of database
        List<Employee> employees = db.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
