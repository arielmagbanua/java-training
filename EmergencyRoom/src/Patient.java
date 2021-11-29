/**
 * Class representing a patient in a hospital emergency room
 */
public class Patient implements Comparable<Patient> {
    // ADD YOUR INSTANCE VARIABLES HERE
    private Injury injury;
    private String description;

    /**
     * Creates a new Patient object with the given injury and description
     */
    public Patient(Injury injury, String description) {
        // FILL IN
        this.injury = injury;
        this.description = description;
    }

    public int getPriority() {
        return Injury.getTriageLevel(injury); // FIX ME
    }

    public Injury getInjury() {
        return injury; // FIX ME
    }

    public String getDescription() {
        return description; // FIX ME
    }

    @Override
    public int compareTo(Patient p) {
        return Integer.compare(this.getPriority(), p.getPriority()); // FIX ME
    }

    @Override
    public String toString() {
        return String.format("Injury: %s, Description: %s", injury, getDescription()); // FIX ME
    }
}
