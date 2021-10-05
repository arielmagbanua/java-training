import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int lotteryNumber = scanner.nextInt();
        int identityNumber = scanner.nextInt();

        String lotteryNumbers = lotteryNumber + "";
        String[] lottery = lotteryNumbers.split("");

        int counter = 0;
        for (String numString : lottery) {
            int lotteryNum = Integer.parseInt(numString);

            if (lotteryNum == identityNumber) {
                counter++;
            }
        }

        if (counter == lottery.length) {
            System.out.println("Jackpot!");
        } else {
            System.out.println("Nah");
        }

        scanner.close();
    }
}
