public class PlaceTest {
    public static void main(String[] args) {
        Place baltimore = new Place("Baltimore", "Maryland");
        Place orlando = new Place("Orlando", "Florida");
        Place clarion = new Place("Clarion", "Pennsylvania");
        Place pittsburgh = new Place("Pittsburgh", "Pennsylvania");

        RecreationPlace theNevermoreHaunt = new RecreationPlace("The Nevermore Haunt", "Haunted House", 30, baltimore);
        RecreationPlace disney = new RecreationPlace("Disney", "Amusement Park", 25, orlando);

        System.out.println(theNevermoreHaunt);
        System.out.println(disney);

        RecreationPlace testPlace1 = new RecreationPlace();
        testPlace1.setName("Room");
        testPlace1.setType("Escape Room");
        testPlace1.setPrice(25);
        testPlace1.setPlace(clarion);
        System.out.println(testPlace1);

        // create copy of testPlace1
        RecreationPlace testPlace1Copy = testPlace1.copy();
        // use the copy in the constructor
        RecreationPlace testPlace2 = new RecreationPlace(testPlace1Copy);
        System.out.println(testPlace2);

        RecreationPlace testPlace3 = new RecreationPlace("Kenwood", 45, pittsburgh);
        System.out.println(testPlace3);

        System.out.println("Is theNevermoreHaunt == testPlace3? " + theNevermoreHaunt.equals(testPlace3));
        System.out.println("Is theNevermoreHaunt == theNevermoreHaunt copy? " + theNevermoreHaunt.equals(theNevermoreHaunt.copy()));
    }
}
