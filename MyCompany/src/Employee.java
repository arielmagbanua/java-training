public class Employee {
    private String name;
    private String email;
    private String address;
    private String position;
    private int id = 0;

    public Employee(String name, String email, String address, String position) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.position = position;
    }

    public Employee(String name, String email, String address, String position, int id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * The string representation of this employee
     *
     * @return String representation
     */
    @Override
    public String toString() {
        String employee = String.format(
                "name: %s, email: %s, address: %s, position: %s",
                this.getName(), this.getEmail(), this.getAddress(), this.getPosition()
        );

        if (this.getId() > 0) {
            // prepend the id if employee has
            return "id: " + this.getId() + ", " + employee;
        }

        return employee;
    }
}
