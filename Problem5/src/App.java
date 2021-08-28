import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input four float numbers; they could be positive or negative.
        String numbersText = scanner.nextLine();
        String[] numbers = numbersText.split(" ");

        float firstNum = Float.parseFloat(numbers[0]);
        float secondNum = Float.parseFloat(numbers[1]);
        float thirdNum = Float.parseFloat(numbers[2]);
        float fourthNum = Float.parseFloat(numbers[3]);

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
