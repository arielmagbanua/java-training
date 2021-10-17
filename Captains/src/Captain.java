public class Captain {
    private int age;
    private String name;
    private int yearsOfExperience;
    private int registryNumber;

    public Captain(int age, String name, int yearsOfExperience, int registryNumber) {
        this.age = age;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.registryNumber = registryNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(int registryNumber) {
        this.registryNumber = registryNumber;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d %d", age, name, yearsOfExperience, registryNumber);
    }

    /**
     * Overriden equals method for comparing other captains.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Captain captain = (Captain) o;

        if (age != captain.age) return false;
        if (yearsOfExperience != captain.yearsOfExperience) return false;
        if (registryNumber != captain.registryNumber) return false;
        return name.equals(captain.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        result = 31 * result + yearsOfExperience;
        result = 31 * result + registryNumber;
        return result;
    }
}
