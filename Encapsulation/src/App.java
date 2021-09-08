public class App {
    public static void main(String[] args) throws Exception {
        Student student = new Student();

        // set the first name and the last name
        student.setIdNumber("112233");
        student.setFirstName("Anton");
        student.setLastName("San Juan");
        student.setMajor("Computer Science");

        System.out.println(student.getIdNumber());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getMajor());
    }
}
