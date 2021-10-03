import java.util.Arrays;

public class SortedList extends IntegerList {
    public SortedList() {
        super();
    }

    public SortedList(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int integer) {
        super.add(integer);

        // get the integers and store them to temp
        int[] temp = new int[size()];
        for (int i = 0; i < size(); i++) {
            temp[i] = get(i);
        }

        // sort the array
        Arrays.sort(temp);

        // replace the original items with sorted
        for (int i = 0; i < size(); i++) {
            super.insert(i, temp[i]);
        }
    }

    @Override
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException();
    }
}
