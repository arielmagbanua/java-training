import java.util.ArrayList;
import java.util.List;

public class Generics<T> {
    public <T> int indexOf(List<T> list, T value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                // found the value therefore return the index
                return i;
            }
        }

        // at this point the passed value is not in the list
        return -1;
    }

    public static void main(String[] args) {
        // create the generics instance
        Generics<Integer> testGenerics = new Generics<>();

        // list to test
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(10);

        // search the index of 5
        int searchedIndex = testGenerics.indexOf(list, 5);
        // expected to be 2
        System.out.println(searchedIndex);
    }
}
