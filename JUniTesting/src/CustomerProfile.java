import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.zip.DataFormatException;

public class CustomerProfile {
    private String name = null;
    private String cellphone = null;
    private long age = 0;

    private CustomerProfile() {
        // can't call this constructor
    }


    // name must be a string and may contain spaces but no special characters
    // cell must be in the format of 1111111111
    // bdate must be in the format of yyyy/mm/dd
    public CustomerProfile( String name, String cell, int yr, int m, int d ) throws DataFormatException {
        this.validateName(name);
        this.validateCellphone(cell);
        this.validateBirthDate(yr, m, d);
    }


    // takes a string as the customer name, validates and sets the attribute
    // name cannot contain numbers or special characters
    public void validateName(String n) throws DataFormatException {
        if( n == null ) throw new DataFormatException("Null string for name");
        if (n.matches("[0-9]+") && n.length() > 2) throw new DataFormatException("Numbers in name");
        this.name = n;
    }

    // will take a 10 digit number (String) and turn it into a phone number
    public void validateCellphone(String c) throws DataFormatException {
        if( c == null ) throw new DataFormatException("Null String for Cellphone");
        if (c.matches("[0-9]+") && c.length() > 2) {
            this.cellphone = c.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        }else throw new DataFormatException("Alpha characters in phone number");
    }

    // validates the values for the birthdate and if successful sets the age attribute
    public void validateBirthDate( int yr, int m, int d ) throws DateTimeException  {

        LocalDate start = LocalDate.of(yr, m, d);
        LocalDate end = LocalDate.now();
        long years = ChronoUnit.YEARS.between(start, end);
        this.age = years;
    }

    public String getName() {
        return this.name;
    }

    public String getCellPhone() {
        return this.cellphone;
    }

    public long getAge() {
        return this.age;
    }
}
