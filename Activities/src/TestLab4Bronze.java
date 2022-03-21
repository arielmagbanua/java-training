 /*
  * This file will test the
  * RandomArray class.
  */

 import java.util.Arrays;
 import java.util.Scanner;

 public class TestLab4Bronze {

     public static void main(String[] args) {
         Scanner keyboard = new Scanner(System.in);

         //Values from 0..RANGE-1 should be generated
         final int RANGE = 100;

         //Ask the user for a number of rows and columns
         System.out.print("How many rows? ");
         int rows = keyboard.nextInt();
         System.out.print("How many columns? ");
         int cols = keyboard.nextInt();

         //Create an array with that number of rows and columns
         RandomArray a = new RandomArray(rows, cols, RANGE);

         //Print out the rows, one by one
         System.out.println("The rows contain:");
         for (int r = 0; r < rows; r++)
             System.out.println("Row " + r + ": " + Arrays.toString(a.getRow(r)));

         //Print out the columns, one by one
         System.out.println("\nThe columns contain:");
         for (int c = 0; c < cols; c++)
             System.out.println("Column " + c + ": " + Arrays.toString(a.getCol(c)));

     }//main
 }//TestLab4Bronze
