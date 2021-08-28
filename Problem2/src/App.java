import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input three integers and compute the cubes of each of them.
        String numbersText = scanner.nextLine();

        // split numbers
        String[] numbers = numbersText.split(" ");
        String firstNumber = numbers[0];
        String secondNumber = numbers[1];
        String thirdNumber = numbers[2];

        // conver the inputs to numbers
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int num3 = Integer.parseInt(thirdNumber);

        // cube the numbers
        int cubeNum1 = num1 * num1 * num1;
        int cubeNum2 = num2 * num2 * num2;
        int cubeNum3 = num3 * num3 * num3;

        // sum it
        int sum = cubeNum1 + cubeNum2 + cubeNum3;

        if (sum > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }

        scanner.close();
    }
}
