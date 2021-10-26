public class Main {
    public static void main(String[] args) {
        // sphere test case
        Sphere sphere = new Sphere(5.0);
        System.out.println("Circle, r = " + 5);
        System.out.println("Volume: " + sphere.getVolume());
        System.out.println("Surface: " + sphere.getSurface());

        // cylinder test case
        Cylinder cylinder = new Cylinder(5.0, 10.0);
        System.out.println("Cylinder, r = " + 5 + ", height = " + 10);
        System.out.println("Volume: " + cylinder.getVolume());
        System.out.println("Surface: " + cylinder.getSurface());

        // code test case
        Cone cone = new Cone(5.0, 10.0);
        System.out.println("Cone, r = " + 5 + ", height = " + 10);
        System.out.println("Volume: " + cone.getVolume());
        System.out.println("Surface: " + cone.getSurface());
    }
}
