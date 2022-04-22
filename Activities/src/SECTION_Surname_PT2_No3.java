import java.util.Scanner;

public class SECTION_Surname_PT2_No3 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // declare int array of length = 5
        int[] numbers = new int[5];

        // loop 5 times, starting at 1 to 5
        for (int i = 0; i < 5; i++) {
            if ((i + 1) == 1) {
                // print 1st prompt
                System.out.print("1st Number: ");
            } else if ((i + 1) == 2) {
                // print 2nd prompt
                System.out.print("2nd Number: ");
            } else if ((i + 1) == 3) {
                // print 3rd prompt
                System.out.print("3rd Number: ");
            } else {
                // print th prompt
                System.out.print(i + "th Number: ");
            }

            // get the integer, convert it to int, and then store the value to a variable.
            int integer = Integer.parseInt(scanner.nextLine());
            // store to the numbers array
            numbers[i] = integer;
        }

        // calculate the sum by looping through numbers array and adding each number
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // calculate average
        double average = (double) sum / numbers.length;

        // print the results
        System.out.println("SUM: " + sum);
        System.out.println("AVERAGE: " + average);
    }
}
