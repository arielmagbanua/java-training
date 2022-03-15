public class Worker {
    private String name;
    private int workerId;
    private double wage;
    private boolean fullTime;

    public Worker(String myName, int myWorkerId, double myWage, boolean isFullTime) {
        this.name = myName;
        this.workerId = myWorkerId;
        this.wage = myWage;
        this.fullTime = isFullTime;
    }

    /**
     * Retrieves the name of the worker.
     *
     * @return The name of the worker
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the worker.
     *
     * @param name Worker name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the workerId.
     *
     * @return The worker id
     */
    public int getWorkerId() {
        return workerId;
    }

    /**
     * Sets the workerId.
     *
     * @param workerId The new worker id
     */
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    /**
     * Retrieves the wage of the worker.
     *
     * @return The wage of the worker
     */
    public double getWage() {
        return wage;
    }

    /**
     * Sets the wage of the worker.
     *
     * @param wage The new wage of the worker
     */
    public void setWage(double wage) {
        this.wage = wage;
    }

    /**
     * Retrieves the full-time status of the worker.
     *
     * @return Boolean status
     */
    public boolean isFullTime() {
        return fullTime;
    }

    /**
     * Sets the full-time status of the worker.
     *
     * @param fullTime Boolean status
     */
    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    /**
     * Prints the details of the worker
     */
    public void printDetails() {
        // build the detail that involves the name, worker id, and the wage
        String partialDetails = String.format(
                "The name of the worker is %s. The worker id is %d. The wage of the worker is $%.2f per hour. ",
                this.getName(),
                this.getWorkerId(),
                this.getWage()
        );

        // a message depending on if the worker is full-time or not.
        // use ternary operator to keep it in a single line
        String fullTimeDetails = this.isFullTime() ? "The worker is full-time" : "The employee is not full-time.";

        // complete and print the details by appending the two messages
        System.out.println(partialDetails + fullTimeDetails);
    }
}
