import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{
    private Address address1;
    private Address address2;

    @BeforeEach
    void setUp()
    {
        address1 = new Address("1a", 777, "56th avenue", "v7n2m8", "surrey");
        address2 = new Address(null, 123, "main street", "v7r2g2", "west vancouver");
    }

    @AfterEach
    void tearDown()
    {
        address1 = null;
        address2 = null;
    }

    @Test
    void getUnitNumber()
    {
        assertEquals("1a", address1.getUnitNumber());
        assertNull(address2.getUnitNumber());
    }

    @Test
    void getStreetNumber()
    {
        assertEquals(777, address1.getStreetNumber());
        assertEquals(123, address2.getStreetNumber());
    }

    @Test
    void getStreetName()
    {
        assertEquals("56th avenue", address1.getStreetName());
        assertEquals("main street", address2.getStreetName());
    }

    @Test
    void getPostalCode()
    {
        assertEquals("v7n2m8", address1.getPostalCode());
        assertEquals("v7r2g2", address2.getPostalCode());
    }

    @Test
    void getCity()
    {
        assertEquals("surrey", address1.getCity());
        assertEquals("west vancouver", address2.getCity());
    }

    @Test
    void getExpectedExceptionsUnitNumber()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("",777, "56th avenue", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid unit number: "));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("11111",777, "56th avenue", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid unit number: 11111"));
    }

    @Test
    void getExpectedExceptionsStreetNumber()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",-1, "56th avenue", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid street number: -1"));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",1000000, "56th avenue", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid street number: 1000000"));
    }

    @Test
    void getExpectedExceptionsStreetName()
    {
        NullPointerException ex2 = assertThrows(NullPointerException.class, ()->{
            address1 = new Address("1a",777, null, "v7n2m8", "surrey");
        });
        assertTrue(ex2.getMessage().equals("Invalid street name: null"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid street name: "));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "abcdefghijklmnopqrstu", "v7n2m8", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid street name: abcdefghijklmnopqrstu"));
    }

    @Test
    void getExpectedExceptionsPostalCode()
    {
        NullPointerException ex2 = assertThrows(NullPointerException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", null, "surrey");
        });
        assertTrue(ex2.getMessage().equals("Invalid postal code: null"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", "1234", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid postal code: 1234"));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", "1234567", "surrey");
        });
        assertTrue(ex.getMessage().equals("Invalid postal code: 1234567"));
    }

    @Test
    void getExpectedExceptionsCity()
    {
        NullPointerException ex2 = assertThrows(NullPointerException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", "v7n2m8", null);
        });
        assertTrue(ex2.getMessage().equals("Invalid city: null"));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", "v7n2m8", "");
        });
        assertTrue(ex.getMessage().equals("Invalid city: "));

        ex = assertThrows(IllegalArgumentException.class, ()->{
            address1 = new Address("1a",777, "56th avenue", "v7n2m8", "0123456789012345678901234567890");
        });
        assertTrue(ex.getMessage().equals("Invalid city: 0123456789012345678901234567890"));
    }
}