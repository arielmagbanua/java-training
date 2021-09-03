import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input four float numbers; they could be positive or negative.
        float firstNum = scanner.nextFloat();
        float secondNum = scanner.nextFloat();
        float thirdNum = scanner.nextFloat();
        float fourthNum = scanner.nextFloat();

        float sum = 0.0f;

        if (firstNum < 0) {
            sum += firstNum;
        }

        if (secondNum < 0) {
            sum += secondNum;
        }

        if (thirdNum < 0) {
            sum += thirdNum;
        }

        if (fourthNum < 0) {
            sum += fourthNum;
        }

        String output = String.format("%.2f", sum);

        System.out.println(output);

        scanner.close();
    }
}
