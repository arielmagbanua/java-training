public class VehiclePolicy extends InsurancePolicy {
    private String vehicle;

    public VehiclePolicy(String vehicle) {
        super(); // call the super constructor
        this.vehicle = vehicle;
    }

    @Override
    public String getItemInsured() {
        return this.vehicle;
    }
}
