public class Tool implements Product, Comparable<Tool> {
    private String name;
    private double cost;

    public Tool(String name, double cost) {
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

    @Override
    public int compareTo(Tool o) {
        return Double.compare(this.getCost(), o.getCost());
    }
}
