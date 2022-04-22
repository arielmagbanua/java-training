import java.util.Scanner;

public class VaccineTest {
    public static void main(String[] args) {
        Vaccine vaccine1 = new Vaccine();

        // get the name of the vaccine
        String name = getUserInput("What is the name of this Vaccine? ");
        // get the doses and convert to int
        int doses = Integer.parseInt(getUserInput("How many needed doses of this Vaccine? "));
        // get authorized and convert it to boolean
        boolean authorized = Boolean.parseBoolean(getUserInput("Is it an Authorized Vaccine? (true or false) "));
        // create the second vaccine
        Vaccine vaccine2 = new Vaccine(name, doses, authorized);

        // print the vaccine objects
        System.out.println("The two Vaccines are: ");
        System.out.println(vaccine1);
        System.out.println(vaccine2);

        // setup 1st vaccine
        System.out.println("\nLet's set up the 1st Vaccine ...");
        // get the name of the vaccine
        name = getUserInput("\tWhat is the name? ");
        doses = Integer.parseInt(getUserInput("\tHow many doses? "));
        authorized = Boolean.parseBoolean(getUserInput("\tIs it an Authorized Vaccine (true or false)? "));
        // set all properties of vaccine1
        vaccine1.setName(name);
        vaccine1.setDoses(doses);
        vaccine1.setAuthorized(authorized);

        // print vaccine 1
        System.out.println("Vaccine 1: "+ vaccine1);

        // print if they are both equal
        System.out.print("Are the 2 Vaccine objects equal? ");

        if (vaccine1.equals(vaccine2)) {
            // they are equal so print yes
            System.out.println("Yes");
        } else {
            // they are not equal so print no
            System.out.println("No");
        }

        // print if they are both authorized
        System.out.println("Are they both Authorized Vaccine? " + vaccine1.bothAuthorized(vaccine2));

        // set vaccine1 to authorized
        vaccine1.setAuthorized(true);

        // print if they are both authorized
        System.out.println("Now are they both Authorized Vaccine? " + vaccine1.bothAuthorized(vaccine2));

    }

    public static String getUserInput(String prompt) {
        // scanner for inputs
        Scanner scanner = new Scanner(System.in);

        // print prompt
        System.out.print(prompt);
        // get the input and trim the spaces
        String input = scanner.nextLine().trim();

        // return the input
        return input;
    }
}
