public class Property {
    private double priceInUsd;
    private Address address;
    private int numberOfBedrooms;
    private boolean hasSwimmingPool;
    private String type;
    private String id;

    public Property(double priceInUSD, Address address, int numberOfBedrooms, boolean hasSwimmingPool, String type, String id) {
        this.priceInUsd = priceInUSD;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.type = type;
        this.id = id;

        setPriceUsd(priceInUSD);
        setAddress(address);
        setNumberOfBedrooms(numberOfBedrooms);
        setHasSwimmingPool(hasSwimmingPool);
        setType(type);
        setPropertyId(id);
    }

    public double getPriceUsd() {
        return priceInUsd;
    }

    public Address getAddress() {
        return address;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    public String getType() {
        return type;
    }

    public String getPropertyId() {
        return id;
    }

    public void setPriceUsd(double priceInUsd) {
        if (priceInUsd <= 0.0) {
            throw new IllegalArgumentException("Invalid price: " + priceInUsd);
        }

        this.priceInUsd = priceInUsd;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new NullPointerException("Invalid address: null");
        }

        this.address = address;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        if (numberOfBedrooms <= 0 || numberOfBedrooms > 20) {
            throw new IllegalArgumentException("Invalid number of bedrooms: " + numberOfBedrooms);
        }

        this.numberOfBedrooms = numberOfBedrooms;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public void setType(String type) {
        if (type == null) {
            throw new NullPointerException("Invalid property type: null");
        }

        if (!type.equalsIgnoreCase("residence") && !type.equalsIgnoreCase("commercial") && !type.equalsIgnoreCase("retail")) {
            throw new IllegalArgumentException("Invalid property type: " + type);
        }

        this.type = type;
    }

    public void setPropertyId(String id) {
        if (id == null) {
            throw new NullPointerException("Invalid property id: null");
        }

        if (id.length() == 0 || id.length() > 6) {
            throw new IllegalArgumentException("Invalid property id: " + id);
        }

        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Price: %s \nBeds: %s \nPool: %s \nType: %s \nAddress: %s",
                getPriceUsd(), getNumberOfBedrooms(), hasSwimmingPool(), getType(), getAddress());
    }
}
