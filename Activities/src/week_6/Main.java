package week_6;

public class Main {
    public static void main(String[] args)
    {

        Employee e1 = new Employee(123456);
        Employee e2 = new Employee(67890);
        Employee e3 = new Employee(345678);

        e1.setFirstName("Mitchell");
        e1.setLastName("Millerberg");
        e1.setStatus("P");
        e1.setTitle("Data scraper");
        e1.setAge(28);
        e1.setSalary(45000);
        e1.setEmployeeID(123456);

        e2.setFirstName("Ben");
        e2.setLastName("Vogal");
        e2.setStatus("F");
        e2.setTitle("engineer");
        e2.setAge(28);
        e2.setSalary(90000);
        e2.setEmployeeID(67890);

        e3.setFirstName("Frank");
        e3.setLastName("Irvin");
        e3.setStatus("F");
        e3.setTitle("Street Sweeper");
        e3.setAge(28);
        e3.setSalary(55000);
        e3.setEmployeeID(345678);


        System.out.println("Employee ID: " + e1.getEmployeeID());
        System.out.println("Name: " + e1.getFirstName() +
                " " + e1.getLastName());
        System.out.println("Job Title: "+ e1.getTitle());
        System.out.println("Age: "+ e1.getAge());
        System.out.println("Salary: "+"$"+ e1.salary);
        System.out.println("Employment Status: " + e1.getStatus());


        System.out.println();
        System.out.println("*****");
        System.out.println();

        System.out.println("Employee ID: " + e2.getEmployeeID());
        System.out.println("Name: " + e2.getFirstName() +
                " " + e2.getLastName());
        System.out.println("Job Title: "+ e2.getTitle());
        System.out.println("Age: "+ e2.getAge());
        System.out.println("Salary: "+"$"+ e2.salary);
        System.out.println("Employment Status: " + e2.getStatus());

        System.out.println();
        System.out.println("*****");
        System.out.println();

        System.out.println("Employee ID: " + e3.getEmployeeID());
        System.out.println("Name: " + e3.getFirstName() +
                " " + e3.getLastName());
        System.out.println("Job Title: "+ e3.getTitle());
        System.out.println("Age: "+ e3.getAge());
        System.out.println("Salary: "+"$"+ e3.salary);
        System.out.println("Employment Status: " + e3.getStatus());

    }
}
