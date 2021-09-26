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

        int numToSearch = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < num; i++) {
            if (numToSearch == numbers[i]) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Present");
        } else {
            System.out.println("None");
        }

        scanner.close();
    }
}
