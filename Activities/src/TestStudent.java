public class TestStudent {
    private String name;

    public TestStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TestStudent student1 = new TestStudent("Alex");
        TestStudent student2 = student1;
        TestStudent student3 = student2;

        student2.setName("Aiden");
        student3.setName("River");

        System.out.println(student1.getName());
    }
}
