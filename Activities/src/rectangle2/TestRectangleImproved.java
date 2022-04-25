package rectangle2;

import java.util.Scanner;

public class TestRectangleImproved {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        double length, width;

        Rectangle2 r = new Rectangle2();

        // use infinite loop and only break the loop if user inputs 3
        while (true) {
            System.out.print("1.Set Length \n2.Set Width \n3.Exit \nChoice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch(choice) {
                //set length
                case 1:
                    System.out.print("Enter length of rectangle: ");
                    length = Double.parseDouble(input.nextLine());

                    r.setLength(length);
                    continue; // continue at the top of the loop
                //set width
                case 2:
                    System.out.print("Enter width of rectangle: ");
                    width = Double.parseDouble(input.nextLine());

                    r.setWidth(width);
                    continue; // continue at the top of the loop
            }

            if (choice == 3) {
                // user wants to terminate the program therefore break the loop
                break;
            } else {
                // wrong choice
                System.out.println("Wrong choice!");
            }
        }

        // display the results
        r.display();
    }
}
