public class Recording {
    // properties
    private String title;
    private String artist;
    private int time;
    private int year;

    public Recording(String title, String artist, int time, int year) {
        this.title = title;
        this.artist = artist;
        this.time = time;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * String representation of this recording.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %d, %d", title, artist, time, year);
    }
}
