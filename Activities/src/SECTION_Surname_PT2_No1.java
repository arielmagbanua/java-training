import java.util.Scanner;

public class SECTION_Surname_PT2_No1 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        // get the integer, convert it to int, and then store the value to a variable.
        int integer = Integer.parseInt(scanner.nextLine());

        // print the results depending on integer value
        if (integer > 0) {
            // integer is greater than 0 therefore it is positive.
            System.out.println("The number is POSITIVE.");
        } else if (integer < 0) {
            // integer is less than 0 therefore it is negative.
            System.out.println("The number is NEGATIVE.");
        } else {
            // integer is 0.
            System.out.println("The number is ZERO.");
        }
    }
}
