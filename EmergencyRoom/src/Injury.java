import java.util.HashMap;
import java.util.Map;

/**
 * Represents an injury that a patient may have
 *
 * (You've seen an enum before in Lab 4, here it is again, this time as its own "class"
 * with fields and methods)
 *
 */
public enum Injury {
    SEIZURE, HEMORRHAGE, CHEST_PAIN, BURN, FRACTURE, ABDOMINAL_PAIN, OTHER;

    // maps injuries to triage levels:
    private static final Map<Injury, Integer> triageTable = new HashMap<>();

    // This is called a static initialization block, and it is used to initialize static variables.
    // These statements are executed once when the class is loaded.
    // See p. 290 of the textbook, or google for more info
    static {
        triageTable.put(Injury.SEIZURE, 1);
        triageTable.put(Injury.HEMORRHAGE, 1);
        triageTable.put(Injury.CHEST_PAIN, 2);
        triageTable.put(Injury.BURN, 2);
        triageTable.put(Injury.FRACTURE, 3);
        triageTable.put(Injury.ABDOMINAL_PAIN, 3);
        triageTable.put(Injury.OTHER, 4);
    }

    /**
     * Returns the triage level corresponding to the given injury
     *
     * @param injury
     * @return the triage level corresponding to the given injury
     */
    public static int getTriageLevel(Injury injury) {
        return triageTable.get(injury); // FILL IN
    }
}
