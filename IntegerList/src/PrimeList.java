/**
 * The list that contains prime numbers only.
 */
public class PrimeList extends IntegerList {
    /**
     * The first prime number
     */
    public static final int FIRST_PRIME = 2;

    /**
     * Construct with default minimum capacity.
     */
    public PrimeList() {
        super();
    }

    /**
     * Construct class with specific upperbound.
     *
     * @param upperBound The upperbound of the prime numbers.
     */
    public PrimeList(int upperBound) {
        super(upperBound);

        if (upperBound < 0) {
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_HERE_IN_COMPLIANCE_OF_UNIT_TEST");
        }
    }

    /**
     * Determines if the integer is prime.
     *
     * @param num The number to be tested.
     * @return True of number is prime otherwise false.
     */
    private boolean isPrime(int num)
    {
        if (num <= 1) {
            // automatic not prime
            return false;
        }

        // test from 2 upto the given number
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void insert(int index, int integer) {
        // since the list only contains prime numbers therefore it is not allowed.
        throw new UnsupportedOperationException();
    }

    /**
     * Generates prime numbers and add them to the list.
     *
     * @param upperBound The upper limit or bound of the prime numbers.
     */
    @Override
    public void add(int upperBound) {
        if (upperBound < FIRST_PRIME) {
            throw new IllegalArgumentException("The upper bound cannot be less than " + FIRST_PRIME);
        }

        int[] primeNumbers = new int[upperBound];

        // generate the prime numbers
        int counter = 0;
        for (int i = 1; i < upperBound + 1; i++) {
            if (isPrime(i)) {
                primeNumbers[counter++] = i;
            }
        }

        if (upperBound <= primeNumbers[primeNumbers.length - 1]) {
            throw new IllegalArgumentException(
                "The upper bound must be greater than the last prime in the list: " + primeNumbers[primeNumbers.length - 1]
            );
        }

        // add all prime numbers to the list
        for (int prime : primeNumbers) {
            super.add(prime);
        }
    }

    /**
     * Removes from the specified index onwards.
     *
     * @param index The index of the number to be removed.
     * @return The number that corresponds to that index.
     */
    @Override
    public int remove(int index) {
        int number = get(index);

        for (int i = 0; i < size(); i++) {
            if (i >= index) {
                super.remove(i);
            }
        }

        return number;
    }
}
