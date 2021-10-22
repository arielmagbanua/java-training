import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner for reading
        Scanner scanner = new Scanner(System.in);

        // Create array List of captains
        List<Captain> captains = new ArrayList<>();

        // Removed captains
        List<Captain> removed = new ArrayList<>();

        // Read 5 captains
        int captainCount = 0;

        // Read 5 captains and add each to the ArrayList
        while (captainCount < 5) {
            String input = scanner.nextLine();
            String[] segments = input.split(" ");

            // create an instance of a captain
            Captain captain = new Captain(Integer.parseInt(segments[0]), segments[1], Integer.parseInt(segments[2]), Integer.parseInt(segments[3]));
            // add to array list
            captains.add(captain);
            captainCount++;
        }

        // remove the youngest captains
        Captain youngest1 = youngestCaptain(captains);
        captains.remove(youngest1);

        // add the newly removed captain to removed list
        removed.add(youngest1);

        Captain youngest2 = youngestCaptain(captains);
        captains.remove(youngest2);

        // add the newly removed captain to removed list
        removed.add(youngest2);

        // print the removed
        System.out.println("Removed the following captains:");
        printCaptains(removed);

        // print the remaining captains
        System.out.println("Captains left:");
        printCaptains(captains);

        scanner.close();
    }

    static void printCaptains(List<Captain> captains) {
        for (Captain captain : captains) {
            System.out.printf("%s, age: %d \nYoE: %d \nRegistry: %d%n\n", captain.getName(), captain.getAge(), captain.getYearsOfExperience(), captain.getRegistryNumber());
        }
    }

    static Captain youngestCaptain(List<Captain> captains) {
        // clone the object to avoid altering it directly
        List<Captain> captainList = new ArrayList<>();
        captainList.addAll(captains);

        // sort captain age by age
        Collections.sort(captainList, Comparator.comparing(Captain::getAge));

        // return the youngest
        return captainList.get(0);
    }
}
