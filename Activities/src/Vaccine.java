public class Vaccine {
    private String name;
    private int doses;
    private boolean isAuthorized;

    public Vaccine() {
        this.name = null;
        this.doses = 0;
        this.isAuthorized = false;
    }

    public Vaccine(String name, int doses, boolean isAuthorized) {
        this.name = name;
        this.doses = doses;
        this.isAuthorized = isAuthorized;
    }

    public String getName() {
        return name;
    }

    public int getDoses() {
        return doses;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    /**
     * Checks if this vaccine is both authorized with the given vaccine.
     *
     * @param o The other vaccine instance.
     * @return Returns true if this vaccine is both authorized with the given vaccine.
     */
    public boolean bothAuthorized(Vaccine o) {
        return this.isAuthorized() && o.isAuthorized();
    }

    /**
     * Determines if this vaccine instance is equal to the other.
     *
     * @param o The other vaccine instance
     * @return Returns true if this instance is equal to the other vaccine, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            // same instance object so return true immediately
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            // second object is null or the class name of this instance is not equal to the other object
            return false;
        }

        Vaccine vaccine = (Vaccine) o;

        if (getDoses() != vaccine.getDoses()) {
            // different dose therefore not equal and then return false
            return false;
        }

        if (isAuthorized() != vaccine.isAuthorized()) {
            // they are not both authorized, therefore not equal and then return false
            return false;
        }

        // return true if this instance object has the same name property with the other, otherwise return false
        return getName() != null ? getName().equals(vaccine.getName()) : vaccine.getName() == null;
    }

    /**
     * Calculates the hash code.
     *
     * @return The hash code of this object
     */
    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getDoses();
        result = 31 * result + (isAuthorized() ? 1 : 0);
        return result;
    }

    /**
     * The string representation of this vaccine.
     *
     * @return It returns the string representation of this vaccine instance
     */
    @Override
    public String toString() {
        // format the string and return it
        return String.format("The Vaccine of name %s has %s dose(s) and is Authorized is %s",
                getName(),
                getDoses(),
                isAuthorized()
        );
    }
}
