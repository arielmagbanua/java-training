import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // scanner
        Scanner scanner = new Scanner(System.in);

        // get the input
        int roadType = scanner.nextInt();
        float totalDistanceInMeters = scanner.nextFloat();
        float totalTimeInMinutes = scanner.nextFloat();

        // convert to km and hours
        float totalDistanceInKm = totalDistanceInMeters / 1000;
        float totalTimeInHours = totalTimeInMinutes / 60;

        // km / h
        float speed = totalDistanceInKm / totalTimeInHours;

        String output = String.format("%.2f", speed);

        if (roadType == 1) {
            // the road is highway speed limit is 60.
            if (speed <= 60) {
                System.out.print(output + " within-speed-limit");
            } else {
                System.out.print(output + " over-speeding");
            }
        } else if (roadType == 2) {
            // the road is express way the speed limit is 100 km/h.
            // but if you go under 40 km/h it is under-speeding
            if (speed <= 40) {
                System.out.print(output + " under-speeding");
            } else if (speed > 40 && speed <= 100) {
                System.out.print(output + " within-speed-limit");
            } else {
                System.out.print(output + " over-speeding");
            }
        }

        scanner.close();
    }
}
