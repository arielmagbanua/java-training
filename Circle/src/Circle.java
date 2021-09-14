public class Circle {
    private final double pi = 3.1416;
    private double radius = 0.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateCircumference() {
        // 2 * r * pi
        double circumference = 2 * radius * pi;
        return circumference;
    }

    public double calculateArea(){
        // pi * r ^ 2
        double area = pi * (radius * radius);
        return area;
    }
}
