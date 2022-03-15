import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Question 1
        // create array list and store the data
        ArrayList<Integer> numArr = new ArrayList<>();
        numArr.add(1);
        numArr.add(2);
        numArr.add(3);
        numArr.add(4);
        numArr.add(5);
        numArr.add(6);
        numArr.add(7);
        numArr.add(8);
        numArr.add(9);
        numArr.add(10);

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
        // create array list and store the data
        numArr = new ArrayList<>();
        numArr.add(10);
        numArr.add(20);
        numArr.add(3);
        numArr.add(4);
        numArr.add(55);
        numArr.add(67);
        numArr.add(7);
        numArr.add(80);
        numArr.add(9);
        numArr.add(90);
        int sum = addArr(numArr);
        System.out.println("Sum: " + sum);

        // Question 3
        // create array list and store the data
        numArr = new ArrayList<>();
        numArr.add(15);
        numArr.add(20);
        numArr.add(25);
        numArr.add(30);
        numArr.add(35);
        numArr.add(40);
        numArr.add(45);
        numArr.add(50);
        numArr.add(55);
        numArr.add(60);

        System.out.println(numArr);
        ArrayList<Integer> revNumArr = copyRev(numArr);
        System.out.println(revNumArr);

        // Question 4
        ArrayList<String> strArr1 = new ArrayList<>();
        strArr1.add("Mark");
        strArr1.add("Mary");
        strArr1.add("Suzan");
        strArr1.add("William");
        strArr1.add("Luke");

        ArrayList<String> strArr2 = new ArrayList<>();
        strArr2.add("Suzan");
        strArr2.add("John");
        strArr2.add("Sarah");
        strArr2.add("Luke");
        strArr2.add("Heather");

        printCommon(strArr1, strArr2);
    }

    // Question 1
    public static boolean isFound(ArrayList<Integer> numArr, int x) {
        for (int i = 0; i < numArr.size(); i++) {
            if (x == numArr.get(i)) {
                // found the number x therefore return true immediately
                return true;
            }
        }

        // did not find x, then return false
        return false;
    }

    // Question 2
    public static int addArr(ArrayList<Integer> numArr) {
        int sum = 0;
        for (int i = 0; i < numArr.size(); i++) {
            // add each number
            sum += numArr.get(i);
        }

        return sum;
    }

    // Question 3
    public static ArrayList<Integer> copyRev(ArrayList<Integer> numArr) {
        // create the reverse array same length with the original array
        ArrayList<Integer> revNumArr = new ArrayList<>();

        // loop by starting at the last index of the array until the first index which is 0
        // ant then assign each number
        // this effectively reverses the order of the original array
        for (int i = numArr.size() - 1; i >= 0; i--) {
            // assign each number
            revNumArr.add(numArr.get(i));
        }

        return revNumArr;
    }

    // Question 4
    public static void printCommon(ArrayList<String> strArr1, ArrayList<String> strArr2) {
        for (int i = 0; i < strArr1.size(); i++) {
            for (int j = 0; j < strArr2.size(); j++) {
                if (strArr1.get(i).equals(strArr2.get(j))) {
                    System.out.println(strArr1.get(i) + " is found in both arrays");
                }
            }
        }
    }
}
