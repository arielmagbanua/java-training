/**
 * The generic integer list class which will be extended
 * by other list types.
 */
public class IntegerList {
    /**
     * The minimum capacity or length of the list.
     */
    public static final int MIN_CAPACITY = 2;

    /**
     * Size of the list
     */
    private int size;

    /**
     * The list containing the integers
     */
    private int[] array;

    /**
     * Default constructor that uses the MIN_CAPACITY.
     */
    public IntegerList() {
        array = new int[0];
        size = MIN_CAPACITY;
    }

    /**
     * Constructor with capacity
     *
     * @param capacity The capacity or length of the list.
     */
    public IntegerList(int capacity) {
        // use the specified capacity if it is bigger than the minimum
        capacity = capacity > MIN_CAPACITY ? capacity : MIN_CAPACITY;

        array = new int[0];
        size = capacity;
    }

    /**
     * Checks if the integer is in the list.
     *
     * @param integer The integer value to look for
     * @return True if integer is in the list otherwise false
     */
    public boolean contains(int integer) {
        for (int num : array) {
            if (integer == num) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the integer by index.
     *
     * @param index The index of the integer.
     * @return The integer that corresponds the list.
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * Removed integer by index.
     *
     * @param index The index of the number to be removed.
     * @return The integer that was removed.
     */
    public int remove(int index) {
        // get the integer to be removed.
        int integerToRemove = array[index];

        // temporarily assign the original array.
        int[] temp = array;

        // prepare the new list reduced by one
        array = new int[--size];

        int indexRef = 0;

        // transfer the original integers except the removed
        for (int i = 0; i < temp.length; i++) {
            if (index != i) {
                array[indexRef++] = temp[i];
            }
        }

        return integerToRemove;
    }

    /**
     * Retrieves the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the string representation of the object.
     *
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Inserts the integer at the bottom of the list.
     *
     * @param integer The integer value to insert
     */
    public void add(int integer) {
        // temporary variable to hold original array
        int[] temp = array;

        // create the new array with a new size
        array = new int[temp.length + 1];

        // transfer the original to the new sized list
        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }

        // append the new integer
        array[array.length - 1] = integer;

        // update the size
        size = array.length;
    }

    /**
     * Inserts the array in the specific position or index.
     *
     * @param index The index or position where the integer to insert.
     * @param integer The integer value to insert.
     */
    public void insert(int index, int integer) {
        // create a temporary array to hold the original
        int[] temp = array;

        // since the array will grow create the new array
        array = new int[temp.length + 1];

        array[index] = integer;

        // copy all integers from start to the insertion index and move others forward
        for (int i = 0; i < array.length; i++) {
            if (i > index) {
                array[i] = temp[i - 1];
            } else if (i != index){
                array[i] = temp[i];
            }
        }

        size = array.length;
    }
}
