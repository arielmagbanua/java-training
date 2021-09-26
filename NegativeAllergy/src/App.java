import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        float num = 0.0f;
        float sum = 0.0f;

        do {
            num = scanner.nextFloat();

            sum += num;
        } while (num > 0.0 && sum < 100.0);

        System.out.println(String.format("%.2f", sum));

        scanner.close();
    }
}
