public class Cone {
    // ADD YOUR INSTANCE VARIABLES HERE
    private double radius;
    private double height;

    /**
     * Creates a cone of given radius and height.
     *
     * @param radius the radius
     * @param height the height
     */
    public Cone(double radius, double height) {
        // FILL IN
        this.radius = radius;
        this.height = height;
    }


    /**
     * Calculates the volume of the cone.
     *
     * @return the volume of the cone
     */
    public double getVolume() {
        return Geometry.coneVolume(this.radius, this.height);
    }


    /**
     * Calculates the surface area of the cone.
     *
     * @return the surface area of the cone
     */
    public double getSurface() {
        return Geometry.coneSurface(this.radius, this.height);
    }
}
