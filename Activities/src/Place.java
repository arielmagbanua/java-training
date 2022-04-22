public class Place {
    private String city;
    private String state;

    public Place() {
    }

    public Place(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public Place(Place place) {
        this.city = place.getCity();
        this.state = place.getState();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieves the abbreviation/initials for the state.
     *
     * source: https://www.ssa.gov/international/coc-docs/states.html
     *
     * @return Returns the abbreviation/initials for the state of this place
     */
    public String getStateInitials() {
        switch (this.getState().toLowerCase()) {
            case "maryland":
                return "MD";
            case "pennsylvania":
                return "PA";
            case "florida":
                return "FL";
            case "washington":
                return "WA";
            case "texas":
                return "TX";
            case "california":
                return "CA";
            case "new york":
                return "NY";
            default:
                // unknown state
                return "UNKNOWN";
        }
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

        // cast the other object to Place
        Place place = (Place) o;

        if (getCity() != null ? !getCity().equals(place.getCity()) : place.getCity() != null) {
            // the city of the other place is not equal to this place, therefore return false
            return false;
        }

        // return true if the state of the other city is equal to this place, otherwise return false
        return getState() != null ? getState().equals(place.getState()) : place.getState() == null;
    }

    @Override
    public String toString() {
        return String.format("City: %s \nState: %s (%s)", this.getCity(), this.getState(), this.getStateInitials());
    }
}
