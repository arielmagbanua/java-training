class Student extends Person implements KnownInterface{
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    private int year;

    public Student(String name, int idNum, int year) {
        super(name, idNum);
        this.year = year;
        System.out.println("A student named " + name + " created with id " + this.idNum);
    }

    public Student(String name, int idNum) {
        super(name, idNum);
        System.out.println("A student named " + name + " created without year");
    }

    public Student() {
        System.out.println("A student created.");
    }

    public String toString() {
        String output = super.toString() + " who is a ";
        switch (year) {
            case FRESHMAN: output += "freshman"; break;
            case SOPHOMORE: output += "sophomore"; break;
            default: output += "other years";
        }
        return output + " knows interface? " + knowInterface();
    }

    public String greeting() {
        return "What's up?";
    }

    @Override
    public char knowInterface() {
        return 'U'; //unknown
    }
}
