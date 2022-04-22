import java.util.*;

public class WordCounting {
    public static void main(String[] args) {
        // create the list of Strings
        List<String> strings = new ArrayList<>();
        strings.add("Do");
        strings.add("and");
        strings.add("Do");
        strings.add("your");
        strings.add("in");
        strings.add("your");
        strings.add("exam");

        // declare the tree map to easily map occurrences
        Map<String, Integer> stringMap = new HashMap<>();

        // iterate to each words
        for (String string : strings) {
            if (stringMap.containsKey(string)) {
                // key already exist therefore increment the mapped integer
                int count = stringMap.get(string) + 1;
                // store back the count
                stringMap.put(string, count);
            } else {
                // not yet exist so insert 1 count for the given string
                stringMap.put(string, 1);
            }
        }

        // string builder for building display texts
        StringBuilder stringBuilder = new StringBuilder();
        // build the display text by iterating each key value pairs
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            String string = entry.getKey();
            int count = entry.getValue();
            stringBuilder.append(String.format("\"%s\"", string))
                    .append("=")
                    .append(count)
                    .append(", ");
        }

        // get the display string minus the last comma
        String displayText = stringBuilder.toString().trim();
        displayText = displayText.substring(0, displayText.length() - 1);
        // print
        System.out.println(displayText);

        // sort the keys by placing all key value pairs of hash map to a tree map
        // use custom comparator to alphabetically sort the keys
        Map<String, Integer> treeStringMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // convert the string to lower case to ignore character cases
                String firstString = o1.toLowerCase();
                String secondString = o2.toLowerCase();

                // compare the two string and return the result
                return firstString.compareTo(secondString);
            }
        });
        treeStringMap.putAll(stringMap);

        // string builder for building display texts
        stringBuilder = new StringBuilder();
        // build the display text by iterating each key value pairs
        for (Map.Entry<String, Integer> entry : treeStringMap.entrySet()) {
            String string = entry.getKey();
            int count = entry.getValue();
            stringBuilder.append(String.format("\"%s\"", string))
                    .append("=")
                    .append(count)
                    .append(", ");
        }

        // get the display string minus the last comma
        displayText = stringBuilder.toString().trim();
        displayText = displayText.substring(0, displayText.length() - 1);
        // print
        System.out.println(displayText);
    }
}
