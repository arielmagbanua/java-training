public class StuPreIPV6 {
    // Returns true if the string parameter contains a valid IPv6 address in the preferred format.
    // Otherwise returns false.
    public static boolean isValidPreferFormatIpv6(String address) {
        if (address.length() != 39) {
            // valid ipv6 address will have 39 characters including the colon if not equal to 39 then the address is invalid
            return false;
        }

        // variable for counting character in group
        int groupCharacterCounter = 0;

        // loop through each character
        for (int i = 0; i < address.length(); i++) {
            char character = address.charAt(i);

            if (character == ':') {
                if (groupCharacterCounter != 4) {
                    // one group is not 4 character length
                    return false;
                }

                // finished the firs group therefore reset the group counter
                groupCharacterCounter = 0;
            } else {
                // get the numeric value of the character
                int characterNumeric = Character.getNumericValue(character);
                if (characterNumeric > 16 || characterNumeric < 0) {
                    // this means the current character is non-hex value because valid hex value will be from 0 to 9  and A(10) to F(15)
                    return false;
                }

                // at this point all checks out therefore increment the group counter
                ++groupCharacterCounter;
            }
        }

        // at this point the looping of each character doesn't violate the rules therefore the address is ipv6
        return true;
    }

    /**
     * Check if the ip address is IPV6 and print an appropriate message.
     *
     * @param ipAddress The ip address to be checked
     */
    public static void checkIfIpV6Address(String ipAddress) {
        if (isValidPreferFormatIpv6(ipAddress)) {
            // valid
            System.out.println( "isValidPreferFormatIpv6(" + ipAddress + ") success");
        } else {
            // failed
            System.out.println( "(isValidPreferFormatIpv6(" + ipAddress + ") failed");
        }
    }

    // for unit testing
    public static void main(String[] args) {
        System.out.println("Testing started ...");
        String str; // store test strings

        // valid tests
        str = "0123:4567:89ab:cdef:0123:4567:89Ab:cDEf";
        checkIfIpV6Address(str);
        str = "0000:0000:0000:dddd:eeee:dddd:eeee:ffff";
        checkIfIpV6Address(str);
        str = "0a00:0b01:0ff0:d2dd:eaee:dddd:111e:fff1";
        checkIfIpV6Address(str);

        // invalid tests
        str = "123:4567:89ab:cdef:0123:4567:89ab:cdef0";
        checkIfIpV6Address(str);
        str = "11::::231:a";
        checkIfIpV6Address(str);
        str = "0000:0000";
        checkIfIpV6Address(str);
        str = "0123:4567:89ab:cdef:0,23:4567:89Ab:cDEf";
        checkIfIpV6Address(str);

        // add more testing cases
        System.out.println("Testing completed.");
    }
}
