public class Address {
    private String unitNumber;
    private int streetNumber;
    private String streetName;
    private String postalCode;
    private String city;

    public Address(String unitNumber, int streetNumber, String streetName, String postalCode, String city) {
        setUnitNumber(unitNumber);
        setStreetNumber(streetNumber);
        setStreetName(streetName);
        setPostalCode(postalCode);
        setCity(city);
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setUnitNumber(String unitNumber) {
        if (unitNumber != null) {
            if (unitNumber.length() == 0 || unitNumber.length() > 4) {
                throw new IllegalArgumentException("Invalid unit number: " + unitNumber);
            }
        }

        this.unitNumber = unitNumber;
    }

    public void setStreetNumber(int streetNumber) {
        if (streetNumber < 0 || streetNumber > 999999) {
            throw new IllegalArgumentException("Invalid street number: " + streetNumber);
        }

        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        if (streetName == null) {
            throw new NullPointerException("Invalid street name: null");
        }

        if (streetName.length() == 0 || streetName.length() > 20) {
            throw new IllegalArgumentException("Invalid street name: " + streetName);
        }

        this.streetName = streetName;
    }

    public void setPostalCode(String postalCode) {
        if (postalCode == null) {
            throw new NullPointerException("Invalid postal code: null");
        }

        if (postalCode.length() != 5 && postalCode.length() != 6) {
            throw new IllegalArgumentException("Invalid postal code: " + postalCode);
        }

        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        if (city == null) {
            throw new NullPointerException("Invalid city: null");
        }

        if (city.length() == 0 || city.length() > 30) {
            throw new IllegalArgumentException("Invalid city: " + city);
        }

        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Unit Number: %s \nStreet Number: %s \nStreet Name: %s \nPostal Code: %s \nCity: %s",
                getUnitNumber(), getStreetNumber(), getStreetName(), getPostalCode(), getCity());
    }
}
