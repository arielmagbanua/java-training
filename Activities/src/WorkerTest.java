public class WorkerTest {
    public static void main(String[] args) {
        Worker johnSmith = new Worker("John Smith", 123456, 25.40, false);
        johnSmith.printDetails();

        // change to full time
        johnSmith.setFullTime(true);
        johnSmith.printDetails();
    }
}
