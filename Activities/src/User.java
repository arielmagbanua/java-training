import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) throws FileNotFoundException {


        Scanner letter = new Scanner(new File("Letter.txt"));
        letter.useDelimiter("\\Z");
        String letterBody = letter.next();
        System.out.print(letterBody);
    }
}
