import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a min value: ");
        int min = scanner.nextInt();

        System.out.print("Enter max value: ");
        int max = scanner.nextInt();

        if (min > max) {
            System.out.print("Wrong inputs");
        }

        for (int i = min; i <= max; i++) {
            System.out.println(i);
        }

        scanner.close();
    }
}
