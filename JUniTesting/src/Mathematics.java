public class Mathematics {

    public static final double PI = Math.PI;

    public double getCircleArea(double d) {
        return PI * Math.pow(d, 2);
    }

    public int sumOfInts(int i) {
        // accumulator
        int sum = 0;

        // sum up all integers from 0 to i
        for (int x = 0; x <= i; x++) {
            sum += x;
        }

        return sum;
    }

    public boolean isPositive(int i) {
        // returns true if i is greater than 0 (meaning positive)
        // otherwise returns false (meaning negative)
        return i > 0;
    }

    public boolean isEven(int i) {
        // if divisible by 2 then it is even therefore it will return true,
        // and if not then probably odd therefore it will return false
        return i % 2 == 0;
    }

    public int sumOfEvens(int i) {
        // accumulator
        int sum = 0;

        if (isPositive(i)) {
            // sum up all even positive integers from 0 to i
            for (int x = 0; x <= i; x++) {
                if (isEven(x)) {
                    sum += x;
                }
            }
        } else {
            // sum up all even negative integers from 0 to i
            for (int x = 0; x >= i; x--) {
                if (isEven(x)) {
                    sum += x;
                }
            }
        }

        return sum;
    }
}
