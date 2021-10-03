public class UniqueList extends IntegerList {
    public UniqueList() {
        super();
    }

    public UniqueList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int integer) {
        if (contains(integer)) {
            // already exists
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_SHOWN_IN_UNIT_TESTS");
        }

        super.add(integer);
    }

    @Override
    public void insert(int index, int integer) {
        if (get(index) == integer) {
            // already exists
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_SHOWN_IN_UNIT_TESTS");
        }
    }
}
