public class MinMax {
    public static int count(int[] array1) {
        int len1 = 0;

        for (int x : array1) {
            len1++;
        }

        return len1;
    }

    public static double average(int[] array1) {
        int sum = 0;

        for (int i = 0; i < array1.length; i++) {
            sum += array1[i];
        }

        return (double)sum / count(array1);
    }

    public static int min1(int[] array1) {
        int min = array1[0];

        for (int i = 0; i < array1.length; i++) {
            if (min > array1[i])
                min = array1[i];
        }

        return min;
    }

    public static int max1(int[] array1) {
        int max = array1[0];

        for (int i = 0; i < array1.length; i++) {
            if (max < array1[i])
                max = array1[i];
        }

        return max;
    }

    public static void main(String[] args) {
        final int[] B = new int[] {50, 9, 76, 39, 70, 54};
        final int[] T = new int[] {120, 195, 82, 100};
        final int[] N = new int[] {114, 110, 111, 100, 90, 80, 100};

        System.out.println("------B------");
        System.out.println("count: " + count(B));
        System.out.println("average: " + average(B));
        System.out.println("minimum: " + min1(B));
        System.out.println("maximum: " + max1(B));
        System.out.println("------T------");
        System.out.println("count: " + count(T));
        System.out.println("average: " + average(T));
        System.out.println("minimum: " + min1(T));
        System.out.println("maximum: " + max1(T));
        System.out.println("------N------");
        System.out.println("count: " + count(N));
        System.out.println("average: " + average(N));
        System.out.println("minimum: " + min1(N));
        System.out.println("maximum: " + max1(N));
    }
}
