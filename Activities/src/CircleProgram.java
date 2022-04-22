import java.util.Scanner;

public class CircleProgram {
    public static void main(String[] args) {
        // get radius input, convert to double, and store in the variable
        double radius = Double.parseDouble(getUserInput("Radius: "));
    }

    /**
     * Get the user input using a scanner.
     *
     * @param prompt The message prompt.
     * @return Returns the user input as string.
     */
    public static String getUserInput(String prompt) {
        // scanner for inputs
        Scanner scanner = new Scanner(System.in);

        // print prompt
        System.out.print(prompt);
        // get the input, trim the spaces, and then return the input
        return scanner.nextLine().trim();
    }


}
