import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input an integer. This will represent your age.
        int age = scanner.nextInt();

        // If the inputted age is greater than or equal to 18, print out "Adult".
        // Otherwise, print "Minor".
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }

        scanner.close();
    }
}
