import java.io.FileNotFoundException;

public class FootballTest {
    public static void main(String[] args) throws FileNotFoundException {
        Football football = new Football();

        football.displayPlayers();
        football.displayPlayersReverse();
        football.displayWinnersByNumber();
        football.findPlayers();
    }
}
