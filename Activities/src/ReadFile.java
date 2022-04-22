import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws NoSuchElementException {

        try {
            File myObj = new File("foo.txt");

            Scanner myReader = new Scanner(myObj);

            boolean currentlyInComment = false;

            String line = myReader.nextLine();

            while (line != null) {
                if (line.trim().startsWith("/")) {
                    currentlyInComment = true;
                }

                if (!currentlyInComment && !line.trim().startsWith("//")) {
                    if (line == "") {
                        System.out.println("times");
                    }

                    System.out.println(line);

                }
                if (line.trim().endsWith("*/") && currentlyInComment) {
                    currentlyInComment = false;
                }

                line = myReader.nextLine();
            }

        } catch (Exception ignore) {

        }

    }

}