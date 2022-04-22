import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EarthquakeTester {

    private static final List<Earthquake> earthquakes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // get the file names from the user input
        System.out.print("Earthquakes file: ");
        String fileName = scanner.nextLine();
        System.out.print("Errors file: ");
        String errorFileName = scanner.nextLine();
        System.out.print("Sorted file: ");
        String sortedFileName = scanner.nextLine();

        readFromEarthQuakesCSVFile(fileName, errorFileName);

        earthquakes.forEach(e -> {
            System.out.println();
            if (e instanceof Classified) {
                System.out.println(e);
                System.out.println("Magnitude Class: " + ((Classified) e).getMagnitudeClass());
            } else {
                System.out.println(e);
            }
        });

        earthquakes.sort(new Comparator<Earthquake>() {
            @Override
            public int compare(Earthquake o1, Earthquake o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        saveFileToSortedTextFile(sortedFileName);
    }

    private static void saveFileToSortedTextFile(String fileName) throws IOException {
        new FileOutputStream(fileName).close();

        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (Earthquake e : earthquakes) {
            writer.printf(String.format("%s,%.2f,%.2f,%.2f,%s,%s%n",
                    e.getDateTimeZ(),
                    e.getLatitude(),
                    e.getLongitude(),
                    e.getMagnitude(),
                    e.getId(),
                    e.getPlace()
            ));
        }
        writer.close();
    }

    private static void readFromEarthQuakesCSVFile(String fileName, String errorFileName) throws IOException {

        // TODO(Please include the path of the file name like this)
        // C:\\Users\\others\\IdeaProjects\\CourseHero\\src\\com\\company\\ch51_70\\CompProgAssignPh1\\earthquakescsv.txt
        Scanner fileReader = new Scanner(new File(fileName));

        int errorLine = 1;

        while (fileReader.hasNextLine()) {
            String[] tokens = fileReader.nextLine().trim().split(",");
            String dateTimeZ = tokens[0];
            if (dateTimeZ.trim().length() <= 0 || dateTimeZ.trim().length() > 24) {
                writeErrorToInvalidInputTextFile("Date Time Zone should be 24 characters long.", errorFileName, errorLine);
            }
            double latitude = Double.parseDouble(tokens[1]);
            if (latitude < -90 || latitude > 90) {
                writeErrorToInvalidInputTextFile("Latitude should be from -90 to 90", errorFileName, errorLine);
            }
            double longitude = Double.parseDouble(tokens[2]);
            if (longitude < -180 || longitude > 180) {
                writeErrorToInvalidInputTextFile("Longitude should be from -180 to 180", errorFileName, errorLine);
            }
            double magnitude = Double.parseDouble(tokens[3]);
            if (magnitude < -1 || magnitude > 10) {
                writeErrorToInvalidInputTextFile("Magnitude should be from -1 to 10", errorFileName, errorLine);
            }
            String id = tokens[4];
            if (isIdAlreadyExisting(id)) {
                writeErrorToInvalidInputTextFile("ID Should be unique", errorFileName, errorLine);
            }
            String place = tokens[5];
            Earthquake classified = new Classified(dateTimeZ, latitude, longitude, magnitude, id, place);
            if (((Classified) classified).getMagnitudeClass() == null) {
                earthquakes.add(new NonClassified(dateTimeZ, latitude, longitude, magnitude, id, place));
            } else {
                earthquakes.add(classified);
            }

            errorLine++;
        }
    }

    private static void writeErrorToInvalidInputTextFile(String errorMessage, String errorFileName, int errorLine) throws IOException {
        new FileOutputStream(errorFileName).close();

        PrintWriter writer = new PrintWriter(new FileWriter(errorFileName));

        writer.printf("%s on line number %d in earthquakescsv.txt file%n",
                errorMessage,
                errorLine
        );
        writer.close();
    }

    private static boolean isIdAlreadyExisting(String id) {
        for (Earthquake e : earthquakes) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
