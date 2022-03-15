public class Piano extends Instrument {
    protected int numberofKeys;

    // private member
    private String user = "Beethoven";

    // default constructor that calls the super constructor
    public Piano() {
        super();
    }

    // two argument constructor that calls the one argument super constructor
    public Piano(double price, int numberofKeys) {
        super(price);
        this.numberofKeys = numberofKeys;
    }

    @Override
    public String play() {
        return "o I'm a Piano TinkleTinkleTinkle I have 44 keys.";
    }
}