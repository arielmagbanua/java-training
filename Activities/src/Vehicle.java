public abstract class Vehicle implements Product {
    private String name;
    private double cost;

    public Vehicle(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getCost() {
        return this.cost;
    }
}
