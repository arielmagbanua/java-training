import java.util.Arrays;
import java.util.Scanner;

/**
 * This program asks the instructor for the number of students in the class.
 * Then the program asks for students' names and grades.
 * Afterwards the program should print the name and grade of the student with the lowest grade.
 *
 * @author TODO: PROVIDE YOUR NAME HERE
 * TODO: PROVIDE THE DATE
 */
public class Problem3 {
    /**
     * This class represents or models a student.
     * It implements comparable to easy sorting.
     */
    static class Student implements Comparable<Student>{
        private String name;
        private double grade;

        /**
         * Class constructor
         *
         * @param name The name of the student
         * @param grade The grade of the student
         */
        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }

        /**
         * This method will be invoked when comparing other student.
         * This is very helpful for easy sorting students in ascending order by grade.
         *
         * @param o The other student instance.
         * @return Returns comparison value.
         */
        @Override
        public int compareTo(Student o) {
            return Double.compare(this.grade, o.grade);
        }
    }

    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        // prompt
        System.out.print("Number of students: ");
        // get number of students input, convert it to int, and store it to variable
        int numberOfStudents = Integer.parseInt(scanner.nextLine().trim());

        // create the array of students that will contain the name and grade of student
        Student[] students = new Student[numberOfStudents];

        // index for students data array
        int index = 0;

        // loop through the number of students
        while (numberOfStudents > 0) {
            // ask for student name
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            // ask for the grade
            System.out.print("Grade: ");
            double grade = Double.parseDouble(scanner.nextLine().trim());

            // create a student and store it in the array
            students[index] = new Student(name, grade);

            // increment the index
            ++index;
            // decrement the student counter
            --numberOfStudents;
        }

        // sort
        Arrays.sort(students);

        // get the first student since the students array is sorted in ascending order
        Student lastStudent = students[0];
        // format string to display student
        String displayText = String.format("Name: %s \nGrade: %s", lastStudent.getName(), lastStudent.getGrade());
        System.out.print(displayText);
    }
}
