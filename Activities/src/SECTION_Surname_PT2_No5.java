import java.util.Scanner;

public class SECTION_Surname_PT2_No5 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st integer: ");
        // get 1st integer, convert it to int, and then store the value to a variable.
        int integer1 = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter 2nd integer: ");
        // get 2nd integer, convert it to int, and then store the value to a variable.
        int integer2 = Integer.parseInt(scanner.nextLine());

        // calculate the sum
        int sum = integer1 + integer2;
        // calculate the difference
        int difference = integer1 - integer2;
        // calculate the product
        int product = integer1 * integer2;
        // get the quotient
        int quotient = integer1 / integer2;
        // get the remainder
        int remainder = integer1 % integer2;

        // print the results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
