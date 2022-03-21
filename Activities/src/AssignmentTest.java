public class AssignmentTest {
    public static void main(String[] args) {
        // create new assignment
        Assignment assignment = new Assignment("Juan Tamad", 30, 20);

        // 66% grade
        assignment.calculateGrade();
        System.out.println(assignment.getGrade());

        // should display error
        assignment.setStudentMark(50);

        // 50% grade
        assignment.setStudentMark(15);
        assignment.calculateGrade();
        System.out.println(assignment.getGrade());

        // perfect grade
        assignment.setStudentMark(30);
        assignment.calculateGrade();
        System.out.println(assignment.getGrade());

        // fail grade
        assignment.setStudentMark(1);
        assignment.calculateGrade();
        System.out.println(assignment.getGrade());

        // 0 grade
        assignment.setStudentMark(0);
        assignment.calculateGrade();
        System.out.println(assignment.getGrade());
    }
}
