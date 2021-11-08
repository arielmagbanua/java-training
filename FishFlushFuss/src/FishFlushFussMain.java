import java.util.Scanner;

public class FishFlushFussMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // fish number input
        System.out.println("Enter an integer for your fish number.");
        System.out.println("Please enter a number greater than zero:");
        int fishNumberInput = scanner.nextInt();

        // flush number input
        System.out.println("Enter an integer for your flush number.");
        System.out.println("Please enter a number greater than zero that is not equal to the fish number:");
        int flushNumberInput = scanner.nextInt();
        if (fishNumberInput == flushNumberInput) {
            // flush number should not be equal to fish
            System.exit(0);
        }

        // flush number input
        System.out.println("Enter an integer for your fuss number.");
        System.out.println("Please enter a number greater than zero that is not equal to the fish or flush number:");
        int fussNumberInput = scanner.nextInt();
        if (fussNumberInput == fishNumberInput || fussNumberInput == flushNumberInput) {
            // fuss number should not be equal to fish or flush
            System.exit(0);
        }

        // rounds
        System.out.println("How many rounds would you like to play?");
        System.out.println("Please enter a number greater than zero:");
        int rounds = scanner.nextInt();

        // execute the game
        FishFlushFuss fishFlushFuss = new FishFlushFuss(fishNumberInput, flushNumberInput, fussNumberInput);
        // play game and get the results
        String results = fishFlushFuss.playGame(rounds);
        // print the results
        System.out.println(results);

        // close the scanner
        scanner.close();
    }
}
