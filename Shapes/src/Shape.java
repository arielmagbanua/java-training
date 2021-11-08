public abstract class Shape {
    // anchor coordinates of the shape
    protected final XYCoord anchor;


    // even though this is an abstract class it still
    // has constructors and at least one of them is used
    // whenever a child class is instantiated
    public Shape(double x, double y){
        this( new XYCoord(x,y) );
    }

    public Shape(XYCoord anchor){
        this.anchor = anchor;
    }

    /** Computes and returns the area of this shape.
     *
     * @return the area of <code>this</code> shape.
     */
    public abstract double area();


    /** Computes and returns the circumference of this shape.
     *
     * @return the circumference of <code>this</code> shape.
     */
    public abstract double circumference();

    @Override
    public String toString(){
        return "Shape at " + this.anchor.toString();
    }
}
