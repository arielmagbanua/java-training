import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private String name;
    private int health;
    private List<Weapon> weapons = new ArrayList<>();
    private Character parent;
    private Level level;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Character(Character parent) {
        setParent(parent);
    }

    private void copyWith(Character character) {
        this.name = character.getName();
        this.health = character.getHealth();
        this.weapons = character.getWeapons();
        this.parent = character.getParent();
        this.level = character.getLevel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Character getParent() {
        return parent;
    }

    public void setParent(Character parent) {
        // deep copy the parent
        copyWith(parent);

        // set the parent
        this.parent = parent;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public abstract String speak();
}
