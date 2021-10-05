import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int input = scanner.nextInt();
        int[] array = new int[input];

        for (int i = 0; i < input; i++) {
            int num = scanner.nextInt();
            array[i] = num;
        }

        for (int i = input - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }

        scanner.close();
    }
}
