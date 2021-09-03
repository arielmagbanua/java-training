import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // A line containing two integers separated by a space.
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();

        for (int i = startNum; i <= endNum; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
