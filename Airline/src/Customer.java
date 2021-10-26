public class Customer {
    private String name;
    private String ssn;

    public Customer(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public Customer(Customer customer) {
        this.setName(customer.getName());
        this.setSsn(customer.getSsn());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return String.format("customer name: %s\nssm: %s", name, ssn);
    }
}
