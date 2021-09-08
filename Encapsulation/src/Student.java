public class Student {
    // attributes
    private String firstName;
    private String lastName;
    private String idNumber;
    private String major;

    // Sets the id number of the student
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    // Sets the first name of the student
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Sets the last name of the student
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Sets the major of the student
    public void setMajor(String major) {
        this.major = major;
    }

    // Retrieves the id number of the student
    public String getIdNumber() {
        return idNumber;
    }

    // Retrieves the first name of the student
    public String getFirstName() {
        return firstName;
    }

    // Retrieves the last name of the student
    public String getLastName() {
        return lastName;
    }

    // Retrieves the major of the student
    public String getMajor() {
        return major;
    }
}
