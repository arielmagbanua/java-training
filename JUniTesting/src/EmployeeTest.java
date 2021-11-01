import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    @Test
    public void testConstructor() {
        // create a new employee
        Employee employee = new Employee("John", 123.5, 8.0, 5);

        // assert if the constructor has successfully set the information of employee
        assertEquals("John", employee.getName());
        assertEquals(123.5, employee.getPayRate());
        assertEquals(8.0, employee.getHoursWorked());
        assertEquals(5, employee.getDaysEmployed());
    }

    @Test
    public void testName() {
        Employee employee = new Employee("John", 123.5, 8.0, 5);

        // test when name is blank. A Blank name will be ignored so name should be retained.
        employee.setName("");
        assertEquals("John", employee.getName());

        // set a valid name
        employee.setName("Juan");
        assertEquals("Juan", employee.getName());
    }

    @Test
    public void testPayRate() {
        Employee employee = new Employee("John", 123.5, 8.0, 5);

        // test negative pay rate. A negative pay rate is ignored so pay rate should be retained.
        employee.setPayRate(-12);
        assertEquals(123.5, employee.getPayRate());

        // test valid pay rates
        employee.setPayRate(100.15);
        assertEquals(100.15, employee.getPayRate());
        employee.setPayRate(0);
        assertEquals(0, employee.getPayRate());
    }

    @Test
    public void testHoursWorked(){
        Employee employee = new Employee("John", 123.5, 8.0, 5);

        // test negative hours worked. A negative hours worked is ignored so hours worked should be retained.
        employee.setHoursWorked(-12);
        assertEquals(8.0, employee.getHoursWorked());

        // test hours worked greater than 80. A hours worked greater than 80 is ignored so hours worked should be retained.
        employee.setHoursWorked(82);
        assertEquals(8.0, employee.getHoursWorked());

        // test valid hours worked
        employee.setHoursWorked(40.5);
        assertEquals(40.5, employee.getHoursWorked());
        employee.setHoursWorked(0);
        assertEquals(0, employee.getHoursWorked());
    }

    @Test
    public void testProvisional() {
        Employee employee = new Employee("John", 123.5, 8.0, 5);

        // test if days employed is less than 90. If days employed is less than 90 the employee is on provisional status
        employee.setDaysEmployed(85);
        // TODO: It might be better to use assertTrue like below but the requirements says assertEquals.
        // assertTrue(employee.isProvisional());
        assertEquals(true, employee.isProvisional());

        // if beyond 90, then the employee is not in provisional status anymore
        employee.setDaysEmployed(365);
        // TODO: It might be better to use assertFalse like below but the requirements says assertEquals.
        // assertFalse(employee.isProvisional());
        assertEquals(false, employee.isProvisional());
    }
}
