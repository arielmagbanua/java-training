import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest
{
    private Property property1;
    private Property property2;
    private Property property3;
    private Address address;

    @BeforeEach
    void setUp()
    {
        address = new Address("1a", 777, "56th avenue", "v7n2m8", "surrey");

        property1 = new Property(499000, address, 1, true, "resiDEnce", "11111");
        property2 = new Property(1000000, address, 2, false, "commErcial", "22222");
        property3 = new Property(840000, address, 3, false, "rETAil", "xxxxx");
    }

    @AfterEach
    void tearDown()
    {
        address = null;

        property1 = null;
        property2 = null;
        property3 = null;
    }

    @Test
    void getPriceUsd()
    {
        assertEquals(499000, property1.getPriceUsd());
        assertEquals(1000000, property2.getPriceUsd());
        assertEquals(840000, property3.getPriceUsd());
    }

    @Test
    void getAddress()
    {
        assertEquals(address, property1.getAddress());
    }

    @Test
    void getNumberOfBedrooms()
    {
        assertEquals(1, property1.getNumberOfBedrooms());
        assertEquals(2, property2.getNumberOfBedrooms());
        assertEquals(3, property3.getNumberOfBedrooms());
    }

    @Test
    void hasSwimmingPool()
    {
        assertTrue(property1.hasSwimmingPool());
        assertFalse(property2.hasSwimmingPool());
        assertFalse(property3.hasSwimmingPool());
    }

    @Test
    void getType()
    {
        assertEquals("resiDEnce", property1.getType());
        assertEquals("commErcial", property2.getType());
        assertEquals("rETAil", property3.getType());
    }

    @Test
    void getPropertyId()
    {
        assertEquals("11111", property1.getPropertyId());
        assertEquals("22222", property2.getPropertyId());
        assertEquals("xxxxx", property3.getPropertyId());
    }

    @Test
    void setPriceUsd()
    {
        property1.setPriceUsd(777123);
        assertEquals(777123, property1.getPriceUsd());
    }


    @Test
    void getExpectedExceptionsPriceUsd()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(-0.01, address, 1, true, "residence", "11111");
        });
        assertTrue(ex.getMessage().equals("Invalid price: -0.01"));
    }

    @Test
    void getExpectedExceptionsAddress()
    {
        NullPointerException ex = assertThrows(NullPointerException.class, ()->{
            property1 = new Property(499000, null, 1, true, "residence", "11111");
        });
        assertTrue(ex.getMessage().equals("Invalid address: null"));
    }

    @Test
    void getExpectedExceptionsNumBedrooms()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(499000, address, 0, true, "residence", "11111");
        });
        assertTrue(ex.getMessage().equals("Invalid number of bedrooms: 0"));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(499000, address, 21, true, "residence", "11111");
        });
        assertTrue(ex.getMessage().equals("Invalid number of bedrooms: 21"));
    }

    @Test
    void getExpectedExceptionsPropertyType()
    {
        NullPointerException ex = assertThrows(NullPointerException.class, ()->{
            property1 = new Property(499000, address, 1, true, null, "11111");
        });
        assertTrue(ex.getMessage().equals("Invalid property type: null"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(499000, address, 2, true, "residencee", "11111");
        });
        assertTrue(ex2.getMessage().equals("Invalid property type: residencee"));
    }

    @Test
    void getExpectedExceptionsPropertyId()
    {
        NullPointerException ex = assertThrows(NullPointerException.class, ()->{
            property1 = new Property(499000, address, 1, true, "residence", null);
        });
        assertTrue(ex.getMessage().equals("Invalid property id: null"));


        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(499000, address, 1, true, "residence", "");
        });
        assertTrue(ex2.getMessage().equals("Invalid property id: "));

        ex2 = assertThrows(IllegalArgumentException.class, ()->{
            property1 = new Property(499000, address, 1, true, "residence", "1234567");
        });
        assertTrue(ex2.getMessage().equals("Invalid property id: 1234567"));
    }
}
