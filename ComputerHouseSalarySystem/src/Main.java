import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        // create departments
        Department production = new Department("Production");
        Department marketing = new Department("Marketing");

        // create production supervisors
        Supervisor john = new Supervisor(
                "SUP-112233",
                "John Doe",
                "Staff Supervisor",
                new SimpleDateFormat("dd/MM/yyyy").parse("23/04/1988"),
                2
        );
        Supervisor jane = new Supervisor(
                "SUP-112234",
                "Jane Doe",
                "Line Supervisor",
                new SimpleDateFormat("dd/MM/yyyy").parse("23/05/1988"),
                3
        );

        // create production staff
        NormalStaff ariel = new NormalStaff(
                "STF-001133",
                "Ariel Smith",
                "Technician",
                new SimpleDateFormat("dd/MM/yyyy").parse("22/04/1988"),
                1
        );
        NormalStaff max = new NormalStaff(
                "STF-001134",
                "Max Smith",
                "Electrician",
                new SimpleDateFormat("dd/MM/yyyy").parse("03/05/1988"),
                2
        );
        NormalStaff mario = new NormalStaff(
                "STF-001135",
                "Mario Doe",
                "Janitor",
                new SimpleDateFormat("dd/MM/yyyy").parse("13/05/1988"),
                3
        );

        // add employees
        production.addEmployee(john);
        production.addEmployee(jane);
        production.addEmployee(ariel);
        production.addEmployee(max);
        production.addEmployee(mario);

        // create marketing supervisors
        Supervisor brent = new Supervisor(
                "SUP-123450",
                "Brent Doe",
                "Staff Supervisor",
                new SimpleDateFormat("dd/MM/yyyy").parse("12/04/1987"),
                3
        );
        Supervisor jack = new Supervisor(
                "SUP-123451",
                "Jack Doe",
                "Line Supervisor",
                new SimpleDateFormat("dd/MM/yyyy").parse("23/05/1980"),
                5
        );

        // create marketing staff
        NormalStaff adrian = new NormalStaff(
                "STF-12120",
                "Adrian Buffet",
                "Marketer",
                new SimpleDateFormat("dd/MM/yyyy").parse("22/06/1988"),
                1
        );
        NormalStaff luigi = new NormalStaff(
                "STF-12121",
                "Luigi Martinez",
                "Sales",
                new SimpleDateFormat("dd/MM/yyyy").parse("03/05/1988"),
                2
        );
        NormalStaff anton = new NormalStaff(
                "STF-12122",
                "Anton Doe",
                "Sales",
                new SimpleDateFormat("dd/MM/yyyy").parse("13/05/1990"),
                3
        );

        // add employees
        marketing.addEmployee(brent);
        marketing.addEmployee(jack);
        marketing.addEmployee(adrian);
        marketing.addEmployee(luigi);
        marketing.addEmployee(anton);

        System.out.println(production);
        System.out.println(marketing);
    }
}
