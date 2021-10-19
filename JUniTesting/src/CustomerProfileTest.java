import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.util.zip.DataFormatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerProfileTest {
    private CustomerProfile customerProfile;

    /**
     * Creates a new instance for every test.
     *
     * @throws DataFormatException
     */
    @BeforeEach
    public void setUp() throws DataFormatException {
        customerProfile = new CustomerProfile(
                "John",
                "1122334455",
                1988,
                4,
                23
        );
    }

    /**
     * Test if it can accept valid name.
     */
    @Test
    public void testIfAcceptsValidName() throws DataFormatException {
        customerProfile.validateName("Max");
        assertEquals("Max", customerProfile.getName());
    }

    /**
     * Test if throws data format exception on null name.
     */
    @Test
    public void testIfThrowsExceptionOnNullName() {
        assertThrows(DataFormatException.class, () -> {
            customerProfile.validateName(null);
        });
    }

    /**
     * Test if throws data format exception on number as name.
     */
    @Test
    public void testIfThrowsExceptionOnNumberAsName() {
        assertThrows(DataFormatException.class, () -> {
            customerProfile.validateName("123");
        });
    }

    /**
     * Test if accepts valid cell phone number.
     *
     * @throws DataFormatException
     */
    @Test
    public void testIfCanAcceptValidCellPhoneNumber() throws DataFormatException {
        customerProfile.validateCellphone("2233445566");
        assertEquals("(223) 344-5566", customerProfile.getCellPhone());
    }

    /**
     * Test if throws data format exception on null cellphone number.
     */
    @Test
    public void testIfThrowsExceptionOnNullCellphoneNumber() {
        assertThrows(DataFormatException.class, () -> {
            customerProfile.validateCellphone(null);
        });
    }

    /**
     * Test if throws data format exception on cell phone number with alpha characters
     */
    @Test
    public void testIfThrowsExceptionOnCellphoneNumberWithAlphaCharacters() {
        assertThrows(DataFormatException.class, () -> {
            customerProfile.validateCellphone("123abcd");
        });
    }

    /**
     * Test if accepts valid date.
     */
    @Test
    public void testIfAcceptsValidBirthDate() {
        customerProfile.validateBirthDate(1988, 10, 23);
        assertEquals(32, customerProfile.getAge());
    }

    /**
     * Test if throws date time exception on invalid birthdate.
     */
    @Test
    public void testIfThrowsExceptionOnInvalidBirthdate() {
        assertThrows(DateTimeException.class, () -> {
            customerProfile.validateBirthDate(1988, 50, 23);
        });
    }
}
