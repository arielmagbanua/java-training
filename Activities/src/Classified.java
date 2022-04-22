public class Classified extends Earthquake {

    private String magnitudeClass;

    public Classified(String dateTimeZ, double latitude, double longitude, double magnitude, String id, String place) {
        super(dateTimeZ, latitude, longitude, magnitude, id, place);
    }

    public String getMagnitudeClass() {
        if(super.getMagnitude() >= 3 && super.getMagnitude() <= 3.9) {
            magnitudeClass = "Minor";
        } else if(super.getMagnitude() >= 4 && super.getMagnitude() <= 4.9) {
            magnitudeClass = "Light";
        } else if(super.getMagnitude() >= 5 && super.getMagnitude() <= 5.9) {
            magnitudeClass = "Moderate";
        } else if(super.getMagnitude() >= 6 && super.getMagnitude() <= 6.9) {
            magnitudeClass = "Strong";
        } else if(super.getMagnitude() >= 7 && super.getMagnitude() <= 7.9) {
            magnitudeClass = "Major";
        } else if(super.getMagnitude() >= 8) {
            magnitudeClass = "Great";
        }
        return magnitudeClass;
    }

    @Override
    public int compareTo(Earthquake o) {
        return super.getId().compareTo(o.getId());
    }
}
