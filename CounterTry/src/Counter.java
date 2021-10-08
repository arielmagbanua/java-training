public class Counter {
    // instance variables here
    private int modulus;
    private Counter left;
    private int digit;

    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left = left;
    }

    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return left;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        // increment the digit
        ++digit;

        if (digit >= modulus) {
            // digit has reached maximum value therefore reset it
            digit = 0;

            // counter rolled over here?
            // Let me know in the comments and provide some conditions or
            // scenario of rolled over.
            if (left != null) {
                // increment left neighbor as well
                left.increment();
            }
        }
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if (left == null) {
            // no left then count is the same as the digit
            return getDigit();
        }

        // if there is left neighbor the count
        // is the sum of digit of the counter and the modulus times
        // the count of left neighbor
        return getDigit() + (modulus * left.getCount());
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }
}
