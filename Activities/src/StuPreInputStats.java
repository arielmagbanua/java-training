import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StuPreInputStats {
    public static void main(String[] args) {
        // scanner for user input
        Scanner scanner = new Scanner(System.in);

        // lists for different rating types
        List<Integer> likedList = new ArrayList<>(); // for liked
        List<Integer> neutralList = new ArrayList<>(); // for neutral
        List<Integer> dislikedList = new ArrayList<>(); // for disliked
        List<Integer> invalidList = new ArrayList<>(); // for invalid

        // print the message prompt
        System.out.println("Please enter the ratings (end with a negative value):");

        // use infinite while loop to continually get input number until user inputs negative
        while (true) {
            // get rating, convert it to int, and then store it in a variable
            int rating = Integer.parseInt(scanner.nextLine());

            if (rating < 0) {
                // negative rating, therefore terminate the loop
                break;
            }

            switch (rating) {
                case 4:
                case 5:
                    // the rating is 4 ~ 5, therefore add the rating to likedList
                    likedList.add(rating);
                    break;
                case 3:
                    // the rating is 3, therefore add the rating to neutralList
                    neutralList.add(rating);
                    break;
                case 2:
                case 1:
                case 0:
                    // the rating is 0 ~ 2, therefore add the rating to dislikedList
                    dislikedList.add(rating);
                    break;
                default:
                    // did not fall to any valid rating therefore add rating to invalidList
                    invalidList.add(rating);
            }
        }

        // calculate the total number of ratings
        int totalRatingsCount = likedList.size() + neutralList.size() + dislikedList.size() + invalidList.size();

        // print total ratings
        System.out.println("Total # of ratings: " + totalRatingsCount);

        // calculate the percentage for liked ratings
        double likedPercentage = ((double) likedList.size() / (double) totalRatingsCount) * 100.0;
        // format the percentage and print it
        System.out.printf("Positive ratings (4~5): %d (%.0f%%)\n", likedList.size(), likedPercentage);

        // calculate the percentage for neutral ratings
        double neutralPercentage = ((double) neutralList.size() / (double) totalRatingsCount) * 100.0;
        // format the percentage and print it
        System.out.printf("Neutral ratings (3): %d (%.0f%%)\n", neutralList.size(), neutralPercentage);

        // calculate the percentage for disliked ratings
        double dislikedPercentage = ((double) dislikedList.size() / (double) totalRatingsCount) * 100.0;
        // format the percentage and print it
        System.out.printf("Negative ratings (3): %d (%.0f%%)\n", dislikedList.size(), dislikedPercentage);

        // calculate the percentage for invalid ratings
        double invalidPercentage = ((double) invalidList.size() / (double) totalRatingsCount) * 100.0;
        // format the percentage and print it
        System.out.printf("Invalid ratings (3): %d (%.0f%%)\n", invalidList.size(), invalidPercentage);
    }
}
