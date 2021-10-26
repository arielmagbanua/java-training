public class Weapon {
    private String name;
    private double strength;

    public Weapon(String name, double strength) {
        this.name = name;
        this.strength = strength;
    }

    public Weapon(Weapon weapon) {
        this.name = weapon.getName();
        this.strength = weapon.getStrength();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
