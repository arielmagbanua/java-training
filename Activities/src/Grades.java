import java.text.DecimalFormat;
import java.util.Scanner;

public class Grades {
    public static double computeWrittenWork(int quiz1, int quiz2, int sw1, int sw2) {
        // get the average written work
        double average = (quiz1 + quiz2 + sw1 + sw2) / 4.0;

        // calculate 25%, since written work have a weight of 25% of the overall grade
        double writtenWork = average * 0.25;

        // round the result, convert it back to double, and return
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(writtenWork));
    }

    public static double computePerformanceTask(int pt1, int pt2, int pt3) {
        // get the average performance tasks
        double average = (pt1 + pt2 + pt3) / 3.0;

        // calculate 45%, since performance tasks have a weight of 45% of the overall grade
        double performanceTask = average * 0.45;

        // round the result, convert it back to double, and return
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(performanceTask));
    }

    public static double computeFinalExam(int exam) {
        // calculate 30%, since final exam have a weight of 30% of the overall grade
        double finalExam = exam * 0.30;

        // round the result, convert it back to double, and return
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(finalExam));
    }

    public static double getEquivalentGrade(double grade) {
        // round to the whole value
        DecimalFormat df = new DecimalFormat("00");
        int consideredGrade =  (int)Double.parseDouble(df.format(grade));

        if (consideredGrade >= 0 && consideredGrade <= 74) {
            return 5.00;
        }

        if (consideredGrade >= 75 && consideredGrade <= 77) {
            return 3.00;
        }

        if (consideredGrade >= 78 && consideredGrade <= 80) {
            return 2.75;
        }

        if (consideredGrade >= 81 && consideredGrade <= 83) {
            return 2.50;
        }

        if (consideredGrade >= 84 && consideredGrade <= 86) {
            return 2.25;
        }

        if (consideredGrade >= 87 && consideredGrade <= 89) {
            return 2.00;
        }

        if (consideredGrade >= 90 && consideredGrade <= 92) {
            return 1.75;
        }

        if (consideredGrade >= 93 && consideredGrade <= 95) {
            return 1.50;
        }

        if (consideredGrade >= 96 && consideredGrade <= 98) {
            return 1.25;
        }

        // grade grader than 99
        return 1.00;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get quiz1 grade
        System.out.print("Quiz 1: ");
        String quiz1Val = scanner.nextLine();
        // convert to int
        int quiz1 = Integer.parseInt(quiz1Val);

        // get quiz1 grade
        System.out.print("Quiz 2: ");
        String quiz2Val = scanner.nextLine();
        // convert to int
        int quiz2 = Integer.parseInt(quiz2Val);

        // get seat work 1 grade
        System.out.print("SW1: ");
        String sw1Val = scanner.nextLine();
        // convert to int
        int sw1 = Integer.parseInt(sw1Val);

        // get seat work 2 grade
        System.out.print("SW2: ");
        String sw2Val = scanner.nextLine();
        // convert to int
        int sw2 = Integer.parseInt(sw2Val);

        double writtenWorkWeight = computeWrittenWork(quiz1, quiz2, sw1, sw2);
        System.out.println("Written work(25%): " + writtenWorkWeight);

        // get performance task 1 grade
        System.out.print("PT1: ");
        String pt1Val = scanner.nextLine();
        // convert to int
        int pt1 = Integer.parseInt(pt1Val);

        // get performance task 2 grade
        System.out.print("PT2: ");
        String pt2Val = scanner.nextLine();
        // convert to int
        int pt2 = Integer.parseInt(pt2Val);

        // get performance task 3 grade
        System.out.print("PT3: ");
        String pt3Val = scanner.nextLine();
        // convert to int
        int pt3 = Integer.parseInt(pt3Val);

        double performanceTaskWeight = computePerformanceTask(pt1, pt2, pt3);
        System.out.println("Performance Task(45%): " + performanceTaskWeight);

        // get the final exam grade
        System.out.print("Final Exam: ");
        String fExam = scanner.nextLine();
        // convert to int
        int finalExam = Integer.parseInt(fExam);

        double finalExamWeight = computeFinalExam(finalExam);
        System.out.println("Final Exam(30%): " + finalExamWeight);

        // sum all weights to get the final grade
        double finalGrade = writtenWorkWeight + performanceTaskWeight + finalExamWeight;
        System.out.println(String.format("Final Grade: %.2f", finalGrade));

        // get the equivalent grade and print it
        double equivalentGrade = getEquivalentGrade(finalGrade);
        System.out.println(String.format("Equivalent: %.2f", equivalentGrade));
    }
}
