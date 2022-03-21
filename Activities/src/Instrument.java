public abstract class Instrument implements Comparable<Instrument> {
    protected double price;

    // default constructor
    public Instrument() {
    }

    // A one argument constructor
    public Instrument(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Instrument instrumentToCompare) {
        // returns 1, ‐1 or zero based on price.
        return Double.compare(this.price, instrumentToCompare.price);
    }

    public abstract String play();
}
