import java.util.concurrent.atomic.AtomicInteger;

public class AnimalLASTNAME {
    /**
     * This is to generate ids automatically
     */
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    /**
     * The only possible animal types
     */
    enum AnimalType {
        DOG,
        CAT,
        RABBIT,
        OTHER
    }

    /**
     * The type of the animal
     */
    private final AnimalType animal;

    /**
     * The name of the animal
     */
    private final String name;

    /**
     * The id number of the animal
     */
    private final int ID_NUMBER;

    /**
     * The age of the animal
     */
    private int age;

    /**
     * The weight of the animal
     */
    private double weight;

    /**
     * The special notes for this animal
     */
    private String specialNotes;

    /**
     * Required constructor
     */
    public AnimalLASTNAME(AnimalType animal, String name) {
        // auto generate id
        this.ID_NUMBER = ID_GENERATOR.getAndIncrement();

        this.animal = animal;
        this.name = name;
        this.specialNotes = "Nothing written.";
    }

    public AnimalLASTNAME(AnimalType animal, String name, int age, double weight) {
        // auto generate id
        this.ID_NUMBER = ID_GENERATOR.getAndIncrement();;

        this.animal = animal;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.specialNotes = "Nothing written.";
    }

    public AnimalLASTNAME(AnimalType animal, String name, int age, double weight, String specialNotes) {
        // auto generate id
        this.ID_NUMBER = ID_GENERATOR.getAndIncrement();;

        this.animal = animal;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.specialNotes = specialNotes;
    }

    public AnimalType getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return ID_NUMBER;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    /**
     * Retrieves the string representation of this animal that would serve as it's description
     *
     * @return
     */
    @Override
    public String toString() {
        String description = getName();

        switch (getAnimal()) {
            case DOG:
                description += " is dog ";
                break;
            case CAT:
                description += " is a cat ";
                break;
            case RABBIT:
                description += " is a rabbit ";
                break;
            default:
                description += " is an unknown animal ";

        }

        description += "with an age of " + getAge() + " and a weight of " + getWeight() + ". " + getSpecialNotes();

        return description;
    }

    public static void main(String[] args) {
        AnimalLASTNAME bart = new AnimalLASTNAME(AnimalType.DOG, "Bart", 4, 6.5);
        AnimalLASTNAME douglas = new AnimalLASTNAME(AnimalType.DOG, "Douglas", 5, 8.5);
        douglas.setSpecialNotes("Amazing Dong!");
        AnimalLASTNAME bugsBunny = new AnimalLASTNAME(AnimalType.RABBIT, "Bugs Bunny", 1, 7.5, "He is named after a cartoon character.");
        AnimalLASTNAME felix = new AnimalLASTNAME(AnimalType.CAT, "Felix", 2, 3.5);
        AnimalLASTNAME unknown = new AnimalLASTNAME(AnimalType.OTHER, "Unknown", 6, 9.5);

        System.out.println(bart);
        System.out.println(douglas);
        System.out.println(bugsBunny);
        System.out.println(felix);
        System.out.println(unknown);

        System.out.println(bart.toString());
        System.out.println(douglas.toString());
        System.out.println(bugsBunny.toString());
        System.out.println(felix.toString());
        System.out.println(unknown.toString());
    }
}
