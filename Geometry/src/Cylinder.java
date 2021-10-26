public class Cylinder {
    // ADD YOUR INSTANCE VARIABLES HERE
    private double radius;
    private double height;

    /**
     * Creates a new cylinder of given height and radius.
     *
     * @param radius the radius
     * @param height the height
     */
    public Cylinder(double radius, double height) {
        // FILL IN
        this.radius = radius;
        this.height = height;
    }


    /**
     * Calculates the volume of a cylinder.
     *
     * @return the volume of the cylinder
     */
    public double getVolume() {
        return Geometry.cylinderVolume(this.radius, this.height);
    }


    /**
     * Calculates the surface area of the cylinder.
     *
     * @return the surface area of the cylinder
     */
    public double getSurface() {
        return Geometry.cylinderSurface(this.radius, this.height);
    }
}
