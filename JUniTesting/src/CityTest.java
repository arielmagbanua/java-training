import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {
    private City city;

    /**
     * Creates a new instance for every test.
     */
    @BeforeEach
    public void setUp() {
        city = new City("New York");
    }

    /**
     * Testing the find method.
     */
    @Test
    public void testIfCanFind() {
        // find the new york since it is added during set up
        City newYork = City.find("New York");
        assertNotNull(newYork);
    }

    /**
     * Testing the add link method
     */
    @Test
    public void testIfCanAddLink() {
        // create new cities
        City manila = new City("Manila");
        City pasig = new City("Pasig");

        // create a link between manila and pasig
        Link link = new Link(manila, pasig, 14);
        city.addLink(link);

        // verify the size if successfully added a link
        assertEquals(1, city.links.size());
    }

    /**
     * CompareTo testing
     */
    @Test
    public void testCompareTo() {
        // find the cities to compare
        City newYork = City.find("New York");
        City pasig = City.find("Pasig");

        // compare the two cities
        int result = newYork.compareTo(pasig);
        assertEquals(-2, result);
    }

    /**
     * toString method testing
     */
    @Test
    public void testToString() {
        City newYork = City.find("New York");
        // toString must return the name of the city
        assertEquals("New York", newYork.toString());
    }

    /**
     * Compare method testing
     */
    @Test
    public void testCompare() {
        City manila = new City("Manila");
        City pasig = City.find("Pasig");

        manila.distance = 14;
        pasig.distance = 1;

        // computes the distance
        int result = manila.compare(manila, pasig);
        assertEquals(13, result);
    }

    /**
     * get Links to testing
     */
    @Test
    public void testGetLinksTo() {
        City manila = new City("Manila");
        City pasig = new City("Pasig");
        City pasay = new City("Pasay");

        // create a new link for testing
        Link link = new Link(pasig, pasay, 16);
        city.addLink(link);

        boolean result = manila.getLinksTo(pasay, city.links);
        assertFalse(result);
    }
}
