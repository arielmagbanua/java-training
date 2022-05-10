import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ascending {
    public static void main(String[] args) {
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // get the first number input, convert it to int, and store it to the variable
        System.out.print("Enter first number: ");
        int num1 = Integer.parseInt(scanner.nextLine());

        // get the second number input, convert it to int, and store it to the variable
        System.out.print("Enter second number: ");
        int num2 = Integer.parseInt(scanner.nextLine());

        // get the third number input, convert it to int, and store it to the variable
        System.out.print("Enter third number: ");
        int num3 = Integer.parseInt(scanner.nextLine());

        // create array list and store all numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);

        // sort the numbers in ascending order
        Collections.sort(numbers);

        // iterate each number and print them separated by single space
        for (int num : numbers) {
            System.out.print(num +" ");
        }
    }
}
