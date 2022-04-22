import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StuPreTestNumFileArr {
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

    // return a partially filled int array with all elements from ArrayList
    // param in the same sequence and 5 extra spots at the end
    private static int[] toIntArray(ArrayList<Integer> list) {
        // create the array to be filled
        // the length should be: length of list + 5
        int[] numbers = new int[list.size() + 5];

        // declare starting index for copying
        int index = 0;

        // iterate each integer in the list and copy them to the numbers array
        for (int num : list) {
            // assign the current number to the numbers array by index and then increment the index
            numbers[index++] = num;
        }

        // finally, return the numbers array
        return numbers;
    }

    // sort a partially filled array ([0 ~ numOfElements-1]) into
    // ascending order
    // Will return and not modify the arr if arr is null or
    // numOfElements is invalid
    private static void sort(int[] arr, int numOfElements) {
        if (arr == null || numOfElements < 0 || numOfElements > arr.length) {
            // return and not modify the arr if arr is null or numOfElements is invalid
            return;
        }

        // now use selection sort for sorting the array
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < numOfElements - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < numOfElements; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // insert into a partially filled array ([0~numOfElements-1]) and
    // maintain sorted order (ascending)
    // This method returns number of stored elements at the end.
    // If insert failed (such as arr is null, numOfElements is invalid,
    // or arr is already full), do not modify arr content and return
    // numOfElements
    private static int insert(int[] arr, int numOfElements, int newItem) {
        if (arr == null || numOfElements < 0 || numOfElements >= arr.length) {
            // The arr is null, numOfElements is invalid, or arr is already full.
            // do not modify arr content and return numOfElements
            return numOfElements;
        }

        // get the last index to be filled
        int lastIndex = 0;
        for (int number : arr) {
            if (number == 0) {
                // found the position of first 0 which means the current value of last index is the last index to be filled.
                break;
            }

            // increment the index
            ++lastIndex;
        }

        // insert the new item
        arr[lastIndex] = newItem;

        // increment the number of elements
        ++numOfElements;

        // sort again the array
        sort(arr, numOfElements);

        return numOfElements;
    }

    public static void main(String[] args) {
        int[] numArr = null; // to hold data
        int size = 0; // track actual # of elements.

        ArrayList<Integer> numList = null; // declare an ArrayList var and initialize to null

        // relative path and file name of data file
        String fileName = "data/records.txt";
        // This "records.txt" file should already exist in a folder named "data".
        // If using an IDE and source code file is put in a default "src" folder (or similar),
        // folder "data" should be at the same location as the "src" folder;
        // otherwise, "data" folder should be at the same location as the .java file

        numList = loadFromFile(fileName);

        numArr = toIntArray(numList);

        size = numList.size();

        System.out.println("Now in arr: " + Arrays.toString(numArr));

        sort(numArr, size);
        System.out.println("After sorting: " + Arrays.toString(numArr));

        Scanner stdIn = new Scanner(System.in);
        int num;
        for (int i=0; i<2; i++) {
            System.out.print("Enter a number: ");
            num = stdIn.nextInt();
            size = insert(numArr, size, num);
            System.out.printf("After inserting %d: %s\n", num, Arrays.toString(numArr));
        }

        stdIn.close(); // Eclipse requires closing a Scanner object
    }
}
