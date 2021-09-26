import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Deposit: ");
        double deposit = scanner.nextDouble();

        System.out.print("Interest Rate: ");
        double interestRate = scanner.nextDouble() / 100;

        System.out.print("Weeks: ");
        int weeks = scanner.nextInt();
        int days = weeks * 7;
        
        double balance = deposit;

        for (int i = 1; i <= days; i++) {
            double interest = (balance * interestRate) / days;
            balance = balance + interest;
        }

        String formatted = String.format("Account balance: %.2f", balance);
        System.out.println(formatted);

        scanner.close();
    }
}
