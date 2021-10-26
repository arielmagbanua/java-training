public class Pilot {
    private String name;
    private String license;

    public Pilot() {
    }

    public Pilot(String name, String license) {
        this.name = name;
        this.license = license;
    }


    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicense(String license) {
        this.license = license;
    }


    public Pilot copy() {
        Pilot pilot = null;
        try {
            // clone the current instance
            pilot = (Pilot) super.clone();
        } catch (CloneNotSupportedException e) {
            // cannot clone therefore create new instance by supplying the properties
            pilot = new Pilot(this.name, this.license);
        }

        return pilot;
    }

    public String toString() {
        return String.format("pilot name: %s \nlicense: %s", name, license);
    }

    public boolean equals(Pilot pilot) {
        return (name.equals(pilot.name) && license.equals(pilot.license));
    }
}
