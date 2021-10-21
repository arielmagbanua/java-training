import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // get the project source directory
        String projectSourceDir = Paths.get("src")
                .toAbsolutePath()
                .toString();

        // get the full path of the words.txt
        String wordsPath = projectSourceDir + "/words.txt";

        // read the file by scanner
        File words = new File(wordsPath);
        Scanner scanner = new Scanner(words);
        // needs a list to store each line
        List<String> lines = new ArrayList<>();

        // read each line
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        // prepare the hash map
        Map<String, String> spanishTranslations = new HashMap<>();
        // get the number of lines
        int lineCount = Integer.parseInt(lines.get(0));

        // each line is separated by space the left word is the english
        // and the right side is the spanish translation
        for (int i = 1; i <= lineCount; i++) {
            // split the words
            String[] englishSpanish = lines.get(i).split(" ");

            // store in the hash map
            // the english should be the key and the value should be the spanish translation
            spanishTranslations.put(englishSpanish[0], englishSpanish[1]);
        }

        // print the values of hash map
        System.out.println(spanishTranslations);

        // print and format each key value pair by iterating the spanishTranslations HashMap
        for (Map.Entry<String, String> entry : spanishTranslations.entrySet()) {
            // get the english word
            String englishWord = entry.getKey();

            // get the spanish translation of the english word
            String spanishWord = entry.getValue();

            // format and print
            System.out.printf("%s ---> %s\n", englishWord, spanishWord);
        }
    }
}
