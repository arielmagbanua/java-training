package mini2;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilities for working with arrays.
 */
public class ArrayAdventures {

    // disable instantiation
    private ArrayAdventures() { }
    /**
     * Remove an element at index pos from the array. All elements to the right
     of
     * the given position are shifted down, and the last cell of the array is
     filled
     * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
     * remove(arr, 2), arr should be [1, 10, 5, 7, 0]. If pos is out of bounds,
     the
     * method does nothing.
     *
     * @param arr the array from which to remove an element
     * @param pos the position at which the element should be removed
     */
    public static void remove(int[] arr, int pos)
    {
        // first check if index is out of bounds
        if (pos < 0 || pos > (arr.length - 1)) {
            // the position index exceeded the last index of the array, therefore do nothing
            return;
        }

        // create a temporary array with length minus 1 from the original array
        int[] temp = new int[arr.length - 1];

        // initialize tempIndex
        int tempIndex = 0;

        // copy each item from the original array except the target position index
        for (int i = 0; i < arr.length; i++) {
            // get the current number
            int currentNumber = arr[i];

            // set the current position of the original array to 0
            arr[i] = 0;

            if (i == pos) {
                // target index so skip it
                continue;
            }

            // assign the number to temp and increment the temp index
            temp[tempIndex++] = currentNumber;
        }

        // copy everything from temp
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }
    /**
     * Remove an element at index pos from the array. All elements to the left of
     * the given position are shifted up, and the first cell of the array is
     filled
     * with a zero. For example, if arr = [1, 10, 3, 5, 7], after invoking
     * removeAndShiftUp(arr, 2), arr should be [0, 1, 10, 5, 7]. If pos is out of
     * bounds, the method does nothing.
     *
     * @param arr the array from which to remove an element
     * @param pos the position at which the element should be removed
     */
    public static void removeAndShiftUp(int[] arr, int pos)
    {
        // first check if index is out of bounds
        if (pos < 0 || pos > (arr.length - 1)) {
            // the position index exceeded the last index of the array, therefore do nothing
            return;
        }

        // create a temporary array with length minus 1 from the original array
        int[] temp = new int[arr.length - 1];

        // initialize tempIndex
        int tempIndex = 0;

        // copy each item from the original array except the target position index
        for (int i = 0; i < arr.length; i++) {
            // get the current number
            int currentNumber = arr[i];

            // set the current position of the original array to 0
            arr[i] = 0;

            if (i == pos) {
                // target index so skip it
                continue;
            }

            // assign the number to temp and increment the temp index
            temp[tempIndex++] = currentNumber;
        }

        // copy everything from temp but start at index 1 since we remove one item
        System.arraycopy(temp, 0, arr, 1, temp.length);
    }
    /**
     * Removes all odd numbers from the array. You must maintain the order of all
     * the remaining elements in the array and shift them down, and pad the array
     * with zeros. For example, if arr = [1, -10, 3, 7, 4], after invoking
     * removeOddElements(arr), arr should become [-10, 4, 0, 0, 0].
     *
     * @param arr the array from which to remove the selected elements
     */
    public static void removeOddElements(int[] arr) {
        // prepare the ArrayList as temporary storage for even numbers
        List<Integer> temp = new ArrayList<>();

        // iterate through the original array and copy all even numbers to temp
        for (int i = 0; i < arr.length; i++) {
            // get the current number
            int currentNumber = arr[i];

            if (currentNumber % 2 == 0) {
                // it is event therefore add it to temp
                temp.add(currentNumber);
            }

            // set the current index to 0
            arr[i] = 0;
        }

        // add back the even numbers to original array
        int index = 0;
        for (int even : temp) {
            // assign the number to the original array and increment the index
            arr[index++] = even;
        }
    }
    /**
     * Finds the runs in the given array and returns a boolean array of the same
     * length indicating which elements are part of a run, where a run is defined
     * as a sequence of three or more adjacent repeated values.
     * For example, if arr = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1],
     * then arr contains two runs, 5 5 5 5 and 2 2 2, and the method would return a boolean array
     * [false, false, true, true, true, true, false, false, false, true, true, true, false].
     * @param arr the array in which to find the runs
     * @return a boolean array indicating the positions of the run(s)
     */
    public static boolean[] findRuns(int[] arr)
    {
        // prepare the array of boolean
        boolean[] result = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            try {
                // compare the next 2 values if equal to the current position
                if ((arr[i] == arr[i + 1] && arr[i] == arr[i + 2])) {
                    // set the current position to true and continue to the next position
                    result[i] = true;
                    continue;
                }

                // compare the previous 2 values if equal to the current position
                if ((arr[i] == arr[i - 1] && arr[i] == arr[i - 2])) {
                    // set the current position to true and continue to the next position
                    result[i] = true;
                    continue;
                }

                // compare if the current position is sandwiched between same values
                if (arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                    // set the current position to true and continue to the next position
                    result[i] = true;
                    continue;
                }

                // at this point values from either direction is not equal to the current position
                result[i] = false;
            } catch (IndexOutOfBoundsException e) {
                // ignore out of bounds exception
            }
        }

        return result;
    }
    /**
     * Removes all the runs in an array and then pads to the end of array with
     * zeros, where a run is defined as a sequence of three or more adjacent
     * repeated values. For example, if arr = [6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1],
     * then arr contains two runs, 5 5 5 5 and 2 2 2, and after invoking
     * removeRuns(arr) the resulting array would be [6, 2, 4, 4, 5, 1, 0, 0, 0, 0, 0, 0, 0]
     *
     * @param arr the array from which to remove the runs
     */
    public static void removeRuns(int[] arr) {
        // run the remove runs
        boolean[] runsResult = findRuns(arr);

        // prepare the ArrayList as temporary storage for numbers
        List<Integer> temp = new ArrayList<>();

        // now set each index to 0 in the original array depending on the runs result
        for (int i = 0; i < arr.length; i++) {
            if (!runsResult[i]) {
                // not a run copy it to the temporary array list
                temp.add(arr[i]);
            }

            // set the current index to 0
            arr[i] = 0;
        }

        // add back the numbers to original array
        int index = 0;
        for (int num : temp) {
            // assign the number to the original array and increment the index
            arr[index++] = num;
        }
    }
    /**
     * Returns a string representation of the given 2D array.
     * The format is demonstrated below. Each value is formatted
     * with a minimum width of 7 characters, for example,
     * {@code String.format("%7d", value); }
     * <p>
     * Example output:
     * <pre>
     * { 5, 56, 234235, 9867}
     * </pre>
     *
     * @param arr the given array
     * @return a string representation of the given array
     */
    public static String toString1D(int[] arr) {
        // string builder to build the final string
        StringBuilder builder = new StringBuilder();

        // loop through each item in the array
        for (int value : arr) {
            // format each number
            String formatted = String.format("%7d,", value);
            builder.append(formatted);
        }

        // build the string
        String result = builder.toString();

        // remove the last comma
        result = result.substring(0, result.length() -1);

        // return the final string enclosed with {}
        return String.format("{%s}", result);
    }
    /**
     * Extra Credit (5 Points)
     * <p>
     * Returns a string representation of the given 2D array.
     * The format is demonstrated below.
     * <p>
     * Example output:
     * <pre>
     * {{ 5, 56, 234235, 9867},
     * { 262, 39485, -10, 78},
     * { 56, 1, 9837, 8712},
     * { 87, -25, 0, 9820}}
     * </pre>
     *
     * @param arr the given array
     * @return a string representation of the given array
     */
    public static String toString2D(int[][] arr) {
        // string builder to build the final string
        StringBuilder builder = new StringBuilder();

        // loop each arrays
        for (int[] currentArr : arr) {
            // get the representation of each array using toString1D
            String rep = toString1D(currentArr);
            builder.append(rep + ",\n");
        }

        // build the string
        String result = builder.toString();

        // remove the last comma and new line
        result = result.substring(0, result.length() -2);

        // return the final string enclosed with {}
        return String.format("{%s}", result);
    }
    /**
     * Extra Credit (5 Points)
     * <p>
     * Exchanges the elements of one row with those in a different row in a given 2D
     * array. Each element remains in the same column. Assumes that all rows are the
     * same length and row indexes are in bounds.
     *
     * @param arr the array whose rows should be exchanged
     * @param row1 one of the rows to swap
     * @param row2 other row to swap
     */
    public static void swapRows(int[][] arr, int row1, int row2) {
        // store the rows to swap to temporary arrays
        int[] temp1 = arr[row1];
        int[] temp2 = arr[row2];

        // swap the rows
        arr[row1] = temp2;
        arr[row2] = temp1;
    }

    /**
     * Extra Credit (5 Points)
     * <p>
     * Returns true if the given array of indexes represent values
     * in an increasing order.
     * <p>
     * The elements of the array <b>indexes</b> are indented to be
     * used as indexes into the array <b>values</b>.
     * <p>
     * For example, if values={44, 70, 28, 91, 10} and indexes={0, 1, 2}
     * then the selected values are {44, 70, 28}. These values
     * are not in increasing order so the method returns false.
     * <p>
     * On the other hand, if indexes={4, 2, 3} the selected values are
     * {10, 28, 91}. These values are in increasing order so the
     * method return true.
     * <p>
     * Assumes that all indexes are in bounds of the values array.
     * If indexes is empty the method returns true.
     *
     * @param values an array of values
     * @param indexes an array of element that are to be
     * @return a string representation of the given array
     */
    public static boolean isIncreasing(int[] values, int[] indexes) {
        // create temp array based on the number of indexes
        int[] temp = new int[indexes.length];

        // starting index
        int i = 0;

        // store the numbers for the given indexes
        for (int index : indexes) {
            temp[i++] = values[index];
        }

        // loop from 0 to the second last index
        for (int j = 0; j < temp.length - 1; j++) {
            if (temp[j] > temp[j + 1]) {
                // the current number is greater than the next so not increasing
                return false;
            }
        }

        // at this point numbers are increasing
        return true;
    }
}
