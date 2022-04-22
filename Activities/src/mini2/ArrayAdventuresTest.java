package mini2;

import java.util.Arrays;

public class ArrayAdventuresTest {
    public static void main(String[] args) {
        // for remove testing
        int[] arr = new int[]{1, 10, 3, 5, 7};
        ArrayAdventures.remove(arr, 2);
        System.out.println(Arrays.toString(arr));

        // for removeAndShiftUp testing
        arr = new int[]{1, 10, 3, 5, 7};
        ArrayAdventures.removeAndShiftUp(arr, 2);
        System.out.println(Arrays.toString(arr));

        // for removeOddElements testing
        arr = new int[]{1, -10, 3, 7, 4};
        ArrayAdventures.removeOddElements(arr);
        System.out.println(Arrays.toString(arr));

        // for findRuns testing
        arr = new int[]{6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1};
        boolean[] result = ArrayAdventures.findRuns(arr);
        System.out.println(Arrays.toString(result));

        // for removeRuns testing
        arr = new int[]{6, 2, 5, 5, 5, 5, 4, 4, 5, 2, 2, 2, 1};
        ArrayAdventures.removeRuns(arr);
        System.out.println(Arrays.toString(arr));

        // for toString1D resting
        arr = new int[]{5, 56, 234235, 9867};
        String str1d = ArrayAdventures.toString1D(arr);
        System.out.println(str1d);

        // for toString1D testing
        int[][] newArr = new int[][]{{5, 56, 234235, 9867}, { 262, 39485, -10, 78}, { 56, 1, 9837, 8712}, { 87, -25, 0, 9820}};
        String str2d = ArrayAdventures.toString2D(newArr);
        System.out.println(str2d);

        // for swapRows testing
        newArr = new int[][]{{5, 56, 234235, 9867}, { 262, 39485, -10, 78}, { 56, 1, 9837, 8712}, { 87, -25, 0, 9820}};
        ArrayAdventures.swapRows(newArr, 1, 2);
        System.out.println(Arrays.deepToString(newArr));

        // for isIncreasing testing
        arr = new int[]{44, 70, 28, 91, 10};
        int[] indexes = new int[]{0, 1, 2};
        boolean increasing = ArrayAdventures.isIncreasing(arr, indexes);
        System.out.println(increasing);
        indexes = new int[]{4, 2, 3};
        increasing = ArrayAdventures.isIncreasing(arr, indexes);
        System.out.println(increasing);
    }
}
