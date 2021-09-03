import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the inputs
        String num1Text = scanner.nextLine();
        String operator = scanner.nextLine();
        String num2Text = scanner.nextLine();

        // execute the operation
        if (operator.equals("+")) {
            try {
                int num1 = Integer.parseInt(num1Text);
                int num2 = Integer.parseInt(num2Text);
                int result = num1 + num2;
                System.out.println(result);
            } catch (NumberFormatException e) {
                float num1 = Float.parseFloat(num1Text);
                float num2 = Float.parseFloat(num2Text);
                float result = num1 + num2;
                String resultText = String.format("%.2f", result);
                System.out.println(resultText);
            }
        } else if (operator.equals("-")) {
            try {
                int num1 = Integer.parseInt(num1Text);
                int num2 = Integer.parseInt(num2Text);
                int result = num1 - num2;
                System.out.println(result);
            } catch (NumberFormatException e) {
                float num1 = Float.parseFloat(num1Text);
                float num2 = Float.parseFloat(num2Text);
                float result = num1 - num2;
                String resultText = String.format("%.2f", result);
                System.out.println(resultText);
            }
        } else if (operator.equals("*")) {
            try {
                int num1 = Integer.parseInt(num1Text);
                int num2 = Integer.parseInt(num2Text);
                int result = num1 * num2;
                System.out.println(result);
            } catch (NumberFormatException e) {
                float num1 = Float.parseFloat(num1Text);
                float num2 = Float.parseFloat(num2Text);
                float result = num1 * num2;
                String resultText = String.format("%.2f", result);
                System.out.println(resultText);
            }
        } else if (operator.equals("/")) {
            try {
                int num1 = Integer.parseInt(num1Text);
                int num2 = Integer.parseInt(num2Text);
                int result = num1 / num2;
                System.out.println(result);
            } catch (NumberFormatException e) {
                float num1 = Float.parseFloat(num1Text);
                float num2 = Float.parseFloat(num2Text);
                float result = num1 / num2;
                String resultText = String.format("%.2f", result);
                System.out.println(resultText);
            }
        }

        scanner.close();
    }
}
