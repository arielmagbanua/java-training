import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutputTester {
    public static void main(String[] args) throws IOException {
        List<Integer> integers = readIntegersFromFile("Numbers.txt");
        checkAndWriteIntegers(integers);
    }

    /**
     * Check each number if odd or even then write the results to the Output.txt
     *
     * @param integers The list of integers
     * @throws IOException
     */
    public static void checkAndWriteIntegers(List<Integer> integers) throws IOException {
        // String builder for building output to be written in the file
        StringBuilder stringBuilder = new StringBuilder();

        // iterate the list of integers using foreach
        for (int num : integers) {
            // check if odd or even
            if (num % 2 == 0) {
                // even
                stringBuilder.append(num).append(" is even\n");
            } else {
                // odd
                stringBuilder.append(num).append(" is odd\n");
            }
        }

        // write the output text to the file
        File file = new File("Output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(stringBuilder.toString().trim());

        // close the writer
        writer.close();
    }

    /**
     * Read the file and return the list integers
     *
     * @param filePath The path of the file
     * @return List of integers
     */
    public static List<Integer> readIntegersFromFile(String filePath) {
        List<Integer> integers = new ArrayList<>();

        try {
            // read the file if exist
            File numbersFile = new File(filePath);
            if (!numbersFile.exists()) {
                // the file did not exist return the empty list immediately
                return integers;
            }

            Scanner scanner = new Scanner(numbersFile);

            // read each line
            while(scanner.hasNextLine()) {
                // each line is expected to be space separated numbers
                String line = scanner.nextLine().trim();
                String[] numberStrings = line.split(" ");

                // store each number to the list
                for (String numberStr : numberStrings) {
                    // convert each number ot integer then store it
                    int number = Integer.parseInt(numberStr);
                    integers.add(number);
                }
            }

            // return the sorted integers
            return integers;
        } catch (FileNotFoundException e) {
            // this means file does not exist therefore return an empty list
            return integers;
        }
    }
}
