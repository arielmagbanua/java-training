import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if (num % 3 == 0 && num % 4 != 0) {
            System.out.println("Divisible by 3");
        } else if (num % 4 == 0 && num % 3 != 0) {
            System.out.println("Divisible by 4");
        } else if (num % 3 == 0 && num % 4 == 0) {
            System.out.println("Divisible by 3 and 4");
        } else {
            System.out.println("No Divisibility");
        }

        scanner.close();
    }
}
