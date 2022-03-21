import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Movies {
    public static void main(String[] args) {
        File moviesCSV = new File("movies.csv");
        try {
            Scanner scanner = new Scanner(moviesCSV);

            // create map of name and Movie object to easily record showtimes against a movie
            Map<String, Movie> moviesMap = new LinkedHashMap<>();

            // read each line
            while(scanner.hasNextLine()) {
                // each line is expected to be comma separated
                String line = scanner.nextLine().trim();
                String[] strings = line.split(",");

                // get the movie title which is the second column
                String title = strings[1];

                // check the map if already exists
                if (moviesMap.containsKey(title)) {
                    // already exists therefore just add the showtime
                    moviesMap.get(title).addShowTime(strings[0]);
                } else {
                    // not yet exists therefore create a new movie object
                    Movie movie = new Movie(title, strings[2]);
                    // add the showtime
                    movie.addShowTime(strings[0]);
                    // add the movie to the map
                    moviesMap.put(title, movie);
                }
            }

            // iterate through each map ang then print the movies
            for (Map.Entry<String, Movie> set : moviesMap.entrySet()) {
                Movie movie = set.getValue();
                // print
                System.out.println(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }
    }
}
