public class Monster extends Character {
    private double angryness;
    private Weakness weakness;

    public Monster(String name, int health, double angryness, Weakness weakness) {
        super(name, health);

        this.angryness = angryness;
        this.weakness = weakness;
    }

    public Monster(Monster monster) {
        super(monster);

        this.angryness = monster.getAngryness();
        this.weakness = monster.getWeakness();
    }

    public double getAngryness() {
        return angryness;
    }

    public void setAngryness(double angryness) {
        this.angryness = angryness;
    }

    public Weakness getWeakness() {
        return weakness;
    }

    public void setWeakness(Weakness weakness) {
        this.weakness = weakness;
    }

    @Override
    public String speak() {
        return "booh";
    }
}
