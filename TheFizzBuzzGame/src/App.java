import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        
        if (num % 3 == 0 && num % 5 != 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0 && num % 3 != 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0 && num % 3 == 0) {
            System.out.println("FizzBuzz");
        }

        scanner.close();
    }
}
