import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String charInput = "";
        int counter = 0;
        boolean notVowel = true;

        do {
            charInput = scanner.nextLine()
                .toLowerCase();

            notVowel = !charInput.equals("a") && !charInput.equals("e") && !charInput.equals("i") && !charInput.equals("o") && !charInput.equals("u");
            ++counter;

        } while (notVowel && counter != 5);

        scanner.close();
    }
}
