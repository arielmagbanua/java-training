public class Weakness {
    private String name;
    private String description;
    private int amount;

    public Weakness(String name, String description, int amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public Weakness(Weakness weakness) {
        this.name = weakness.getName();
        this.description = weakness.getDescription();
        this.amount = weakness.getAmount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
