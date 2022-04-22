import java.util.Scanner;

public class Applications {
    public static void main(String[] args) {
        // a) Declare local variables length and width of type double
        double length;
        double width;

        // b) Using scanner object solicit two number from the console and save the values in the variables length and width
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length: ");
        length = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine().trim());

        // c) Declare and instantiate a Rectangle object named box. Use the initializer constructor;
        // the parameters are length and width
        Rectangle box = new Rectangle(length, width);

        // d) Declare and instantiate another Rectangle object named box2. Use the default constructor.
        Rectangle box2 = new Rectangle();

        // e) Use box2 to call the setLength() and setWidth() methods. Choose number for parameters at will.
        box2.setLength(10.5);
        box2.setWidth(11.5);

        // f) Call the display() method with respect to box as well as to box2.
        // Copy the console output into a comment block placed after the class.
        // Check and comment if the field values correspond to the input.
        // Prints "The length is: 2.50" if the length input is 2.5
        // Prints "The width is: 3.00" if the width input is 3
        box.displayRectangle();
        // Prints "The length is: 10.50"
        // Prints "The width is: 11.50"
        box2.displayRectangle();

        // g) Use box to call equals method, use box2 for the parameter. Print the return boolean to the console.
        // Comment on the output
        // Prints true if the dimensions of box and box2 are equal otherwise it prints false
        boolean result1 = box.equals(box2);
        System.out.println(result1);

        // h) Declare and instantiate a third Rectangle object named box3. Use the default constructor.
        Rectangle box3 = new Rectangle();

        // i) Use box to call the getter methods and assign the local variable width and length the values returned by the getters.
        length = box.getLength();
        width = box.getWidth();

        // j) Use box3 to call the setters (like above for box2), the setters this time take the local variables for parameter.
        box3.setLength(length);
        box3.setWidth(width);

        // k) Use box to call the equals method and use box 3 for parameter. Print the return boolean to the console.
        // Comment on the output in the comment block you already created above
        // Prints true if the dimensions of box and box3 are equal otherwise it prints false
        boolean result2 = box.equals(box3);
        System.out.println(result2);

        // l) Call the computeArea() and computePerimeter() methods with respect to all boxes.
        // Print the return values to the console together with a short explanation for each, and copy the output in to the comment block.
        // Prints "Area: 7.5" and "Perimeter: 11.0", if the length input is 2.5 and width input is 3
        System.out.println("Area: " + box.computeArea());
        System.out.println("Perimeter: " + box.computePerimeter());
        // Prints "Area: 120.75" and "Perimeter: 44.0"
        System.out.println("Area: " + box2.computeArea());
        System.out.println("Perimeter: " + box2.computePerimeter());
        // Prints "Area: 7.5" and "Perimeter: 11.0", if the length input is 2.5 and width input is 3
        System.out.println("Area: " + box3.computeArea());
        System.out.println("Perimeter: " + box3.computePerimeter());

        // m) Declare and instantiate a Rectangle object name box4.
        // Use the constructor for initializing rectangle which is an instance of the class rectangle. The instance is box2.
        // Use box4 to call the setLength() and setWidth() methods for printing out the length of the box4.
        // Then call the display method with respect to box4. Are box2 and box4 have the same length and width?
        Rectangle box4 = new Rectangle(box2);

        // print box2 dimensions using getters
        System.out.printf("Length: %.2f\n", box2.getLength());
        System.out.printf("Width: %.2f\n", box2.getWidth());

        // call display method for box 4
        box4.displayRectangle();
    }
}
