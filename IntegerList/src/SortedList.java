import java.util.Arrays;

/**
 * List that contains sorted numbers
 */
public class SortedList extends IntegerList {
    /**
     * Construct with default minimum capacity.
     */
    public SortedList() {
        super();
    }

    /**
     * Constructor with capacity
     *
     * @param capacity The capacity or length of the list.
     */
    public SortedList(int capacity) {
        super(capacity);
    }

    @Override
    public void insert(int index, int integer) {
        // since the list is sorted then insertion by index is not allowed since
        // it is not guaranteed that the integer is at the correct position
        throw new UnsupportedOperationException();
    }

    /**
     * Add the integer to the list but after that sort the list.
     *
     * @param integer The integer value to insert
     */
    @Override
    public void add(int integer) {
        super.add(integer);

        // get the integers and store them to temporary array.
        int[] temp = new int[size()];
        for (int i = 0; i < size(); i++) {
            temp[i] = get(i);
        }

        // sort the array
        Arrays.sort(temp);

        // replace the original items with sorted array.
        for (int i = 0; i < size(); i++) {
            super.insert(i, temp[i]);
        }
    }
}
