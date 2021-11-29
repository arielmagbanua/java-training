import java.text.DecimalFormat;

public class Loop {
    public static double halfOfMax(int a, int b) {
        if (a > b) {
            return a / 2.0;
        }

        return b / 2.0;
    }

    public static void main(String[] args) {
//        int i;
//        for (i=0;i<9;i++)
//        {
//            // to make the number start at -20
//            // and then increment by 5 you can multiply i with 5 and subtract by 20.
//            int number = (i * 5) - 20;
//
//            if (number != 0) {
//                // skip zero
//                System.out.println(number);
//            }
//        }

        double maxHalf = halfOfMax(7, 4);
        System.out.print("Half of the max is " + maxHalf);
        // System.out.printf("Half of the max is %.1f", maxHalf);

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
