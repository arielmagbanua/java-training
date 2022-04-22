import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {
    public static void main(String[] args) throws IOException {
        // Create input stream reader and used it as reader for the buffered reader
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);

        // read the line input
        String input = br.readLine();

        // convert the line to array of characters
        char[] characters = input.toCharArray();

        // use foreach to print each character
        for (char character : characters) {
            // convert the character to unicode string
            String unicode = toUnicode(character);
            // print separated by space
            System.out.print(unicode + " ");
        }
    }

    /**
     * Converts the character to unicode value in String form using the format method.
     *
     * @param character The character to convert
     * @return The unicode in string form
     */
    private static String toUnicode(char character) {
        return String.format("\\u%04x", (int) character);
    }
}
