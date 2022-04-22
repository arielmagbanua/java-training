import java.util.Random;
import java.util.Scanner;

/**
 * A math game that generates two random numbers between 1 and 50,
 * then asks the user for the division of those numbers.
 * After that, then program asks the user if he/she wishes to continue playing, y/n.
 * The game keeps on running until the user enters n.
 * After the user enters n, the game will display the number of wrong answers the user had,
 * out of the total number of answers.
 *
 * @author TODO: PROVIDE YOUR NAME HERE
 *  * TODO: PROVIDE THE DATE
 */
public class Problem2 {
    public static void main(String[] args) {
        // variable for minimum and maximum number to generate
        int max = 50;
        int min = 1;

        // variable for number of tries
        int numTry = 0;
        // variable for number of correct guess
        int correctGuess = 0;

        // variable for generating random number
        Random rand = new Random();

        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // loop until break conditions are met inside the while loop
        while (true) {
            // generate for numerator
            int numerator = rand.nextInt((max - min) + 1) + min;
            int divisor = rand.nextInt((max - min) + 1) + min;

            // print prompt
            System.out.print("Enter division: ");
            // get division input, convert it to double, and store it to variable
            double divisionInput = Double.parseDouble(scanner.nextLine());

            // calculate the division of random number
            double division = (double) numerator / (double) divisor;

            // increment the number of tries
            ++numTry;

            if (division == divisionInput) {
                // the user guessed it correctly
                ++correctGuess;
            }

            String inputContinue = yesOrNoInput("Continue playing (y/n)?: ", scanner);
            if (inputContinue.equalsIgnoreCase("n")) {
                // user says no so terminate the loop
                break;
            }
        }

        // format the display text
        String displayText = String.format("Total correct guess: %d \nTotal number of tries: %d", correctGuess, numTry);
        // print the result
        System.out.println(displayText);
    }

    /**
     * Ask user for "y" or "n" input. This method ensures and only accepts "y" or "n".
     *
     * @param prompt The message prompt
     * @param scanner Scanner instance for getting user input.
     * @return Either "y" or "n"
     */
    public static String yesOrNoInput(String prompt, Scanner scanner) {
        // loop until break conditions are met inside the while loop
        while (true) {
            // print the prompt
            System.out.print(prompt);

            // get user input
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                // user either inputted y or n, convert to lower case, and then return it immediately.
                return input.toLowerCase();
            }
        }
    }
}
