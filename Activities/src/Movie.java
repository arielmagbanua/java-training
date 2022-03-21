import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String rating;
    private List<String> showtimes = new ArrayList<>();

    public Movie(String title, String rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void addShowTime(String showtime) {
        this.showtimes.add(showtime);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        // get the length of movie tile
        int titleLength = this.title.length();

        if (titleLength >= 44) {
            // truncate to 44 characters
            String title = this.title.substring(0, 44);
            // append the title
            stringBuilder.append(title);
        } else {
            // append the title
            stringBuilder.append(this.title);
            // calculate the remaining spaces
            int spaces = 44 - titleLength;
            // pad spaces to the right of the title
            stringBuilder.append(" ".repeat(spaces));
        }

        // add separator bar
        stringBuilder.append(" | ");

        // get the length of rating
        int ratingLength = this.rating.length();

        if (ratingLength >= 5) {
            // append the rating
            String rating = this.rating.substring(0, 5);
            stringBuilder.append(rating);
        } else {
            // get the number of spaces needed
            int spaces = 5 - ratingLength;
            // pad spaces first
            stringBuilder.append(" ".repeat(spaces));
            // append the rating
            stringBuilder.append(this.rating);
        }

        // add separator bar
        stringBuilder.append(" | ");

        // append each showtime
        for (String showtime : this.showtimes) {
            stringBuilder.append(showtime).append(" ");
        }

        // return the string from the builder
        return stringBuilder.toString().trim();
    }
}
