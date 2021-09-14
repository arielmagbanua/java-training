import java.util.Scanner;

class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // Input a positive integer in one line. This will serve as the ending point of
        // your loop.
        int num = scanner.nextInt();

        // // create the instance f FizzBuzz
        FizzBuzz fizzBuzz = new FizzBuzz(num);
        fizzBuzz.run();

        scanner.close();
    }
}
