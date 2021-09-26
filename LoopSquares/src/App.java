import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        do {
            input = scanner.nextInt();
            int square = input * input;
            System.out.println(square);
        } while (input > 0);

        scanner.close();
    }
}
