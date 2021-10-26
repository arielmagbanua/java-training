public class Geometry {
    // (YOU SHOULD HAVE NO INSTANCE VARIABLES IN THIS CLASS)

    /**
     * Calculates the volume of a sphere.
     *
     * @param r the radius of the sphere
     * @return the volume of the sphere
     */
    public static double sphereVolume(double r) {
        return (4 * Math.PI * Math.pow(r, 3)) / 3;
    }


    /**
     * Calculates the surface area of a sphere.
     *
     * @param r the radius of the sphere
     * @return the surface area of the sphere
     */
    public static double sphereSurface(double r) {
        return 4 * Math.PI * Math.pow(r, 2);
    }


    /**
     * Calculates the volume of a cylinder.
     *
     * @param r the radius of the cylinder
     * @param h the height of the cylinder
     * @return the volume of the cylinder
     */
    public static double cylinderVolume(double r, double h) {
        return Math.PI * Math.pow(r, 2) * h;
    }


    /**
     * Calculates the surface area of a cylinder.
     *
     * @param r the radius of the sphere
     * @return the surface area of the cylinder
     */
    public static double cylinderSurface(double r, double h) {
        return (2 * Math.PI * r * h) + (2 * Math.PI * Math.pow(r, 2));
    }


    /**
     * Calculates the volume of a cone.
     *
     * @param r the radius of the base of the cone
     * @param h the height of the cone
     * @return the volume of the cone
     */
    public static double coneVolume(double r, double h) {
        return Math.PI * Math.pow(r, 2) * (h / 3);
    }


    /**
     * Calculates the surface area of a cone.
     *
     * @param r the radius of the base of the cone
     * @param h the height of the cone
     * @return the surface area of the cone
     */
    public static double coneSurface(double r, double h) {
        // get the length of side, just a simple pythagorean theorem
        double lengthOfSide = Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2));

        // calculate and return the area
        return Math.PI * r * (r + lengthOfSide);
    }
}
