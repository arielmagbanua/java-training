public abstract class InsurancePolicy {
    public static int nextId = 1;
    private int id;

    public InsurancePolicy() {
        this.id = nextId;

        // increment for the next policy id
        ++nextId;
    }

    public int getId() {
        return id;
    }

    abstract public String getItemInsured();
}
