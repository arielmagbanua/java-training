//ToDo: Supervisor wants programmer comments (use /* */ comment)

import java.util.Scanner;

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class Assignment02 {

    /**
     * The main or entry point method of the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        LumberChecker lumberChecker = new LumberChecker();
        User user = new User();
        // (other variables as needed)
        String continueInput;

        do {
            // Prompt the user to enter the thickness, width, and length as
            // measured for a sample of dimensional lumber e.g.
            // "Enter dimensions for the 2x4x8 lumber as measured in inches"
            // "Expected values for dimensions in inches are"
            // "96.0 for length, 1.5 for thickness, 3.5 for width"
            System.out.println("Enter dimensions for the 2x4x8 lumber as measured in inches.");
            System.out.println("Expected values for dimensions in inches are: 96.0 for length, 1.5 for thickness, 3.5 for width.");
            // "Enter measured length:"
            double length = user.inputDouble("Enter measured length: ");
            // "Enter measured thickness:"
            double thickness = user.inputDouble("Enter measured thickness: ");
            // "Enter measured width:"
            double width = user.inputDouble("Enter measured width: ");

            // set the dimensions into an instance of DimensionalLumber
            DimensionalLumber dimensionalLumber = new DimensionalLumber(thickness, width, length);

            // use the toString method of class DimensionalLumber
            // to output the information for the lumber.
            System.out.println(dimensionalLumber);

            // Use the LumberChecker method to obtain a report regarding if the
            // lumber is within specifications for thickness, width, length
            // by passing the DimensionalLumber reference-value as an argument.
            String result = lumberChecker.validate(dimensionalLumber);
            // print out your name on screen
            System.out.println(result);

            // using a loop ask if there is more data to enter (yes, no) and continue
            // only if the user enters some form of yes
            // e.g. "YES" "yEs" "yeS" would be acceptable (any capitalization)
            // if yes, processing should repeat in outputting the menu as above.

            // you can use any decision structure or loop for this program,
            // however a for-loop is not recommended.

            continueInput = yesNoInputString("Continue (Yes/No)?: ");
        } while (continueInput.equalsIgnoreCase("yes"));
    }

    /**
     * Will ask user for yes or no input.
     *
     * @param message The prompt message.
     * @return Returns "yes" or "no"
     */
    public static String yesNoInputString(String message) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (true) {
            System.out.print(message);
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                return input;
            }
        }
    }
}
