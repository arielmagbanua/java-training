public class Employee {
    private int id;
    private String name;
    private double payRate;
    private double hoursWorked;
    private int daysEmployed;
    static int idGen = 0;

    /**
     * @param name
     * @param payRate
     * @param hoursWorked
     * @param daysEmployed
     */
    public Employee(String name, double payRate, double hoursWorked, int daysEmployed) {
        this.name = name;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.daysEmployed = daysEmployed;
        idGen++;
        id = idGen;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if(name.length()>0)
            this.name = name;
    }

    /**
     * @return the payRate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * @param payRate the payRate to set
     */
    public void setPayRate(double payRate) {
        if(payRate>=0)
            this.payRate = payRate;
    }

    /**
     * @return the hoursWorked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @param hoursWorked the hoursWorked to set
     */
    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked >=0 && hoursWorked <=80)
            this.hoursWorked = hoursWorked;
    }

    /**
     * @return the daysEmployed
     */
    public int getDaysEmployed() {
        return daysEmployed;
    }

    /**
     * @param daysEmployed the daysEmployed to set
     */
    public void setDaysEmployed(int daysEmployed) {
        this.daysEmployed = daysEmployed;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public boolean isProvisional() {
        if (daysEmployed <= 90) {
            return true;
        } else {
            return false;
        }
    }
}
