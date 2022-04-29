import java.util.Scanner;

public class Counts {
    public static int[] count(String s) {
        // declare the array
        int[] counts = new int[10];

        // iterate each character of the string
        for (int i = 0; i < s.length(); i++) {
            // get the current character
            char ch = s.charAt(i);

            // check if character is a number or digit
            boolean isDigit = Character.isDigit(ch);

            if (isDigit) {
                // convert the character to numeric value
                int num = Character.getNumericValue(ch);

                // the numeric value represents the index of the counts array
                // therefore increment the value of that index
                ++counts[num];
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        // scanner for getting user input
        Scanner scanner = new Scanner(System.in);

        // get the string input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // execute the count method
        int[] results = count(input);

        // iterate and print each result
        for (int i = 0; i < results.length; i++) {
            if (results[i] > 0) {
                // print only results that have at least 1 count
                System.out.printf("Digit %d occurs %d times\n", i, results[i]);
            }
        }
    }
}
