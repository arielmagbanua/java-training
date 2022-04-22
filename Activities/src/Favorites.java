import java.util.Scanner;

public class Favorites {
    public static void main(String[] args) {
        // Scanner for getting inputs
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your favorite number: ");
        int favNum = Integer.parseInt(input.nextLine());

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.printf("%s your favorite number is %d and you are %d years old.", name, favNum, age);
    }
}
