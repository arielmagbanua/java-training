import java.util.Arrays;

public class Exercises {
    public int[] expandAndCopyArray(int [] orig) {
        // create the new array which is 50% bigger than the original
        int[] numbers = new int[orig.length + orig.length / 2];

        // copy each original items to the new array
        for (int i = 0; i < orig.length; i++) {
            numbers[i] = orig[i];
        }

        // return the new array
        return numbers;
    }

    public int perrinNumber(int n) {
        // return new value depending on the value of n
        if (n == 0) {
            return 3;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }

        // continue calculating the sum
        return perrinNumber(n - 2) + perrinNumber(n - 3);
    }

    public static void main(String[] args) {
        // create new instance of the Exercises class in order to test the methods
        Exercises exercises = new Exercises();

        // test expandAndCopyArray
        int[] numbers1 = new int[]{1, 10};
        // print the original
        System.out.println(Arrays.toString(numbers1));
        int[] result1 = exercises.expandAndCopyArray(numbers1);
        // print the expanded
        System.out.println(Arrays.toString(result1));
        int[] numbers2 = new int[]{1, 10, 2, 10};
        // print the original
        System.out.println(Arrays.toString(numbers2));
        int[] result2 = exercises.expandAndCopyArray(numbers2);
        // print the expanded
        System.out.println(Arrays.toString(result2));

        // test perrinNumber
        System.out.println(exercises.perrinNumber(0));
        System.out.println(exercises.perrinNumber(1));
        System.out.println(exercises.perrinNumber(2));
        System.out.println(exercises.perrinNumber(3));
    }
}
