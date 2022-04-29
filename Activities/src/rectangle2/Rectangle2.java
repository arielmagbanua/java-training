package rectangle2;

public class Rectangle2 {
    private double length, width;

    // default constructor
    public Rectangle2() {
        setLength(1.0);
        setWidth(1.0);
    }

    // parameterized constructor
    public Rectangle2(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    // setter
    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be between 0.0 and 20.0");
        }
    }

    //getter
    public double getLength() {
        return length;
    }

    //setter
    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be between 0.0 and 20.0");
        }
    }

    // getter
    public double getWidth() {
        return width;
    }

    // return perimeter
    public double calculatePerimeter() {
        return ((length * 2) + (width * 2));
    }

    // return area
    public double calculateArea() {
        return (length * width);
    }

    public void display() {
        System.out.println("Rectangle Length: " + length + " Width: " + width + " Area: " + calculateArea() + " Perimeter: " + calculatePerimeter());
    }
}
