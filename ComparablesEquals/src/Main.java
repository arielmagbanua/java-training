import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // rectangles
        Rectangle rectangle0 = new Rectangle(50, 4);
        rectangle0.setName("rectangle_0");
        Rectangle rectangle1 = new Rectangle(80, 3);
        rectangle1.setName("rectangle_1");
        Rectangle rectangle2 = new Rectangle(90, 2);
        rectangle2.setName("rectangle_2");

        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(rectangle0);
        rectangleList.add(rectangle1);
        rectangleList.add(rectangle2);

        // print the list
        System.out.println(rectangleList);

        // sort using comparable
        Collections.sort(rectangleList);

        // print the list
        System.out.println(rectangleList);

        // students
        Student andy = new Student("Andy", 78);
        Student behnaz = new Student("Behnaz", 66);
        Student charlie = new Student("Charlie", 78);
        Student deepak = new Student("Deepak", 88);

        if (andy.equals(charlie)) {
            System.out.println(andy.getName() + " and " + charlie.getName() + " are equal.");
        }

        if (!andy.equals(behnaz)) {
            System.out.println(andy.getName() + " and " + behnaz.getName() + " are not equal.");
        }

        if (!deepak.equals(behnaz)) {
            System.out.println(deepak.getName() + " and " + behnaz.getName() + " are not equal.");
        }
    }
}
