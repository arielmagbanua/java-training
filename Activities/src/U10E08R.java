import java.util.ArrayList;
import java.util.Scanner;

/**
 * A table for lookups and reverse lookups
 */
public class U10E08R {
    private ArrayList<U10E08Item> people;

    /**
     * Constructs a LookupTable object.
     */

    public U10E08R() {
        people = new ArrayList<U10E08Item>();
    }

    /**
     * Reads key/value pairs.
     * <p>
     * atparam in the scanner for reading the input
     */
    public void read(Scanner in) {
        while (in.hasNext()) {
            String name = in.nextLine();
            String number = in.nextLine();
            people.add(new U10E08Item(name, number));
        }
    }

    /**
     * Looks up an item in the table.
     * <p>
     * atparam k the key to find
     * <p>
     * atreturn the value with the given key, or null if no
     * <p>
     * such item was found.
     */
    public String lookup(String k) {
        String output = null;

        for (U10E08Item item : people) {
            if (k.equals(item.getName())) {
                output = item.getNumber();
            }
        }

        return output;
    }

    /**
     * Looks up an item in the table.
     * <p>
     * atparam v the value to find
     * <p>
     * atreturn the key with the given value, or null if no
     * <p>
     * such item was found.
     */

    public String reverseLookup(String v) {
        String output = null;

        for (U10E08Item item : people) {
            if (v.equals(item.getNumber())) {
                output = item.getName();
            }
        }

        return output;
    }
}
