import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deviation_Mean {
    public static void main(String[] args) {
        double sum = 0, mean, deviation = 0;

        Scanner input = new Scanner(System.in);
        List<Double> array = new ArrayList<>();

        System.out.println("Enter numbers ('quit' to end): ");
        while (true) {
            // get the input of the user
            String userInput = input.nextLine();
            if (userInput.equalsIgnoreCase("quit")) {
                // user want to quit inputting the numbers, therefore break the loop
                break;
            }

            // convert the input to double and add it to the list
            double number = Double.parseDouble(userInput);
            array.add(number);
        }

        // get the sum by iterating the array and adding the items to sum
        for (double num : array) {
            sum += num;
        }

        // calculate the mean
        mean = sum / array.size();

        // get the deviation
        for (double num : array) {
            deviation += ((mean - num) * (mean - num));
        }

        System.out.printf("The mean is %.2f\n", mean);
        System.out.printf("The standard deviation is %.5f", Math.sqrt(deviation / (array.size() - 1)));
    }
}
