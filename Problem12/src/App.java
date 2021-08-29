import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the input name
        String name = scanner.nextLine();
        String cleanName = name.replaceAll(" ", ""); 

        String lower = cleanName.toLowerCase();

        if (lower.equals("cody")) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }

        scanner.close();
    }
}
