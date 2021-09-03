import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input three integers and compute the cubes of each of them.
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        // cube the numbers
        int cubeNum1 = num1 * num1 * num1;
        int cubeNum2 = num2 * num2 * num2;
        int cubeNum3 = num3 * num3 * num3;

        // sum it
        int sum = cubeNum1 + cubeNum2 + cubeNum3;

        if (sum > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }

        scanner.close();
    }
}
