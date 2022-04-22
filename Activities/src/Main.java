import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("foo");
        testList.add("Hello World!");
        testList.add("Hello Earth!");
        testList.add("Hi");
        testList.add("Bar");
        testList.add("Java");

        // print the list before filtering
        System.out.println("Original List:");
        System.out.println(testList);

        // print after filtering or removing of strings that have more than 5 characters
        System.out.println("Filtered List:");
        testList = filterLongStrings(testList, 5);
        System.out.println(testList);
    }

    /**
     * Removes characters that exceed the specified character length.
     *
     * @param list The list to be filtered.
     * @param charLength The character length
     * @return The filtered list of strings
     */
    public static List<String> filterLongStrings(List<String> list, int charLength) {
        // create a list that will hold Strings with length less than the specified char length
        List<String> filtered = new ArrayList<>();

        // iterate over the list and add the strings that have length less than the char length given
        for (String item : list) {
            if (item.length() <= charLength) {
                // char length does not exceed the specified char length,
                // therefore add it to the filtered
                filtered.add(item);
            }
        }

        // finally, return the filtered list
        return filtered;
    }
}
