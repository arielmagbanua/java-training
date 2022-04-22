public class Client {
    private String name;
    private InsurancePolicy[] policies;

    public Client(String name, InsurancePolicy[] policies) {
        this.name = name;
        this.policies = policies;
    }

    public int getNumberOfPolicies() {
        return this.policies.length;
    }

    public InsurancePolicy getPolicy(int index) {
        if (index < 0 || index >= getNumberOfPolicies()) {
            // index out of bounds
            throw new IllegalArgumentException("Index provided is outside the bounds of the number of policies.");
        }

        return this.policies[index];
    }
}
