import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the input
        int num = scanner.nextInt();

        // the left most number
        int leftMost = num / 100;

        // middle number
        int middle = (num / 10) % 10;

        // the right most number
        int rightMost = num % 10;

        int largest = 0;

        if (leftMost > largest) {
            largest = leftMost;
        }

        if (middle > largest) {
            largest = middle;
        }

        if (rightMost > largest) {
            largest = rightMost;
        }

        System.out.println(largest);

        scanner.close();
    }
}
