import java.util.Scanner;

public class SECTION_Surname_PT2_No7 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // use infinite while loop to continuously get a number and stops when the number is zero.
        while (true) {
            System.out.print("Enter a number: ");
            // get number input, convert it to int, and then store the value to a variable.
            int num = Integer.parseInt(scanner.nextLine());

            // check if zero
            if (num == 0) {
                // number is zero therefore break the loop
                break;
            }
        }
    }
}
