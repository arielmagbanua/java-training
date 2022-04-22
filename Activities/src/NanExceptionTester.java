import java.util.Scanner;

public class NanExceptionTester {
    public static void main(String[] args) throws NanException {
        // scanner for getting inputs
        Scanner scanner = new Scanner(System.in);

        // get a from the user
        System.out.print("Enter value for a: ");
        // get the line input, convert it to int, and then store in the variable
        double a = Double.parseDouble(scanner.nextLine());

        // get b from the user
        System.out.print("Enter value for b: ");
        // get the line input, convert it to int, and then store in the variable
        double b = Double.parseDouble(scanner.nextLine());

        // get c from the user
        System.out.print("Enter value for c: ");
        // get the line input, convert it to int, and then store in the variable
        double c = Double.parseDouble(scanner.nextLine());

        // calculate b squared
        double bSquared = Math.pow(b, 2);
        // calculate 4ac
        double fourAC = 4 * a * c;

        if (fourAC > bSquared) {
            // this will result to negative square root since 4ac is greater than b squared
            // therefore throw the NanException here
            throw new NanException();
        }

        // calculate for x1
        double numeratorX1 = ((-1) * b) + Math.sqrt(bSquared - fourAC);
        double x1 = numeratorX1 / (2 * a);

        // calculate for x2
        double numeratorX2 = ((-1) * b) - Math.sqrt(bSquared - fourAC);
        double x2 = numeratorX2 / (2 * a);

        // print x1 and x2
        System.out.printf("x1: %s \nx2: %s", x1, x2);
    }
}
