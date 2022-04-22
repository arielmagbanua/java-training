import java.util.Scanner;

public class SECTION_Surname_PT2_No2 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three numbers");

        System.out.print("First Number: ");
        // get the first number, convert it to int, and then store the value to a variable.
        int num1 = Integer.parseInt(scanner.nextLine());

        System.out.print("Second Number: ");
        // get the second number, convert it to int, and then store the value to a variable.
        int num2 = Integer.parseInt(scanner.nextLine());

        System.out.print("Third Number: ");
        // get the third number, convert it to int, and then store the value to a variable.
        int num3 = Integer.parseInt(scanner.nextLine());

        // determine the larges number
        int largest = 0;
        if (num1 > num2 && num1 > num3) {
            largest = num1;
        } else if (num2 > num1 && num2 > num3) {
            largest = num2;
        } else if (num3 > num1 && num3 > num2) {
            largest = num2;
        }

        // print the result
        System.out.println("Largest number is " + largest);
    }
}
