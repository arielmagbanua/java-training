import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print(num);
        }

        scanner.close();
    }
}
