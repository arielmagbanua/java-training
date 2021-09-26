import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] numbers = new int[num];

        for (int i = 0; i < num; i++) {
            int inputNum = scanner.nextInt();
            numbers[i] = inputNum;
        }

        // sort the array fron smallest to largest
        Arrays.sort(numbers);

        System.out.println(numbers[numbers.length - 1]);

        scanner.close();
    }
}
