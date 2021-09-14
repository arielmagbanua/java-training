public class FizzBuzz {
    private int num;

    public FizzBuzz(int num) {
       this.num = num; 
    }

    // Sets the num
    public void setNum(int num) {
        this.num = num;
    }

    // Runs the fizz buzz loop
    public void run() {
        for(int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                // print Buzz if i is divisible by 3 only
                System.out.println("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                // print Buzz if i is divisible by 5 only
                System.out.println("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                // print Buzz if i is divisible both 3 and 5
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
