public abstract class Earthquake implements Comparable<Earthquake> {

    private final String dateTimeZ;
    private final double latitude;
    private final double longitude;
    private final double magnitude;
    private final String id;
    private final String place;

    public Earthquake(String dateTimeZ, double latitude, double longitude, double magnitude, String id, String place) {
        this.dateTimeZ = dateTimeZ;
        this.latitude = latitude;
        this.longitude = longitude;
        this.magnitude = magnitude;
        this.id = id;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "dateTimeZ='" + dateTimeZ + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", magnitude=" + magnitude +
                ", id='" + id + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

    public String getDateTimeZ() {
        return dateTimeZ;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }
}
