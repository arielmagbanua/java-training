import java.util.Arrays;
import java.util.Scanner;

public class BattingAverage
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);

        // Declare a named constant for array size here.
        final int SIZE = 8;


        // Declare array here.
        double[] averages = new double[SIZE];


        // Use this integer variable as your loop index.
        int loopIndex;


        // Use this variable to store the batting average input by user.
        double battingAverage;


        // String version of batting average input by user.
        String averageString;


        // Use these variables to store the minimum and maximum batting averages.
        double min, max;


        // Use these variables to store the total and the average.
        double total, average;


        // Write a loop to get batting averages from user and assign to array.
        for (loopIndex = 0; loopIndex < SIZE; loopIndex++) {
            System.out.print("Enter a batting average: ");
            averageString = s.nextLine();
            battingAverage = Double.parseDouble(averageString);

            // Assign value to array.
            averages[loopIndex] = battingAverage;
        }

        // Assign the first element in the array to be the minimum and the maximum.
        min = averages[0];
        max = averages[0];

        // Start out your total with the value of the first element in the array.
        total = averages[0];

        // Write a loop here to access array values starting with averages[1]
        for (loopIndex = 1; loopIndex < SIZE ; loopIndex++) {
            // Within the loop test for minimum and maximum batting averages.
            if (averages[loopIndex] < min) {
                min = averages[loopIndex];
            }

            if (averages[loopIndex] > max) {
                max = averages[loopIndex];
            }

            // Also accumulate a total of all batting averages.
            total += averages[loopIndex];
        }


        // Calculate the average of the 8 averages.
        average = total / SIZE;


        // Print the averages stored in the averages array.
        System.out.print("Averages: ");
        System.out.println(Arrays.toString(averages));


        // Print the maximum batting average, minimum batting average, and average batting average.
        System.out.printf("Max: %s \nMin: %s \nAverage Batting Average: %s", max, min, average);


        System.exit(0);
    }
}