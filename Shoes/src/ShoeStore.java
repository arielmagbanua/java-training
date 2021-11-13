import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShoeStore {
    private final List<Shoe> shoes = new ArrayList<>();

    public ShoeStore() {

    }

    public ShoeStore(List<Shoe> shoes) {
        if (shoes != null) {
            this.shoes.addAll(shoes);
        }
    }

    public void add(Shoe shoe) {
        this.shoes.add(shoe);
    }

    public List<Shoe> findByBrand(String brand) {
        List<Shoe> foundShoes = new ArrayList<>();

        for (Shoe shoe : shoes) {
            if (shoe.getBrand().equals(brand)) {
                foundShoes.add(shoe);
            }
        }

        return foundShoes;
    }

    public Shoe findLargestSize() {
        List<Shoe> tempShoes = new ArrayList<>(shoes);

        tempShoes.sort(Comparator.comparing(Shoe::getSize));

        return tempShoes.get(tempShoes.size() - 1);
    }

    /**
     * The string representation of store for printing. In which it will build all string representation of shoes.
     *
     * @return The string that represents this store.
     */
    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();

        for (Shoe shoe : shoes) {
            value.append(shoe + "\n");
        }

        return value.toString();
    }
}
