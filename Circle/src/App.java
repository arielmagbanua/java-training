import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();

        Circle circle = new Circle(radius);

        double circumference = circle.calculateCircumference();
        double area = circle.calculateArea();

        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);

        scanner.close();
    }
}
