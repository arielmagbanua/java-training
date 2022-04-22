import java.util.Scanner;

/**
 * This program asks user for numbers until user inputs 0.
 * It counts the number of positive and negative numbers and displays them after user inputs 0.
 *
 * @author TODO: PROVIDE YOUR NAME HERE
 * TODO: PROVIDE THE DATE
 */
public class Problem1 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // positive and negative counters;
        int positiveCount = 0;
        int negativeCount = 0;

        // loop until break conditions are met inside the while loop
        while(true) {
            // print prompt
            System.out.print("Enter a number: ");
            // get number input, convert it to int, and store it to variable
            int number = Integer.parseInt(scanner.nextLine().trim());

            if (number == 0) {
                // the input is zero therefore break the loop
                break;
            } else if (number > 0) {
                // number is positive so increment the positive count
                ++positiveCount;
            } else {
                // number is positive so increment the negative count
                ++negativeCount;
            }
        }

        // format the display text
        String displayText = String.format("Positive count: %d \nNegative count: %d", positiveCount, negativeCount);
        // print
        System.out.println(displayText);
    }
}
