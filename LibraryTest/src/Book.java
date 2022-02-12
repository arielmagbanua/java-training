public class Book extends Item implements Comparable<Book> {
    private String author;
    private int year;
    private String publisher;

    public Book(String id, String title, String author, int year, String publisher) {
        super(id, title);
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "id: " + getId() +
                "\ntitle: " + getTitle() +
                "\navailable: " + (isAvailable()?"Yes":"No")+
                "\nauthor: " + author +
                "\nyear: " + year  +
                "\npublisher: '" + publisher;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(o.getYear(), this.getYear());
    }
}
