import java.util.Scanner;

public class HeronsFormula
{
    public static double calculateAreaByHeronFormula(double a, double b, double c) {
        // 4a^2b^2
        double firstTerm = 4.0 * Math.pow(a, 2) * Math.pow(b, 2);
        // (a^2+b^2-c^2)^2
        double secondTerm = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2), 2);
        // 4a^2b^2 - (a^2+b^2-c^2)^2
        double inner = firstTerm - secondTerm;

        // calculate area
        return (1.0 / 4.0) * Math.sqrt(inner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ask for the sides of triangle
        System.out.println("Please provide the sides of the triangle.");

        System.out.print("Side A: ");
        double sideA = scanner.nextDouble();
        System.out.print("Side B: ");
        double sideB = scanner.nextDouble();
        System.out.print("Side C: ");
        double sideC = scanner.nextDouble();
        double area = calculateAreaByHeronFormula(sideA, sideB, sideC);
        System.out.println("Area: " + area);
    }
}
