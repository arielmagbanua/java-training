public class NanException extends Exception {
    public NanException() {
        // supply the default exception message to the parent constructor
        super("No square root for negative numbers make sure that b^2 is greater than 4*a*c");
    }
}
