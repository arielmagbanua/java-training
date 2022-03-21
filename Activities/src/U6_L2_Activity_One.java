public class U6_L2_Activity_One {
    /**
     * This should return a boolean which is true if the parameter array contains only negative values,
     * and false otherwise.
     *
     * @param numbers The numbers to test.
     * @return True if all negative otherwise false.
     */
    public static boolean allNegative(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            // check if number is greater than or equal 0 (positive).
            if (numbers[i] >= 0) {
                // there is a number that is positive in numbers array
                // therefore return false immediately
                return false;
            }
        }

        // exhausted all numbers and there are no positive numbers
        // therefore return true
        return true;
    }
}
