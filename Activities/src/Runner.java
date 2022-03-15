import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get the length of the array
        System.out.println("Enter array length:");
        int arrayLength = scanner.nextInt();
        scanner.nextLine();

        // create the array based on the length
        double[] numbers = new double[arrayLength];

        // get the values by asking numbers base on the length of the array
        System.out.println("Enter values:");
        // get the values and split it to array
        String[] values = scanner.nextLine().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            // convert each number to integer
            numbers[i] = Double.parseDouble(values[i]);
        }

        // test it
        boolean result = U6_L2_Activity_One.allNegative(numbers);
        System.out.println("All negative: " + result);
    }
}
