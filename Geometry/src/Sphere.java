public class Sphere {
    // ADD YOUR INSTANCE VARIABLES EHRE
    private double radius;

    /**
     * Creates a sphere of a given radius.
     *
     * @param radius the radius
     */
    public Sphere(double radius) {
        // FILL IN
        this.radius = radius;
    }


    /**
     * Calculates the volume of the sphere.
     *
     * @return the volume of the sphere.
     */
    public double getVolume() {
        return Geometry.sphereVolume(this.radius);
    }


    /**
     * Calculates the surface area of the sphere.
     *
     * @return the volume of the sphere.
     */
    public double getSurface() {
        return Geometry.sphereSurface(this.radius);
    }
}
