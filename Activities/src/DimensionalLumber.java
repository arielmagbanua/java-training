/* This class models dimensional lumber with fields for thickness, width,
 * length all in inches. Note that a typical marketing for lumber would be
 * 2x4x8 meaning 2-inches by 4-inches by 8 feet, however the expected
 * measured dimensions would be 1.5 inches thick, by 3.5 inches wide,
 * by 96 inches long. Constants are provided to map common feet-lengths
 * to inches
 */
public class DimensionalLumber {
    // 12 inches per foot, so e.g. 8-feet times 12 inches is 96 inches.
    // 2"x4"x8'  ("is inches, 'is feet)
    public static final double EXPECTED_LENGTH = 96.0;
    public static final double EXPECTED_THICKNESS = 1.5;
    public static final double EXPECTED_WIDTH = 3.5;
    private double length; // Measured length in inches
    private double thickness; // Measured thickness in inches
    private double width; // Measured width in inches

    /*
     * No-argument constructor, sets dimensions to 1.5 x 3.5 x 96.0 for
     * common lumber size. i.e. 2"x4"x8'
     */
    public DimensionalLumber() {
        this(EXPECTED_THICKNESS, EXPECTED_WIDTH, EXPECTED_LENGTH);
    }

    /*
     * Overloaded constructor, sets dimensions as specified. The parameters
     * are ordered from left to right as
     * (double thickness, double width, double length)
     */
    public DimensionalLumber(double thickness, double width, double length) {
        this.thickness = thickness;
        this.width = width;
        this.length = length;
    }

    /*
     * Accessor for length, uses inches as unit of measure
     */
    public double getLength() {
        return length;
    }

    /*
     * Mutator for length, uses inches as unit of measure
     */
    public void setLength(double length) {
        this.length = length;
    }

    /*
     * Accessor for thickness, uses inches as unit of measure
     */
    public double getThickness() {
        return thickness;
    }

    /*
     * Mutator for thickness, uses inches as unit of measure
     */
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    /*
     * Accessor for width, uses inches as unit of measure
     */
    public double getWidth() {
        return width;
    }

    /*
     * Mutator for width, uses inches as unit of measure
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /*
     * Returns a String that represents the data held within this object.
     */
    public String toString() {
        String formatString;
        String result;

        formatString = "%s: thickness %.4f, width %.4f, length %.4f";
        result = String.format(formatString,
                "Dimensional Lumber", thickness, width, length);

        return result;
    }
}