public class Test{
    public static void main(String[] args) {
        StudentCS101 csstudent1 = new StudentCS101("Flyn Lee", 99, Student.SOPHOMORE, "basic programming, object, interface");  //line A
        System.out.println(csstudent1);  //line B
        Student student2 = new Student("Alice Chen", 104, Student.FRESHMAN);  //line C
        System.out.println(student2); //line D
        Student student3 = new Student(); //line E
        Student student4 = new Student("Aaron Wonder", 106); //line F
        System.out.println(student4); //line G
    }
}
