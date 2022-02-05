import java.util.PriorityQueue;

public class EmergencyRoom {
    private PriorityQueue<Patient> patients;

    public EmergencyRoom() {
        // FILL IN
        patients = new PriorityQueue<>();
    }

    /**
     * Adds a patient to the ER queue with the given injury and description
     *
     * @param injury
     * @param description
     */
    public void addPatient(Injury injury, String description) {
        // FILL IN
        Patient patient = new Patient(injury, description);
        patients.add(patient);
    }

    /**
     * Gets the next highest priority patient
     */
    public Patient nextPatient() {
        return patients.poll(); // FIX ME
    }
}
