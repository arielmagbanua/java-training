public class PolicyTest {
    public static void main(String[] args) {
        // vehicle policies
        VehiclePolicy fordRaptor = new VehiclePolicy("Ford Raptor");
        VehiclePolicy hondaCivic = new VehiclePolicy("Honda Civic");

        // house policy
        HousePolicy whiteHouse = new HousePolicy("White House");

        // create and populate the policy array
        InsurancePolicy[] policies = new InsurancePolicy[3];
        policies[0] = fordRaptor;
        policies[1] = hondaCivic;
        policies[2] = whiteHouse;

        // create the client
        Client client = new Client("John Smith", policies);

        // get the honda civic policy and print
        InsurancePolicy honda = client.getPolicy(1);
        System.out.println(honda.getItemInsured());
        // get the house policy and print
        InsurancePolicy house = client.getPolicy(2);
        System.out.println(house.getItemInsured());
        // get the ford raptor policy and print
        InsurancePolicy ford = client.getPolicy(0);
        System.out.println(ford.getItemInsured());

        // out of bounds
        InsurancePolicy policy = client.getPolicy(10);
    }
}
