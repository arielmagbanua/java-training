package rectangle2;

import java.util.Scanner;

class TestRectangle {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        double length, width;

        Rectangle2 r = new Rectangle2();

        System.out.print("\n1.Set Length \n2.Set Width \n3.Exit \nChoice: ");
        int choice = Integer.parseInt(input.nextLine());

        switch(choice) {
            //set length
            case 1:
                System.out.print("Enter length of rectangle: ");
                length = Double.parseDouble(input.nextLine());

                r.setLength(length);
                break;
            //set width
            case 2:
                System.out.print("Enter width of rectangle: ");
                width = Double.parseDouble(input.nextLine());

                r.setWidth(width);
                break;
            //exit
            case 3:
                System.exit(0);
                break;
        }

        r.display();
    }
}
