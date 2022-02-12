import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CDTest {
    public static void main(String[] args) {
        CD cd = new CD("CD1122", "Superman", 3.5, "Five for Fighting", "Rock");
        cd.setArtist("Nope");
        System.out.println(cd.getArtist());
        cd.setGenre("Ballad");
        System.out.println(cd.getGenre());
        System.out.println(cd);

        CD song = new CD("CD1123", "Turagsoy", 3.5, "Max Surban", "Country");

        List<CD> songs = new ArrayList<>();
        songs.add(cd);
        songs.add(song);

        Collections.sort(songs);

        System.out.println(songs);
    }
}
