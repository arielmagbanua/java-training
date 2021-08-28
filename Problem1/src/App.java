import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Get a number input
        int num1 = scanner.nextInt();

        // test if positive or negative
        if (num1 > 0) {
            // if positive "Positive"
            System.out.println("Positive");
        } else {
            // if negative "Negative"
            System.out.println("Negative");
        }

        scanner.close();
    }
}
