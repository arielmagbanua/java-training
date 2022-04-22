public class PreStudent implements Comparable<PreStudent> {
    private String lastName;
    private String firstName;
    private int id;

    public PreStudent(String first, String last, int studentID) {
        this.lastName = last;
        this.firstName = first;
        this.id = studentID;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    /**
     * Calculates the hash code for this object which will be used in maps and hashes.
     *
     * @return Returns the hash code of this object
     */
    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + getId();
        return result;
    }

    /**
     * Compares this student to other student. This is being used for sorting students in TreeMap.
     *
     * @param o The other student
     * @return Compare result
     */
    @Override
    public int compareTo(PreStudent o) {
        int lastNameCompareResult = this.getLast().compareTo(o.getLast());
        if (lastNameCompareResult != 0) {
            // last names are not equal, so return the result immediately
            return lastNameCompareResult;
        }

       int firstNameCompareResult = this.getFirst().compareTo(o.getFirst());
        if (firstNameCompareResult != 0) {
            return firstNameCompareResult;
        }

        // at this point since both names are equal therefore compare the id next
        return Integer.compare(this.getId(), o.getId());
    }

    /**
     * Returns the string representation of this student.
     *
     * @return Returns the string representation of this student
     */
    @Override
    public String toString() {
        // format last name to 12 characters including padding
        String lastName = this.getLast() + " ".repeat(15);
        lastName = lastName.substring(0, 12);


        // format first name to 12 characters including padding
        String fistName = this.getFirst() + " ".repeat(15);
        fistName = fistName.substring(0, 12);

        // format first name to 12 characters including padding
        String id = this.getId() + " ".repeat(15);
        id = id.substring(0, 12);

        // format and return
        return String.format("%s%s%s", lastName, fistName, id);
    }
}
