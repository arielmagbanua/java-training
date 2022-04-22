import java.util.ArrayList;
import java.util.List;

public class InventoryDemo {
    private static List<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        // create products and tools by creating each instances and adding them to inventory list
        inventory.add(new Car("Jaguar", 100000.00));
        inventory.add(new Car("Neon", 17000.00));
        inventory.add(new Tool("Jigsaw", 149.18));
        inventory.add(new Car("Jaguar", 110000.00));
        inventory.add(new Car("Neon", 17500.00));
        inventory.add(new Car("Neon", 17875.32));
        inventory.add(new Truck("RAM", 35700.00));
        inventory.add(new Tool("CircularSaw", 200.00));
        inventory.add(new Tool("CircularSaw", 150.00));

        // print the products with quantity and total cost
        takeInventory("Jigsaw");
        takeInventory("Neon");
        takeInventory("Jaguar");
        takeInventory("RAM");
        takeInventory("CircularSaw");

        // create saw1 and saw2
        Tool saw1 = new Tool("Saw", 12.00);
        Tool saw2 = new Tool("Saw", 15.00);

        // compare saw1 and saw2
        int testCompare = saw1.compareTo(saw2);

        if (testCompare < 0) {
            // if negative, this means the current item that is comparing to the other is smaller.
            System.out.println("The second " + saw2.getName() + " is more expensive");
        } else if (testCompare > 0) {
            // if positive, this means the current item that is comparing to the other is bigger.
            System.out.println("The first " + saw1.getName() + " is more expensive");
        } else {
            // if zero, this means that both items are equal.
            System.out.println("They both have an equal price");
        }
    }

    public static void takeInventory(String name) {
        int quantity = 0;
        double totalCost = 0;

        // iterate each inventory products
        for (Product product : inventory) {
            // check if the current product is same name that was passed
            if (product.getName().equals(name)) {
                // increment the quantity
                ++quantity;
                // add the cost of the product to the total cost
                totalCost += product.getCost();
            }
        }

        // print the name of the product and the totals
        String displayText = String.format("%s: Quantity: %s, Total cost = %s", name, quantity, totalCost);
        System.out.println(displayText);
    }
}
