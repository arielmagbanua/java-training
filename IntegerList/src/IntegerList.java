public abstract class IntegerList {
    public static final int MIN_CAPACITY = 2;

    private int[] array;
    private int size;

    public IntegerList() {
        array = new int[MIN_CAPACITY];
        size = array.length;
    }

    public IntegerList(int capacity) {
        // do not let capacity be less than the MIN_CAPACITY
        capacity = capacity >= MIN_CAPACITY ? capacity : MIN_CAPACITY;

        array = new int[capacity];
        size = array.length;
    }

    public boolean contains(int integer) {
        for (int num : array) {
            if (integer == num) {
                return true;
            }
        }

        return false;
    }

    public int get(int index) {
        return array[index];
    }

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

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void add(int integer) {
        ++size; // increase size since we are adding new integer

        // temporary variable to hold original array
        int[] temp = array;

        // create the new array with a new size
        array = new int[size];

        // transfer the original to the new sized list
        System.arraycopy(temp, 0, array, 0, temp.length);

        // append the new integer
        array[size - 1] = integer;
    }

    public void insert(int index, int integer) {
        array[index] = integer;
    }
}
