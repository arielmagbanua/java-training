public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double len, double w) {
        this.length = len;
        this.width = w;
    }

    public Rectangle() {

    }

    public Rectangle(Rectangle rectangle) {
        this.length = rectangle.getLength();
        this.width = rectangle.getWidth();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            this.length = 0;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            this.width = 0;
        }
    }

    public double computeArea() {
        return this.getLength() * this.getWidth();
    }

    public double computePerimeter() {
        return 2 * (this.getLength() + this.getWidth());
    }

    @Override
    public String toString() {
        return String.format("The length is: %.2f \nThe width is: %.2f", this.getLength(), this.getWidth());
    }

    public void displayRectangle() {
        System.out.println(this);
    }

    public boolean equals(Rectangle other) {
        if (this == other) {
            // this instance is same instance as the other object, therefore return true.
            return true;
        }

        if (this.getLength() != other.getLength()) {
            // the length of this rectangle is not the same with other rectangle, therefore return false
            return false;
        }

        // returns true if the with of this rectangle is the same with the other rectangle, otherwise return false
        return this.getWidth() == other.getWidth();
    }
}
