/**
 * List that contains unique integers
 */
public class UniqueList extends IntegerList {
    /**
     * Construct with default minimum capacity.
     */
    public UniqueList() {
        super();
    }

    /**
     * Constructor with capacity
     *
     * @param capacity The capacity or length of the list.
     */
    public UniqueList(int capacity) {
        super(capacity);
    }

    /**
     * Inserts the item with the index but throws an exception if the integer already exists.
     *
     * @param index The index or position where the integer to insert.
     * @param integer The integer value to insert.
     */
    @Override
    public void insert(int index, int integer) {
        if (get(index) == integer) {
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_HERE_IN_COMPLIANCE_OF_UNIT_TEST");
        }

        super.insert(index, integer);
    }

    /**
     * Adds the item with the index but throws an exception if the integer already exists.
     *
     * @param integer The integer value to insert
     */
    @Override
    public void add(int integer) {
        if (contains(integer)) {
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_HERE_IN_COMPLIANCE_OF_UNIT_TEST");
        }

        super.add(integer);
    }
}
