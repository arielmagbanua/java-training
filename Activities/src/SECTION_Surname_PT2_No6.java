import java.util.Scanner;

public class SECTION_Surname_PT2_No6 {
    public static void main(String[] args) {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        // get month number input, convert it to int, and then store the value to a variable.
        int monthNumber = Integer.parseInt(scanner.nextLine());

        // print the month depending on the month number
        // use switch statement to cleanly implement it.
        switch (monthNumber) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                // number outside 1 - 12 therefore invalid
                System.out.println("Invalid");
                break;
        }
    }
}
