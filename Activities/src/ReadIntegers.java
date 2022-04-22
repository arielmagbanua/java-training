import java.io.*;
import java.util.*;

public class ReadIntegers {
    public static void main(String[] args) {
        // read the file and extract the integers
        List<Integer> integers = readFile("file.txt");

        if (integers.size() > 0) {
            // this means the file exists and extracted the numbers therefore print the list
            System.out.println(integers);
        } else {
            // likely the file don't exist or empty therefore create the file with integers
            // random generator
            Random randomGenerator = new Random();

            String numbers = "";

            for (int i = 0; i < 100; i++) {
                // generate number 1 - 100
                int number = randomGenerator.nextInt(100);

                // append the number
                numbers = numbers + " " + number;
            }

            // write the numbers string to the file
            boolean fileWriteResult = writeToFile(numbers, "file.txt");

            if (fileWriteResult) {
                // written to file so read again
                List<Integer> sortedIntegers = readFile("file.txt");
                // print
                System.out.println(sortedIntegers);
            }
        }
    }

    /**
     * Write the numbers to file.
     *
     * @param integersToWrite List of integers to write
     * @param filePath The file path of the file
     * @return Returns true if file writing is successful otherwise false
     */
    public static boolean writeToFile(String integersToWrite, String filePath) {
        try {
            File file = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(integersToWrite.trim());

            // close the writer
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            // something went wrong return false to indicate not successful in writing
            return false;
        }
    }

    /**
     * Read the file and return the list of sorted numbers
     *
     * @param filePath The path of the file
     * @return List of integers
     */
    public static List<Integer> readFile(String filePath) {
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

            // sort the numbers in descending order
            // by passing Collections.reverseOrder() as comparator
            integers.sort(Collections.reverseOrder());

            // return the sorted integers
            return integers;
        } catch (FileNotFoundException e) {
            // this means file does not exist therefore return an empty list
            return integers;
        }
    }
}
