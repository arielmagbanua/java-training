public class AirCrew {
    public static void main(String[] args) {
        // create and test the pilot
        Pilot john = new Pilot("John", 10);
        john.setSalary(200000);
        System.out.println(john);

        // create and test the captain
        Captain kirk = new Captain("Kirk", 20, "InterAir");
        kirk.setSalary(300000);
        kirk.setWeeklyBonus(1000);
        System.out.println(kirk);

        // create and test the manager
        Manager kim = new Manager("Kim", 30);
        kim.setSalary(500000);
        System.out.println(kim);
    }
}
