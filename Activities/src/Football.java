import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Football {
    private String[] players;

    // constructor for custom file name
    public Football(String filePath) throws FileNotFoundException {
        this.players = readPlayersFromFile(filePath);
    }

    // constructor for default football names file
    public Football() throws FileNotFoundException {
        this.players = readPlayersFromFile("FootballNames.txt");
    }

    /**
     * Read all players from a file.
     *
     * @param filePath The file path of the file to read
     * @return Returns array of player names
     */
    private String[] readPlayersFromFile(String filePath) throws FileNotFoundException {
        // read the file if exist
        File numbersFile = new File(filePath);
        if (!numbersFile.exists()) {
            // the file did not exist return null immediately
            return null;
        }

        // read the file using scanner
        Scanner scanner = new Scanner(numbersFile);

        // initialize the array of strings which will contain all player names
        String[] names = new String[10];
        // starting index for names array
        int index = 0;

        // read each line
        while(scanner.hasNextLine()) {
            // read the current line and trim it.
            String line = scanner.nextLine().trim();

            // check if the line is a header line "Player Most Passing yards" or empty
            if (line.equalsIgnoreCase("player most passing yards") || line.isEmpty()) {
                // skip this since this is just a header line or line is empty
                continue;
            }

            // store the name and increment the index
            names[index++] = line;
        }

        // return the names array
        return names;
    }

    /**
     * Displays all Players ranked 1 through 10. The rank and name will be displayed.
     */
    public void displayPlayers() {
        if (this.players == null) {
            // no players exist or read so return immediately
            return;
        }

        // print the rank and player names
        for (int i = 0; i < this.players.length; i++) {
            // format the name and rank string for printing
            // the rank will be i + 1 since array index starts at 0.
            String detail = String.format("Player: %s \nRank: %d", this.players[i], (i + 1));
            // print
            System.out.println(detail);
        }
    }

    /**
     * Displays all Players ranked 10 through 1. The rank and name will be displayed.
     */
    public void displayPlayersReverse() {
        if (this.players == null) {
            // no players exist or read so return immediately
            return;
        }

        // print the rank and player names but start at the last item of the array
        for (int i = this.players.length - 1; i >= 0; i--) {
            // format the name and rank string for printing
            // the rank will be i + 1 since array index starts at 0.
            String detail = String.format("Player: %s \nRank: %d", this.players[i], (i + 1));
            // print
            System.out.println(detail);
        }
    }

    /**
     * Asks the user for a rank, and it will display the player that corresponds to the rank.
     */
    public void displayWinnersByNumber() {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);
        // prompt
        System.out.print("Enter rank: ");
        // get the rank, convert it to int, and store in variable
        int rank = Integer.parseInt(scanner.nextLine().trim());

        // call the overloaded displayWinnersByNumber method to find and print the player using the rank
        this.displayWinnersByNumber(rank);
    }

    /**
     * Displays all football players by number of rank.
     *
     * @param rank The rank of the football player.
     */
    public void displayWinnersByNumber(int rank) {
        if (this.players == null) {
            // no players exist or read so print that players array is empty
            System.out.print("There are no prayers in the list.");
            return;
        }

        if (rank >= this.players.length) {
            // exceeded the maximum rank of 10
            System.out.println("Invalid rank.");
            return;
        }

        // since index starts at 0, so we deduct 1 to access the player by index.
        String player = this.players[rank - 1];

        // format the name and rank string for printing
        String detail = String.format("Player: %s \nRank: %d", player, rank);
        // print
        System.out.println(detail);
    }

    /**
     * Asks the user for a football player, and it will display the player that corresponds to the name input.
     */
    public void findPlayers() {
        // scanner for getting the input
        Scanner scanner = new Scanner(System.in);
        // prompt
        System.out.print("Enter football player: ");
        // get the football player name
        String player = scanner.nextLine().trim();
        
        // call the overloaded findPlayers and pass the name of the player to print
        this.findPlayers(player);
    }

    /**
     * Displays all football players by name.
     *
     * @param player The name of the football player
     */
    public void findPlayers(String player) {
        if (this.players == null) {
            // no players exist or read so print that players array is empty
            System.out.print("There are no prayers in the list.");
            return;
        }

        // iterate and compare each player from the list to the player that we are looking for
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].equalsIgnoreCase(player)) {
                // found the player now print the name and rank
                // format the name and rank string for printing
                String detail = String.format("Player: %s \nRank: %d", player, (i + 1));
                // print
                System.out.println(detail);
                // immediately return
                return;
            }
        }

        // exhausted the list and did not found the football player
        System.out.println("Did not find the football player " + player);
    }
}
