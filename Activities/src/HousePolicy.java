public class HousePolicy extends InsurancePolicy {
    private String address;

    public HousePolicy(String address) {
        super(); // call the super constructor
        this.address = address;
    }

    @Override
    public String getItemInsured() {
        return this.address;
    }
}
