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

        int middleIndex = input / 2;

        int groupCount = 0;
        for (int i = input - 1; i >= 0; i--) {
            if (groupCount == 0) {
                System.out.print("[");
            }

            ++groupCount;
            System.out.print(array[i]);
            if (groupCount < 2) {
                if (i == middleIndex) {
                    groupCount = 2;
                } else {
                    System.out.print(",");
                }
            }

            if (groupCount == 2) {
                System.out.print("]");

                if (i > 0) {
                    System.out.print("-");
                }

                groupCount = 0;
            }
        }

        scanner.close();
    }
}
