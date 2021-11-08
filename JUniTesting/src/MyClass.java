public class MyClass {
    public static int compute(int a, int b, int c) {
        if (a >= 0 && b >= 0 && c >= 0) {
            return a * b * c;
        } else {
            return -1;
        }
    }
}
