public class Circle extends Shape {
    private double radius;

    public Circle(XYCoord center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double circumference() {
        return 2 * Math.PI * radius;
    }
}
