import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public enum ItemType {
        BOOK, CD
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item search(String title) {
        for(Item item : items) {
            if (item.getTitle().equals(title)){
                return item;
            }
        }

        return null;
    }

    public void checkout(String title) {
        for(Item item : items) {
            if (item.getTitle().equals(title) && item.isAvailable()){
                item.setAvailable(false);
            }
        }

        throw new IllegalStateException("Book Not found or not available");
    }

    public void checkin(String title) {
        for(Item item : items) {
            if (item.getTitle().equals(title) && !item.isAvailable()) {
                item.setAvailable(true);
                return;
            }
        }

        throw new IllegalStateException("Book Not Found or is already available");
    }

    public List<Item> getList(ItemType type) {
        List<Item> found = new ArrayList<>();

        switch (type) {
            case BOOK:
                for(Item item : items) {
                    if (item instanceof Book) {
                        found.add(item);
                    }
                }

                return found;

            case CD:
                for(Item item : items) {
                    if (item instanceof CD) {
                        found.add(item);
                    }
                }

                return found;

            default:
                return found;
        }
    }

    @Override
    public String toString() {
        return "items=" + (Arrays.toString(Arrays.copyOfRange(items.toArray(),0, items.size()))) ;
    }
}
