// declare the FishFlushFuss class
public class FishFlushFuss {
    // number for fish
    private int fishNumber;
    // number for flush number
    private int flushNumber;
    // number for fuss Number
    private int fussNumber;

    /**
     * Constructor of FishFlushFuss class.
     *
     * @param fishNumber The fish number.
     * @param flushNumber The flush number.
     * @param fussNumber The fuss number.
     */
    public FishFlushFuss(int fishNumber, int flushNumber, int fussNumber) {
        this.fishNumber = fishNumber;
        this.flushNumber = flushNumber;
        this.fussNumber = fussNumber;
    }

    /**
     * The helper method for playGame()
     *
     * @param round The current round
     * @return The result of the specific round.
     */
    public String playRound(int round) {
        // checks the divisibility of the round number
        boolean isMultipleOfFish = round % fishNumber == 0;
        boolean isMultipleOfFlush = round % flushNumber == 0;
        boolean isMultipleOfFuss = round % fussNumber == 0;

        if (isMultipleOfFish && isMultipleOfFlush && isMultipleOfFuss) {
            return String.format("Round %d: flamingo\n", round);
        } else if (isMultipleOfFish && !isMultipleOfFlush && !isMultipleOfFuss) {
            // multiple of fish only
            return String.format("Round %d: fish\n", round);
        } else if (!isMultipleOfFish && isMultipleOfFlush && !isMultipleOfFuss) {
            // multiple of flush only
            return String.format("Round %d: flush\n", round);
        } else if (!isMultipleOfFish && !isMultipleOfFlush && isMultipleOfFuss) {
            // multiple of fuss only
            return String.format("Round %d: fuss\n", round);
        } else if (isMultipleOfFish && isMultipleOfFlush && !isMultipleOfFuss) {
            // both multiples of fish and flush, return the result who is the bigger number
            if (fishNumber > flushNumber) {
                return String.format("Round %d: fish\n", round);
            } else {
                return String.format("Round %d: flush\n", round);
            }
        } else if (isMultipleOfFish && !isMultipleOfFlush && isMultipleOfFuss) {
            // both multiples of fish and fuss, return the result who is the bigger number
            if (fishNumber > fussNumber) {
                return String.format("Round %d: fish\n", round);
            } else {
                return String.format("Round %d: fuss\n", round);
            }
        } else if (!isMultipleOfFish && isMultipleOfFlush && isMultipleOfFuss) {
            // both multiples of flush and fuss, return the result who is the bigger number
            if (flushNumber > fussNumber) {
                return String.format("Round %d: flush\n", round);
            } else {
                return String.format("Round %d: fuss\n", round);
            }
        }

        // not multiple of fish, flush, or fuss
        return String.format("Round %d: %d\n", round, round);
    }

    /**
     * returns a String representing the result of the entire game
     *
     * @param rounds The number of rounds
     * @return The total aggregated game results
     */
    public String playGame(int rounds) {
        // creates string builder to aggregate all the results
        StringBuilder results = new StringBuilder();

        for (int round = 1; round <= rounds; round++) {
            // append the result for each round
            results.append(playRound(round));
        }

        // convert the results in to one string.
        return results.toString();
    }

    /**
     * Retrieves the fish number.
     *
     * @return The fish numnber.
     */
    public int getFish() {
        return fishNumber;
    }

    /**
     * Retrieves the flush number.
     *
     * @return The flush number.
     */
    public int getFlush() {
        return flushNumber;
    }

    /**
     * Retrieves the fuss number.
     *
     * @return The fuss number.
     */
    public int getFuss() {
        return fussNumber;
    }
}
