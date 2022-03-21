/**
 * @author FirstName LastName <--- Provide your name here.
 * @version 2022-02-26 <--- Provide the correct date you last worked in this exercise.
 */
public class Assignment {
    public String studentName;
    public double assignmentMark;
    public double studentMark;
    public String grade;

    public Assignment(String studentName, double assignmentMark, double studentMark) {
        this.studentName = studentName;
        this.assignmentMark = assignmentMark;
        this.studentMark = studentMark;
    }

    public Assignment() {
        this.assignmentMark = 100;
    }

    public double getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(double studentMark) {
        // prevent the setting of student mark if the student mark is greater than assignment mark
        if (studentMark > this.assignmentMark || studentMark < 0) {
            // impossible to have student mark greater than assignment mark
            System.out.println("Invalid student mark.");
            return;
        }

        this.studentMark = studentMark;
    }

    public void calculateGrade() {
        double gradePercentage = (this.studentMark / this.assignmentMark) * 100;

        if (gradePercentage < 50.0) {
            this.grade = "fail";
        } else if (gradePercentage >= 50.0 && gradePercentage <= 64.0) {
            this.grade = "pass";
        } else if (gradePercentage >= 65.0 && gradePercentage <= 74.0) {
            this.grade = "credit";
        } else if (gradePercentage >= 75.0 && gradePercentage <= 84.0) {
            this.grade = "distinction";
        } else if (gradePercentage >= 85.0) {
            this.grade = "high distinction";
        }
    }

    public String getGrade() {
        return grade;
    }
}
