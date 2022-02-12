public class CD extends MediaItem implements Comparable<CD> {
    private String artist;
    private String genre;

    public CD(String id, String title, double runtime, String artist, String genre) {
        super(id, title, runtime);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        // get the parent to string value
        String parent = super.toString();

        // append the artisan and genre
        return String.format("%s\nArtist: %s\nGenre: %s", parent, this.getArtist(), this.getGenre());
    }

    @Override
    public int compareTo(CD o) {
        // compare by artist
        int artistResult = this.getArtist().compareTo(o.getArtist());
        if (artistResult != 0) {
            // they are not equal therefore no need to compare the genre
            return artistResult;
        }

        // at this point since same artist now compare the genre
        return this.getGenre().compareTo(o.getGenre());
    }
}
