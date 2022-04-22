abstract class Person {
    public String name;
    public int idNum;

    public Person(){
        name = "John";
        System.out.print("A default Person John created");
    }

    public Person(String n, int ID){
        name = n;
        idNum = ID;
        System.out.println("A Person(name and ID)created");
    }

    public int getIdNum(){return this.idNum;}

    public void whoAmI() {
        System.out.println("I am a ...");
        if (this instanceof Person) {
            System.out.println(this);}
        if (this instanceof Student) {
            System.out.println(this);}
        if (this instanceof StudentCS101) {
            System.out.println(this);}
    }

    public abstract String greeting();

    public String toString(){
        return name + " " + idNum;
    }

    public boolean equals(Object o){
        if(o instanceof Person)
            return this.idNum == ((Person)o).idNum;
        return false;
    }
}
