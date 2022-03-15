import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        // declaring variables
        double celsius ,farienhiet , Kelvin , delisle , romer;

        Scanner keyboard = new Scanner(System.in);

        String YourName = "Josh Rickle";
        System.out.println("Temperature - "+YourName);

        // initialize to yes
        String yesNo = "Y";

        while (yesNo.equals("Y")) {
            System.out.print("Enter temperature in degrees Fahrenheit: ");
            // get the line temperation line input
            String fTemperature = keyboard.nextLine();
            // convert to double and store to the variable
            farienhiet = Double.parseDouble(fTemperature);

            // equations
            celsius= (farienhiet - 32 ) * (5/9.0);
            Kelvin= celsius + 273.15;
            delisle= (212 - farienhiet) * (5/6.0);
            romer = (farienhiet - 32) * (7/24.0) + 7.5;

            // results
            System.out.println(farienhiet + " degrees Fahrenheit = " + Math.round(celsius*10000)/10000.0d + " degrees Celsius");
            System.out.println(farienhiet + " degrees Fahrenheit = " + Math.round(Kelvin*10000)/10000.0d + " kelvins ");
            System.out.println(farienhiet + " degrees Fahrenheit = " + Math.round(delisle*10000)/10000.0d + " degrees Delisle");
            System.out.println(farienhiet + " degrees Fahrenheit = " + Math.round(romer*10000)/10000.0d + " degrees Romer");

            // change yesNo to blank
            yesNo = "";

            // ask again user if he/she wants to continue and handle on Y and N input.
            while (yesNo.isEmpty()) {
                // get user Y or N input
                System.out.print("Do you want to continue? (Y/N): ");
                yesNo = keyboard.nextLine().trim();

                if (!yesNo.equals("Y") && !yesNo.equals("N")) {
                    // wrong user input therefore set yesNo back to empty to ask again
                    System.out.println("Sorry wrong input, please input only Y or N.");
                    yesNo = "";
                }
            }
        }


    }// main
}
