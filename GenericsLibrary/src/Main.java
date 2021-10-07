import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create libraries
        Library<Video> videoLibrary = new Library<>(Video.class, "videos.json");
        Library<Book> bookLibrary = new Library<>(Book.class, "books.json");
        Library<Newspaper> newspaperLibrary = new Library<>(Newspaper.class, "newspapers.json");

        Scanner scanner = new Scanner(System.in);

        // get the username
        System.out.print("Username: ");
        String username = scanner.nextLine();

        while (true) {
            System.out.print("Select Library (1 - videos, 2 - books, 3 - newspapers): ");
            int lib = scanner.nextInt();
            scanner.nextLine(); // needed to prevent skipping

            if (lib != 1 && lib != 2 && lib != 3) {
                System.out.println("Sorry wrong library!");
                break;
            }

            System.out.print("Name: ");
            String mediaName = scanner.nextLine();
            LibraryMedia media = null;

            // search the library
            switch (lib) {
                case 1:
                    media = videoLibrary.search(mediaName);
                    break;
                case 2:
                    media = bookLibrary.search(mediaName);
                    break;
                case 3:
                    media = newspaperLibrary.search(mediaName);
                    break;
                default:
                    media = null;
            }

            if (media != null) {
                String status = media.checkOutStatus();
                if (status != null) {
                    // the media was checked out or borrowed
                    System.out.println("Sorry you can't borrow this media resource.");
                    System.out.println(status);
                }

                // let user borrow it
                System.out.print("Checkout? (y/n): ");
                String choice = scanner.nextLine().toLowerCase();

                // check if user did have correct input
                if (!choice.equals("y") && !choice.equals("n")) {
                    System.out.println("Sorry invalid choice!");
                    continue;
                }

                if (choice.equals("y")) {  // user want to borrow and checkout the media resource
                    // get the calendar
                    Calendar calendar = Calendar.getInstance();

                    // get the date to day
                    String outDate = new SimpleDateFormat(LibraryMedia.DATE_FORMAT).format(calendar.getTime());
                    // get the date 2 weeks from now
                    calendar.add(Calendar.DATE, 14);
                    String dueDate = new SimpleDateFormat(LibraryMedia.DATE_FORMAT).format(calendar.getTime());

                    media.checkOutTo(username, outDate, dueDate);
                    System.out.println("You have successfully checkout out the resource.");
                    System.out.println(media.checkOutStatus());
                }
            }
        }

        // save all the changes
        videoLibrary.save();
        bookLibrary.save();
        newspaperLibrary.save();
    }
}
