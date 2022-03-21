public class Employee {
    private String name;
    private double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; // same instance so return true
        }

        if (o == null || getClass() != o.getClass()) {
            return false; // the object is null or not the same class so return false
        }

        // cast the object to employee
        Employee employee = (Employee) o;

        // check if same salary, if not same salary then return false
        if (Double.compare(employee.salary, salary) != 0) {
            return false;
        }

        // if not the same name return false otherwise return true
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    /**
     * Generate
     *
     * @return
     */
    @Override
    public int hashCode() {

        return name != null ? name.hashCode() : 0;
    }
}
