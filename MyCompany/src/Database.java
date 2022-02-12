import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {
    // TODO: Change this to your correct host example localhost
    private static final String HOST = "192.168.10.10";

    private final String databaseName;
    private final String user;
    private final String password;

    private Connection connection;

    public Database(String databaseName, String user, String password) {
        this.databaseName = databaseName;
        this.user = user;
        this.password = password;
    }

    protected Connection getConnection() throws SQLException {
        String dbURL = String.format("jdbc:mysql://%s/%s", HOST, this.databaseName);
        Properties credentials = new Properties();
        credentials.put("user", this.user);
        credentials.put("password", this.password);

        return DriverManager.getConnection(dbURL, credentials);
    }

    public int insertEmployee(Employee employee) {
        try {
            Connection connection = getConnection();

            // create statement
            Statement statement = connection.createStatement();

            // insert the employee
            String insertQuery = String.format(
                    "INSERT INTO Employee (emp_name, emp_email, emp_address, emp_position) VALUES ('%s', '%s', '%s', '%s')",
                    employee.getName(), employee.getEmail(), employee.getAddress(), employee.getPosition()
            );

            int result = statement.executeUpdate(insertQuery);

            // close the connection
            connection.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            Connection connection = getConnection();

            // create statement
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");
            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                String email = rs.getString("emp_email");
                String address = rs.getString("emp_address");
                String position = rs.getString("emp_position");

                employees.add(new Employee(name, email, address, position, id));
            }

            // close the connection
            connection.close();

            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public int updateEmployee(int employeeId, Employee newEmployeeData) {
        try {
            Connection connection = getConnection();

            // create statement
            Statement statement = connection.createStatement();

            // update query
            String updateQuery = String.format(
                    "UPDATE Employee SET emp_name='%s', emp_email='%s', emp_address='%s', emp_position='%s' WHERE emp_id=%d",
                    newEmployeeData.getName(), newEmployeeData.getEmail(), newEmployeeData.getAddress(), newEmployeeData.getPosition(), employeeId
                    );

            // execute the query
            int result = statement.executeUpdate(updateQuery);

            // close the connection
            connection.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteEmployee(int employeeId) {
        try {
            Connection connection = getConnection();

            // create statement
            Statement statement = connection.createStatement();

            // delete query
            String deleteQuery = String.format("DELETE FROM Employee WHERE emp_id = '%d'", employeeId);

            // execute the query
            int result = statement.executeUpdate(deleteQuery);

            // close the connection
            connection.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public Employee selectByName(String nameInput) {
        Employee employee = null;

        try {
            Connection connection = getConnection();

            // create statement
            Statement statement = connection.createStatement();

            // select query
            String selectQuery = "SELECT * FROM Employee WHERE emp_name LIKE '%" + nameInput + "%'";

            ResultSet rs = statement.executeQuery(selectQuery);

            // expects only one record so get the first match
            if (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                String email = rs.getString("emp_email");
                String address = rs.getString("emp_address");
                String position = rs.getString("emp_position");

                employee = new Employee(name, email, address, position, id);
            }

            // close the connection
            connection.close();

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
}
