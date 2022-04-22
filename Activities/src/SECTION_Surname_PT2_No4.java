import java.util.Scanner;

public class SECTION_Surname_PT2_No4 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        // get number input, convert it to int, and then store the value to a variable.
        int integer = Integer.parseInt(scanner.nextLine());

        // loop starting from 1 up to the integer input
        for (int i = 1; i <= integer; i++) {
            // then loop from 1 up to the i
            for (int j = 1; j <= i; j++) {
                // print j
                System.out.print(j);
            }

            // print new line after each main loop
            System.out.println();
        }
    }
}
