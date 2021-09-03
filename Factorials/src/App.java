import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input a positive integer.
        int num = scanner.nextInt();

        int product = 1;

        for (int i = 1; i <= num; i++) {
            // product = product * i;
            product *= i;
        }

        System.out.println(product);

        scanner.close();
    }
}
