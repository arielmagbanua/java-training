import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Question 1
        int[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        if (isFound(numArr, 2)) {
            System.out.println(2 + " is found!");
        } else {
            System.out.println(2 + " not found!");
        }

        if (isFound(numArr, 20)) {
            System.out.println(20 + " is found!");
        } else {
            System.out.println(20 + " not found!");
        }

        // Question 2
        numArr = new int[]{10, 20, 3, 4, 55, 67, 7, 80, 9, 90};
        int sum = addArr(numArr);
        System.out.println("Sum: " + sum);

        // Question 3
        numArr = new int[]{15, 20, 25, 30, 35, 40, 45, 50, 55, 60};
        System.out.println(Arrays.toString(numArr));
        int[] revNumArr = copyRev(numArr);
        System.out.println(Arrays.toString(revNumArr));

        // Question 4
        String[] strArr1 = {"Mark", "Mary", "Suzan", "William", "Luke"};
        String[] strArr2 = {"Suzan", "John", "Sarah", "Luke", "Heather"};
        printCommon(strArr1, strArr2);
    }

    // Question 1
    public static boolean isFound(int[] numArr, int x) {
        for (int i = 0; i < numArr.length; i++) {
            if (x == numArr[i]) {
                // found the number x therefore return true immediately
                return true;
            }
        }

        // did not find x, then return false
        return false;
    }

    // Question 2
    public static int addArr(int[] numArr) {
        int sum = 0;
        for (int i = 0; i < numArr.length; i++) {
            // add each number
            sum += numArr[i];
        }

        return sum;
    }

    // Question 3
    public static int[] copyRev(int[] numArr) {
        // create the reverse array same length with the original array
        int[] revNumArr = new int[numArr.length];

        // starting index of reverse array
        int revIndex = 0;

        // loop by starting at the last index of the array until the first index which is 0
        // ant then assign each number
        // this effectively reverses the order of the original array
        for (int i = numArr.length - 1; i >= 0; i--) {
            // assign each number
            revNumArr[revIndex] = numArr[i];

            // increment the reverse index
            revIndex++;
        }

        return revNumArr;
    }

    // Question 4
    public static void printCommon(String[] strArr1, String[] strArr2) {
        for (int i = 0; i < strArr1.length; i++) {
            for (int j = 0; j < strArr2.length; j++) {
                if (strArr1[i].equals(strArr2[j])) {
                    System.out.println(strArr1[i] + " is found in both arrays");
                }
            }
        }
    }
}
