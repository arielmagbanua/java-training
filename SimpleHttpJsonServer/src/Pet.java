/**
 * The template class for any pets.
 */
public class Pet {
    private String name;
    private String type;

    public Pet() {}

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Name: " + name + " Email: " + type;
    }
}
