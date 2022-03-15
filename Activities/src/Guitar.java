public class Guitar extends Instrument {
    protected int numberofStrings;

    // default constructor that calls the super constructor
    public Guitar() {
        super();
    }

    // two argument constructor that calls the one argument super constructor
    public Guitar(double price, int numberofStrings) {
        super(price);
        this.numberofStrings = numberofStrings;
    }

    @Override
    public String play() {
        return "o I'm a Guitar WaWaWaWa I have 6 strings.";
    }
}
