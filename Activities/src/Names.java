import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        // scanner for inputs
        Scanner scanner = new Scanner(System.in);

        // get the first name from the console
        System.out.print("Please, enter your first name: ");
        String firstName = scanner.nextLine();

        // promp the user for the names of the friends
        System.out.println("Please, insert the first names of your friends (enter \"stop\" to stop your program):");

        // list of strings to hold the name inputs
        List<String> friendsNames = new ArrayList<>();

        // infinitely loop and ask for names until input is "stop"
        while (true) {
            // get the name from the console
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("stop")) {
                // the user want to stop so break the loop
                break;
            }

            // store the names to the list
            friendsNames.add(name);
        }

        // iterate each of the names and count the name has same first name of the user
        int count = 0;
        for (String friendName : friendsNames) {
            if (friendName.equalsIgnoreCase(firstName)) {
                // the current friend name is same with user's first name therefore increment count
                ++count;
            }
        }

        // print the result
        System.out.printf("%d of your friends their first names are identical to your first name", count);
    }
}
