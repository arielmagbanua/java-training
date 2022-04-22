import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class TestNumFile {
    public static void main(String[] args) {
        ArrayList<Integer> numList = null; // declare an ArrayList var and initialize to null

        // relative path and file name of data file
        String fileName = "data/records.txt";
        // This "records.txt" file should already exist in a folder named "data".
        // If using an IDE and source code file is put in a default "src" folder (or similar),
        // folder "data" should be at the same location as the "src" folder;
        // otherwise, "data" folder should be at the same location as the .java file

        numList = loadFromFile(fileName);  // load data

        System.out.println("Records: " + numList);
    }

    // read data from a specified file
    // data will be saved in ArrayList and returned
    private static ArrayList<Integer> loadFromFile(String fileName) {
        Scanner fileIn = null; // scanner object to connect to file
        ArrayList<Integer> list = new ArrayList<>(); // to store data from file

        try { // try-catch-finally used for any exception during file open/read/close
            // open input file
            fileIn = new Scanner(Path.of(fileName));

            // loop through multiple records
            while (fileIn.hasNextInt()) { // still have numbers to be read?
                // 1. read one record (here each record is just one num)
                int num = fileIn.nextInt();

                // 2. add the record to ArrayList obj
                list.add(num);

                // end one record
            }// end while: reading all records

        } catch (IOException ioe) {
            System.out.println("Error reading \"" + fileName + "\" file: " + ioe);
        } finally { // close file
            if ( fileIn != null) {  // close if was connected to a file
                fileIn.close();
            }
        }
        // end file input

        return list;
    }// end loadFromFile
}
