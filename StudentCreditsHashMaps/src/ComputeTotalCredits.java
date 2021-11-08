import java.util.*;

public class ComputeTotalCredits {
    public static Map<String, Integer> computeTotalCredits(Map<String, Set<String>> courses, Map<String, Integer> credits) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Set<String>> entry : courses.entrySet()) {
            String student = entry.getKey();
            Set<String> studentCourses = entry.getValue();

            // get the total credits
            int totalCredits = 0;
            for (String course : studentCourses) {
                int credit = credits.get(course);
                totalCredits += credit;
            }

            // add to result
            result.put(student, totalCredits);
        }

        // sort the result by key
        Map<String, Integer> sortedResult = new TreeMap<>(result);
        return sortedResult;
    }

    public static void main(String[] args) {
        // course credits map
        Map<String, Integer> coursesCredits = new HashMap<>();
        coursesCredits.put("AMATH301", 4);
        coursesCredits.put("CSE143", 5);
        coursesCredits.put("CSE311", 4);
        coursesCredits.put("MATH308", 3);
        coursesCredits.put("PHIL120", 5);

        Map<String, Set<String>> studentCourses = new HashMap<>();

        // student enrolled courses
        Set<String> anthonyEnrolled = new HashSet<>();
        anthonyEnrolled.add("CSE143");

        Set<String> arthurEnrolled = new HashSet<>();
        arthurEnrolled.add("CSE311");
        arthurEnrolled.add("PHIL120");

        Set<String> taylorEnrolled = new HashSet<>();
        taylorEnrolled.add("PHIL120");
        taylorEnrolled.add("MATH308");

        Set<String> sanjanaEnrolled = new HashSet<>();
        sanjanaEnrolled.add("CSE143");
        sanjanaEnrolled.add("MATH308");

        Set<String> raymondEnrolled = new HashSet<>();
        raymondEnrolled.add("CSE311");
        raymondEnrolled.add("MATH308");
        raymondEnrolled.add("PHIL120");

        Set<String> jeremyEnrolled = new HashSet<>();

        // add to the student credits map
        studentCourses.put("Anthony", anthonyEnrolled);
        studentCourses.put("Arthur", arthurEnrolled);
        studentCourses.put("Taylor", taylorEnrolled);
        studentCourses.put("Sanjana", sanjanaEnrolled);
        studentCourses.put("Raymond", raymondEnrolled);
        studentCourses.put("Jeremy", jeremyEnrolled);

        // compute the total credits
        Map<String, Integer> result = computeTotalCredits(studentCourses, coursesCredits);

        // print each student with total credits
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String student = entry.getKey();
            int totalCredits = entry.getValue();

            System.out.printf("%s: %d\n", student, totalCredits);
        }
    }
}
