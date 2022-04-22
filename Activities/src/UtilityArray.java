import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UtilityArray<R> {
    public static final int DEFAULT_CAPACITY = 10;
    private R [] uA;

    public UtilityArray(){
        uA = (R[]) new Object [DEFAULT_CAPACITY];
    }

    public UtilityArray(int size){
        uA = (R[]) new Object[size];
    }

    public UtilityArray(UtilityArray<? extends R> collection) throws IllegalArgumentException {
        if (collection == null) {
            // collection is null therefore throw an IllegalArgumentException
            throw new IllegalArgumentException();
        }

        // iterate and check each item of the UtilityArray collection.
        for (int i = 0; i < collection.uA.length; i++) {
            R item = collection.uA[i];

            if (item == null) {
                // one of the item is null therefore IllegalArgumentException
                throw new IllegalArgumentException();
            }
        }

        // convert collection as set to remove duplicate values
        Set<R> set = new LinkedHashSet<>(Arrays.asList(collection.uA));

        // initialize the array using the length of the set if it will exceed the default capacity
        uA = (R[]) new Object [set.size() > DEFAULT_CAPACITY ? set.size() : DEFAULT_CAPACITY];

        // starting index of the array
        int i = 0;

        for (R item : set) {
            // assign the current item to the current index and then increment the index
            uA[i++] = item;
        }
    }
}
