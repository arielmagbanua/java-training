// Description: Starter Code / Sample Solution Exercise 05
// Starter Code Note: Use the pseudocode and complete the reset and run methods

import java.util.Random;
/*
 * Supervisor wants a comment here overviewing the class
 */
public class HighLowGame {
    private User user = new User(); // internal only, no get/set
    private Random random = new Random(); // internal only, no get/set
    private int fuelAvailable;
    private int numberToGuess;
    private static final int MIN = 1; // internal only, no get/set
    private static final int MAX = 10; // internal only, no get/set

    /*
     * No argument constructor, calls method reset to initialize the game
     */
    public HighLowGame() {
        reset();
    }
    /*
     * Accessor for fuelAvailable
     */
    public int getFuelAvailable() {
        return fuelAvailable;
    }
    /*
     * Mutator for fuelAvailable
     */
    public void setFuelAvailable(int fuelAvailable) {
        this.fuelAvailable = fuelAvailable;
    }
    /*
     * Access for numberToGuess
     */
    public int getNumberToGuess() {
        return numberToGuess;
    }
    /*
     * Mutator for numberToGuess
     */
    public void setNumberToGuess(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }
    /*
     * Supervisor wants comments overviewing the method
     */
    public void reset() {
        int sum = 0;

        // radom.nextInt(MAX) returns a value from 0 to (MAX -1)
        // so add 1 to get a number between 1 to MAX inclusive
        this.numberToGuess = this.random.nextInt(MAX) + 1;

        for (int value = MIN; value <= MAX; value++) {
            sum += value;
        }

        this.fuelAvailable = sum / 2;
    }
    /*
     * Supervisor wants comments overviewing the method
     */
    public void run() {
        CheckGuessResult checkGuessResult = null;
        String message = "";
        boolean isWon = false;
        int guessCount = 0;
        int userNumber;

        System.out.println("Guess the number from " + MIN + " to " + MAX);
        System.out.println("You have " + this.fuelAvailable + " guess-fuel remaining.");

        while (this.fuelAvailable > 0 && !isWon) {
            guessCount = guessCount + 1;
            userNumber = user.inputInteger("guess: ");

            // first loop control variable adjustment
            this.fuelAvailable = this.fuelAvailable - userNumber;

            // let them have this last play, but prevent negative
            // fuel values in the output
            if (this.fuelAvailable < 0) {
                this.fuelAvailable = 0;
            }

            checkGuessResult = checkGuess(userNumber);

            // second loop control variable adjustment
            isWon = checkGuessResult.isWin();

            message = checkGuessResult.getMessage();

            // in game messaging
            System.out.println(message);
        }

        message = this.reportGameResult(isWon, guessCount);
        // after game report
        System.out.println(message);
    }
    /*
     * This method examines the guess to see if it matches the numberToGuess
     * value. To report win or no-win, with a message as well a CheckGuessResult
     * instance is created with these results, and the reference to the
     * CheckGuessResult object is returned.
     */
    private CheckGuessResult checkGuess(int guess) {
        boolean isWin = false;
        String message;

        if (guess == numberToGuess) {
            message = "You guessed the number";
            isWin = true;
        }
        else {
            if(guess < numberToGuess) {
                message = "too low, ";
            } else {
                message = "too high, ";
            }
            message = message + String.format("%d guess-fuel remaining", this.fuelAvailable);
        }
        CheckGuessResult checkGuessResult = new CheckGuessResult(message, isWin);
        return checkGuessResult;
    }

    /*
     * This method writes out a final result of the game (win or lose) as well
     * as the number of guesses used by the player (i.e. the user).
     */
    private String reportGameResult(boolean isWon, int guessCount) {
        String message;
        if(isWon) {
            message = "You win! It took you ";
        } else {
            message = "You did not win, you used ";
        }
        message = String.format(message + "%d guesses", guessCount);
        return message;
    }
}
