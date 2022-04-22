import java.util.Scanner;

public class EyeglassShop {
    public static void main(String[] args) {
        // get the eyeglass type
        String eyeglassType = getUserInput("Enter the type of glasses you like to buy: ");

        // declare variable for total cost
        double totalCost = 0.0;

        // check if prescription glass
        if (eyeglassType.equalsIgnoreCase("p")) {
            // it is prescription glasses therefore set total cost to 40
            totalCost = 40.0;

            // get the coating and convert it to int
            int coating = Integer.parseInt(getUserInput("Enter the coating code: "));

            // check for additional cost for coating
            if (coating == 0) {
                // anti glare coating so add the additional cost of 12.5
                totalCost += 12.5;
            } else if (coating == 1) {
                // brown coating so add the additional cost of 9.99
                totalCost += 9.99;
            } else {
                // invalid coating, print the message, and return immediately to stop the code from executing the rest
                System.out.println("Invalid coating type code!");
                return;
            }
        } else if (eyeglassType.equalsIgnoreCase("n")) {
            // it is non-prescription glasses therefore set total cost to 25
            totalCost = 25.0;
        } else {
            // invalid eyeglass type, print the message, and return immediately to stop the code from executing the rest
            System.out.println("Invalid Type of glasses");
            return;
        }

        // print the total cost
        System.out.println("The total cost is $" + totalCost);
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
