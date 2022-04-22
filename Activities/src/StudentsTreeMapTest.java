import java.util.Map;
import java.util.TreeMap;

public class StudentsTreeMapTest {
    public static void main(String[] args) {
        // create student instances
        PreStudent joe = new PreStudent("Joe", "Blow", 3724);
        PreStudent sam = new PreStudent("Sam", "Blow", 2475);
        PreStudent sally = new PreStudent("Sally", "Crud", 4237);
        PreStudent john1 = new PreStudent("John", "Smith", 3387);
        PreStudent john2 = new PreStudent("John", "Smith", 4520);

        // create the tree map and add the student grade
        Map<PreStudent, String> studentTreeMap = new TreeMap<>();
        studentTreeMap.put(joe, "A");
        studentTreeMap.put(sam, "B+");
        studentTreeMap.put(sally, "A-");
        studentTreeMap.put(john1, "A");
        studentTreeMap.put(john2, "B-");

        // print the header
        System.out.println("last        first       id          grade");

        // print the result
        for (Map.Entry<PreStudent, String> entry : studentTreeMap.entrySet()) {
            String grade = entry.getValue();
            PreStudent student = entry.getKey();
            System.out.println(student + "\t" + grade);
        }
    }
}
