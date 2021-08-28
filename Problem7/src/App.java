import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the input
        String inputs = scanner.nextLine();

        // split the input
        String[] inputNumbers = inputs.split(" ");

        // convert the numbers to float
        // first index is the weight
        // second index is the height
        float weight = Float.parseFloat(inputNumbers[0]);
        float height = Float.parseFloat(inputNumbers[1]);

        // calculate the body mass index
        float bmi = 703 * (weight / (height * height));

        // format the output
        String output = String.format("%.1f", bmi);

        if (bmi >= 18.5 && bmi <= 24.9) {
            // Those with scores between 18.5–24.9 (inclusive) are of normal weight.
            System.out.print(output + " normal weight");
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            // Those with scores between 25–29.9 (inclusive) are said to be overweight.
            System.out.print(output + " overweight");
        } else if (bmi >= 30.0) {
            // Those with scores 30 or higher are obese.
            System.out.print(output + " obese");
        } else {
            // people with BMI scores that are less than 18.5 are said to be underweight.
            System.out.print(output + " underweight");
        }

        scanner.close();
    }
}
