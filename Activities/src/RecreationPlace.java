public class RecreationPlace {
    private String name;
    private String type;
    private int price;
    private Place place;

    public RecreationPlace() {
    }

    public RecreationPlace(String name, String type, int price, Place place) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.place = place;
    }

    public RecreationPlace(String name, int price, Place place) {
        this.name = name;
        this.price = price;
        this.place = place;
    }

    public RecreationPlace(RecreationPlace recreationPlace) {
        this.name = recreationPlace.name;
        this.type = recreationPlace.type;
        this.price = recreationPlace.price;
        this.place = recreationPlace.place;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            // the other object is the same instance with this place, therefore return true
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            // the other object is null or not the same class with this place, therefore return false
            return false;
        }

        // cast to RecreationPlace
        RecreationPlace that = (RecreationPlace) o;

        if (getPrice() != that.getPrice()) {
            // the other recreation place has different price with this recreation place, therefore return false
            return false;
        }

        if (!getName().equals(that.getName())) {
            // the other recreation place has different name with this recreation place, therefore return false
            return false;
        }

        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
            // the other recreation place has different type with this recreation place, therefore return false
            return false;
        }

        // return true if the recreation place has the same place with this recreation place, otherwise return false
        return getPlace().equals(that.getPlace());
    }

    /**
     * Creates a copy or new instance of this same recreation place.
     *
     * @return A new copy or instance of this place
     */
    public RecreationPlace copy() {
        return new RecreationPlace(this);
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nType: %s \nPrice: %s \n%s",
                this.getName(),
                this.getType(),
                this.getPrice(),
                this.getPlace()
        );
    }
}
