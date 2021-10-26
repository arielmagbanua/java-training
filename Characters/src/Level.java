public class Level {
    private String name;
    private int levelNumber;

    public Level(String name, int levelNumber) {
        this.name = name;
        this.levelNumber = levelNumber;
    }

    public Level(Level level) {
        this.name = level.getName();
        this.levelNumber = level.getLevelNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
