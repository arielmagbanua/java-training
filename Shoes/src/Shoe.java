public class Shoe {
    private String color;
    private int size;
    private String brand;

    public Shoe(String color, int size, String brand) {
        this.color = color;
        this.size = size;
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * The string representation of shoe for printing.
     *
     * @return The string that represents this shoe
     */
    @Override
    public String toString() {
        return String.format("color: %s size: %d; brand: %s", color, size, brand);
    }
}
