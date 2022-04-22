import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Range {
    public static void main(String[] args) {
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // array list to store the numbers
        List<Integer> numbers = new ArrayList<>();

        // get the user input line that contain number separated by space
        String input = scanner.nextLine();
        // split the numbers
        String[] numbersInput = input.split(" ");

        // convert each number to int and store them
        for (String num : numbersInput) {
            int number = Integer.parseInt(num);
            numbers.add(number);
        }

        // get the second input line
        input = scanner.nextLine();
        // split the numbers
        numbersInput = input.split(" ");

        // convert the first index to int, and it would be the lower bound
        int lowerBound = Integer.parseInt(numbersInput[0]);
        // convert the second index to int, and it would be the upper bound
        int upperBound = Integer.parseInt(numbersInput[1]);

        // get the numbers from the list that falls within the bound by iterating each number
        // and checking of the number is between the lower and upper bound
        List<Integer> numbersInBound = new ArrayList<>();
        for (int num : numbers) {
            if (num >= lowerBound && num <= upperBound) {
                // the number is in between lower and upper bound therefore add it to the numbersInBound list
                numbersInBound.add(num);
            }
        }

        // print each number
        for (int num : numbersInBound) {
            System.out.print(num + ",");
        }
    }
}
