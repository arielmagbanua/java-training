import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        int sum = 0;

        do {
            num = scanner.nextInt();

            if (num > 0) {
                sum += num;
            }

        } while (num != 0);

        System.out.println(sum);

        scanner.close();
    }
}
