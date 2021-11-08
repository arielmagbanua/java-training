import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RecordingSort {
    static Recording createRecording(Scanner scanner) {
        // gather recording information from user inputs
        System.out.print("Enter the Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the name of the Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter the no of seconds: ");
        int time = scanner.nextInt();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // create new recording and return it
        return new Recording(title, artist, time, year);
    }

    public static void main(String[] args) {
        // scanner for user input
        Scanner scanner = new Scanner(System.in);

        // list of recordings
        List<Recording> recordings = new ArrayList<>();

        // create 5 recordings
        for (int i = 1; i <= 5; i++) {
            System.out.println("Recording #" + i);
            // create recording from user inputs
            Recording recording = createRecording(scanner);
            // do a nextLine to prevent skipping of input in succeeding inputs
            scanner.nextLine();
            // add recording to the list
            recordings.add(recording);

            // add some spaces
            System.out.println("\n");
        }

        while (true) {
            // add some spaces
            System.out.println("\n");

            // print menu
            System.out.println("1. Sort by song Title.");
            System.out.println("2. Sort by Artist.");
            System.out.println("3. Sort by Playing Time.");
            System.out.println("4. Sort by Year.");
            System.out.println("5. Exit.");

            // add some spaces
            System.out.println("\n");

            // get the choice from console
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                // user wants to exit therefore break the loop
                break;
            }

            // add some spaces
            System.out.println("\n");

            switch (choice) {
                case 1:
                    // sort by title
                    System.out.println("___________Sorting based on Title __________");
                    recordings.sort(Comparator.comparing(Recording::getTitle));
                    break;
                case 2:
                    // sort by artist
                    System.out.println("___________Sorting based on Artist __________");
                    recordings.sort(Comparator.comparing(Recording::getArtist));
                    break;
                case 3:
                    // sort by playing time
                    System.out.println("___________Sorting based on Time __________");
                    recordings.sort(Comparator.comparing(Recording::getTime));
                    break;
                case 4:
                    // sort by year
                    System.out.println("___________Sorting by Year __________");
                    recordings.sort(Comparator.comparing(Recording::getYear));
                    break;
            }

            // print the sored recordings
            for (Recording recording : recordings) {
                System.out.println(recording);
            }
        }

        // close scanner
    }
}
