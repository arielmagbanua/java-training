public class Wizard extends Character {
    private double magicLevel;

    public Wizard(String name, int health, double magicLevel) {
        super(name, health);

        this.magicLevel = magicLevel;
    }

    public Wizard(Wizard wizard) {
        super(wizard);

        this.magicLevel = wizard.getMagicLevel();
    }

    public double getMagicLevel() {
        return magicLevel;
    }

    public void setMagicLevel(double magicLevel) {
        this.magicLevel = magicLevel;
    }

    @Override
    public String speak() {
        return "I put a spell on you";
    }
}
