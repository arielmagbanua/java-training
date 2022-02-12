import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class to test the methods from Libary and
 * provides a user interface
 * DON'T MODIFY THIS CODE, other than to comment out portions to test
 * your code
 * TCSS 143
 */
public class LibraryTest {
    // Display the library menu to add/checkout/checkin/search/print
    private static void displayMenu() {
        System.out.println("\n\nLibrary Menu");
        System.out.println("1. Add a new item");
        System.out.println("2. Checkout an item");
        System.out.println("3. Checkin an item");
        System.out.println("4. Search for an item by title");
        System.out.println("5. Print all books");
        System.out.println("6. Print all books sorted");
        System.out.println("7. Print all CDs");
        System.out.println("8. Print all CDs sorted");
        System.out.println("9. Print all inventory");
        System.out.println("10. Exit");

    }

    // Gets a valid user input between 1 and 10
    private static int getChoice(Scanner console) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("\nEnter a choice: ");
                input = Integer.parseInt(console.nextLine());
                if (input < 1 || input > 10) {
                    System.out.println("Please enter a number between 1 and 10");
                    valid = false;
                } else {
                    valid = true;
                }
            } catch (Exception pe) {
                System.out.println("Please enter a number between 1 and 10");
                valid = false;
            }
        }
        return input;
    }

    // Asks user input for Book or CD
    private static Library.ItemType getItemType(Scanner console) {
        boolean valid = false;
        Library.ItemType type = null;
        while (!valid) {
            try {
                System.out.print("Enter 1 for Book, 2 for CD: ");


                int i = Integer.parseInt(console.nextLine());
                if (i == 1)
                    type = Library.ItemType.BOOK;
                else
                    type = Library.ItemType.CD;
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid type");
                valid = false;
            }
        }
        return type;
    }

    // Gets user input for all Book data and returns a new Book object
    private static Book getBookData(Scanner console, String id, String title) {
        boolean valid = false;
        System.out.print("Enter author: ");
        String author = console.nextLine();
        int year = 0;
        while (!valid) {
            try {
                System.out.print("Enter year: ");
                year = Integer.parseInt(console.nextLine());
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid year");
                valid = false;
            }
        }
        System.out.print("Enter publisher: ");
        String publisher = console.nextLine();
        return new Book(id, title, author, year, publisher);
    }

    // Gets user input for all CD data and returns a new CD object
    private static CD getCDData(Scanner console, String id, String title) {
        boolean valid = false;
        System.out.print("Enter artist: ");
        String artist = console.nextLine();
        double runtime = 0;
        while (!valid) {
            try {
                System.out.print("Enter runtime: ");
                runtime = Double.parseDouble(console.nextLine());
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid runtime");
                valid = false;
            }
        }
        System.out.print("Enter genre: ");
        String genre = console.nextLine();
        return new CD(id, title, runtime, artist, genre);
    }


    // Get input data for each item corresponding to a book or cd
    private static Item getInputForItem(Scanner console) {
        // Book or CD?
        Library.ItemType type = getItemType(console);

        // Get input for item details
        Item item = null;
        System.out.print("Enter id: ");
        String id = console.nextLine();
        System.out.print("Enter title: ");
        String title = console.nextLine();

        if (type == Library.ItemType.BOOK) {
            item = getBookData(console, id, title);
        } else if (type == Library.ItemType.CD) {
            item = getCDData(console, id, title);
        }
        return item;
    }

    // Searches the library for the item, prints not found
    // Or item information, if successful
    private static void searchByTitle(Library library, Scanner console) {
        System.out.print("Enter a title to search: ");
        String searchTitle = console.nextLine();
        Item item = library.search(searchTitle);
        if (item == null) {
            System.out.println("Title not found");
        } else {
            System.out.println("Title found: " + item);
        }
    }

    // Allows to checkin or checkout an item
    private static void checkInOrOutItem(Library library, Scanner console, String
            inOrOut) {
        System.out.print("Enter title to check " + inOrOut + ": ");
        String title = console.nextLine();
        try {
            if (inOrOut.equals("out")) {
                library.checkout(title);
                System.out.println("Checkout successful");
            } else {
                library.checkin(title);
                System.out.println("Checkin successful");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Prints books or CDs in sorted or unsorted format
    private static void printList(Library library, Library.ItemType type, boolean sorted) {
        List<Item> itemList = library.getList(type);

        if (type == Library.ItemType.BOOK) {
            // Retrieve all books from the inventory
            List<Book> bookList = new ArrayList<Book>();
            for (Item i : itemList) {
                bookList.add((Book) i);
            }

            // Sort if need to be
            if (sorted) {
                Collections.sort(bookList);
            }

            System.out.println(bookList);
        } else {
            // Retrieve all CDs from the inventory
            List<CD> CDList = new ArrayList<CD>();

            for (Item i : itemList) {
                CDList.add((CD) i);
            }

            // Sort if need to be
            if (sorted) {
                Collections.sort(CDList);
            }

            System.out.println(CDList);
        }
    }

    // Creates some objects and provides a user interface to
    // to interact with the library system
    public static void main(String[] args) {
        Library library = new Library();
        // Adding some books and cds
        library.addItem(new Book("B100", "Building Java Programs", "Reges & Stepp", 2020, " Pearson"));
        library.addItem(new Book("B101", "Introduction to Computing", "Patt & Patel", 2019, " Wiley"));
        library.addItem(new Book("B102", "Learning Python", "Lutz", 2013, "O'Riley"));
        library.addItem(new CD("C100", "30", 58, "Adele", "Rock"));
        library.addItem(new CD("C101", "Motown Classics Gold", 120, "Various", "Soul"));
        library.addItem(new CD("C102", "Born This Way", 15, "Lady Gaga", "Pop"));
        library.addItem(new CD("C103", "Fleetwood Mac", 40, "Various", "Rock"));

        Scanner console = new Scanner(System.in);

        while (true) {
            displayMenu();
            int input = getChoice(console);

            switch (input) {
                case 1:
                    Item item = getInputForItem(console);
                    library.addItem(item);
                    break;
                case 2:
                    checkInOrOutItem(library, console, "out");
                    break;
                case 3:
                    checkInOrOutItem(library, console, "in");
                    break;
                case 4:
                    // Search the library, prints not found or the item information
                    searchByTitle(library, console);
                    break;
                case 5:
                    // Print all books
                    printList(library, Library.ItemType.BOOK, false);
                    break;
                case 6:
                    // Prints all books sorted
                    printList(library, Library.ItemType.BOOK, true);
                    break;
                case 7:
                    // Print all CDs
                    printList(library, Library.ItemType.CD, false);
                    break;
                case 8:
                    // Print all CDs sorted
                    printList(library, Library.ItemType.CD, true);
                    break;
                case 9:
                    // Print all items
                    System.out.println(library);
                    break;
                case 10:
                    // Exit
                    return;
            }
        }
    }
}
