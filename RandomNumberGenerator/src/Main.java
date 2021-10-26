import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // create the random number generator with specific seed
        Random rng = new Random(100);

        // variable that holds user's input number
        int inputNumber = 0;

        // keep asking until user enters a number from a specified range
        while (inputNumber < 1 || inputNumber > 1000) {
            System.out.print("Enter a number (1 - 1000): ");
            inputNumber = scanner.nextInt();
        }

        // number of guesses
        int guesses = 0;

        // variable that indicates match has found
        boolean found = false;

        while (!found) {
            // the bound enables integer generation from 1 - 1000
            int randomNumber = rng.nextInt(1001);

            // if input and random is equal then we found the match
            found = inputNumber == randomNumber;

            if (found) {
                // print that it found a match
                System.out.printf("Found a match!\ninput number: %d\nrandom number: %d\n", inputNumber, randomNumber);
            }

            // increment number of guesses per loop
            ++guesses;
        }

        System.out.printf("Guesses: %d",guesses);

        scanner.close();
    }
}
