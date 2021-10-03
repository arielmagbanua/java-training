public class ImmutableList extends IntegerList {
    public ImmutableList(int[] integers) {
        for (int integer : integers) {
            super.add(integer);
        }
    }

    @Override
    public void add(int integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int remove(int index) {
        throw new UnsupportedOperationException();
    }
}
