import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = input.nextInt();

        if (num % 2 == 0) {
            // number is even
            System.out.print("The integer " + num + " is even.");
        } else {
            // number is odd
            System.out.print("The integer " + num + " is odd.");
        }
    }
}
