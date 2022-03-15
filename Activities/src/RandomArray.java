/**
 * A class for rectangular arrays full of random
 * positive integers.
 */
public class RandomArray {
    //An instance variable to hold an array of integers
    //****YOUR CODE HERE****
    private int[][] numbers;

    public RandomArray(int rows, int cols, int range) {
        /* Construct a random array with the given number of
         * rows and columns, filled with random integers in
         * the range  0..range-1.
         * Use the expression (int)(range*Math.random())
         */
        //****YOUR CODE HERE****
        this.numbers = new int[rows][cols];

        // fill numbers array by looping row first
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            // loop by column
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                // generate the random number
                int randomNumber = (int)(range*Math.random());
                // store the number
                this.numbers[rowIndex][colIndex] = randomNumber;
            }
        }

    }//constructor

    public int[] getRow(int r) {
        //Return a copy (clone) of row r of the array
        //****YOUR CODE HERE****
        return this.numbers[r];
    }//getRow method

    public int[] getCol(int c) {
        //Return an int[] array containing the numbers from column c.
        //****YOUR CODE HERE****
        // the length of column numbers is same with the number of rows
        int[] colNumbers = new int[this.numbers.length];
        // colNumbers index
        int colNumIndex = 0;

        // loop by row
        for (int rowIndex = 0; rowIndex < this.numbers.length; rowIndex++) {
            // loop by column
            for (int colIndex = 0; colIndex < this.numbers[rowIndex].length; colIndex++) {
                if (c == colIndex) {
                    // same column index, this means the number at this position is in the column index c
                    colNumbers[colNumIndex++] = this.numbers[rowIndex][colIndex];
                }
            }
        }

        return colNumbers;
    }//getCol method

}//RandomArray class
