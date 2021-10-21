public class Rectangle implements Comparable<Rectangle> {
    private String name;
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("%s   %d", name, area());
    }

    /**
     * Compare to method, which will be used for sorting rectangle based on area
     * in descending order.
     *
     * @param rectangle The rectangle instance to compare to
     * @return Returns the result calculation, if the other rectangle is bigger than the current rectangle then return 1,
     * if the other rectangle less than the current rectangle return -1.
     * If both equal return 0.
     */
    @Override
    public int compareTo(Rectangle rectangle) {
        if(area() == rectangle.area())
            return 0;
        else if(area() < rectangle.area())
            return 1;
        else
            return -1;
    }
}
