public class NonClassified extends Earthquake {

    public NonClassified(String dateTimeZ, double latitude, double longitude, double magnitude, String id, String place) {
        super(dateTimeZ, latitude, longitude, magnitude, id, place);
    }

    @Override
    public int compareTo(Earthquake o) {
        return super.getId().compareTo(o.getId());
    }
}
