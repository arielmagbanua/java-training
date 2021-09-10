import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            // sum = sum + num;
            sum += num;
        }

        int average = sum / 5;
        System.out.println("Average is equal to " + average + ".");
        
        scanner.close();
    }
}
