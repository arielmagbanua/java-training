import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input a positive integer in one line. This will serve as the ending point of your loop.
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                // print Buzz if i is divisible by 3 only
                System.out.println("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                // print Buzz if i is divisible by 5 only
                System.out.println("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                // print Buzz if i is divisible both 3 and 5
                System.out.println("FizzBuzz");
            }
        }

        scanner.close();
    }
}
