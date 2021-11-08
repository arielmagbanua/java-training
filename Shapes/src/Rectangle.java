public class Rectangle extends Shape {
    private XYCoord xyCoord;
    private double length;
    private double width;

    public Rectangle(XYCoord anchor, double length, double width) {
        super(anchor);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double circumference() {
        return 2 * (length + width);
    }
}
