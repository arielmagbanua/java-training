import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            int square = num * num;

            // sum = sum + square;
            sum += square;
        }

        System.out.print("Sum of square is " + sum);

        scanner.close();
    }
}
