import java.util.List;

public class ShoeSearchEngine {
    public static void main(String[] args) {
        // prepare the store
        ShoeStore store = new ShoeStore();

        // prepare the shoes
        Shoe anneKlein = new Shoe("white", 11, "Anne Klein");
        Shoe calvinKlein = new Shoe("yellow", 13, "Calvin Klein");
        Shoe coach = new Shoe("black", 9, "COACH");
        Shoe clark = new Shoe("blue", 5, "CLARK");
        Shoe coleHan = new Shoe("black", 7, "Cole Han");
        Shoe fitLo = new Shoe("blue", 15, "FitFlo");
        Shoe clark2 = new Shoe("red", 9, "CLARK");

        // add the shoes
        store.add(anneKlein);
        store.add(calvinKlein);
        store.add(coach);
        store.add(clark);
        store.add(coleHan);
        store.add(fitLo);
        store.add(clark2);

        // print all shoes
        System.out.println(store);

        // Find all Shoe objects with CLARK as a brand in the ArrayList.
        List<Shoe> clarkShoes = store.findByBrand("CLARK");
        StringBuilder value = new StringBuilder();
        for (Shoe shoe : clarkShoes) {
            value.append(shoe + "\n");
        }
        System.out.println(value);

        // Find the largest size of a Shoe object in the ArrayList.
        Shoe largest = store.findLargestSize();
        System.out.println(largest);
    }
}
