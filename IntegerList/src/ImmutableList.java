/**
 * The list that cannot be modified or changed.
 */
public class ImmutableList extends IntegerList {
    /**
     * The constructor which takes array of integers.
     *
     * @param integers The array / list of integers.
     */
    public ImmutableList(int[] integers) {
        for (int integer : integers) {
            super.add(integer);
        }
    }

    @Override
    public void add(int integer) {
        // since the list is immutable then this method is not allowed
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int index, int integer) {
        // since the list is immutable then this method is not allowed
        throw new UnsupportedOperationException();
    }

    @Override
    public int remove(int index) {
        // since the list is immutable then this method is not allowed
        throw new UnsupportedOperationException();
    }
}
