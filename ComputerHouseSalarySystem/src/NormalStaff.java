import java.util.Date;

public class NormalStaff extends Employee {
    private int level;

    public NormalStaff(String id, String name, String position, Date dateOfBirth, int level) {
        super(id, name, position, dateOfBirth);

        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public double calculateSalary() {
        double additional = 0.0;

        switch (level) {
            case 1:
                // 3% of salary
                additional = getBaseSalary() * (3.0 / 100.0);
                break;
            case 2:
                // 5% of salary
                additional = getBaseSalary() * (5.0 / 100.0);
                break;
            case 3:
                // 6% of salary
                additional = getBaseSalary() * (6.0 / 100.0);
                break;
        }

        // return base salary plus the additional
        return getBaseSalary() + additional;
    }
}
