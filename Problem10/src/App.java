import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the input
        String inputs = scanner.nextLine();
        String[] inputNumbers = inputs.split(" ");

        int num1 = Integer.parseInt(inputNumbers[0]);
        int num2 = Integer.parseInt(inputNumbers[1]);
        int num3 = Integer.parseInt(inputNumbers[2]);

        if (num1 < num2 && num1 < num3) {
            if (num2 < num3) {
                System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                System.out.println(num1 + " " + num3 + " " + num2);
            }
        } else if (num2 < num1 && num2 < num3) {
            if (num1 < num3) {
                System.out.println(num2 + " " + num1 + " " + num3);
            } else {
                System.out.println(num2 + " " + num3 + " " + num1);
            }
        } else if (num3 < num1 && num3 < num2) {
            if (num1 < num2) {
                System.out.println(num3 + " " + num1 + " " + num2);
            } else {
                System.out.println(num3 + " " + num2 + " " + num1);
            }
        } else {
            System.out.println(num1 + " " + num2 + " " + num3);
        }

        scanner.close();
    }
}
