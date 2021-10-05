import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        int limit = 0;
        if (firstNum < secondNum) {
            limit = firstNum;
        } else {
            limit = secondNum;
        }

        int gcd = 0;
        for (int i = limit; i >= 2; i--) {
            if (firstNum % i == 0 && secondNum % i == 0) {
                gcd = i;
                break;
            }
        }

        System.out.println(gcd);

        scanner.close();
    }
}
