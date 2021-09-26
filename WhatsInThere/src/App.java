import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        
        String[] words = new String[num];

        for (int i = 0; i < num; i++) {
            String word = scanner.nextLine();
            words[i] = word;
        }

        int index = scanner.nextInt();
        System.out.println(words[index]);

        scanner.close();
    }
}
