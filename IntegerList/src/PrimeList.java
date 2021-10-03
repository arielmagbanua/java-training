public class PrimeList extends IntegerList {
    public static final int FIRST_PRIME = 2;

    public PrimeList() {
        super();
    }

    public PrimeList(int upperBound) {
        super(upperBound);

        if (upperBound < 0) {
            throw new IllegalArgumentException("PROVIDE_THE_MESSAGE_SHOWN_IN_UNIT_TESTS");
        }
    }

    private boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1) {
            return false;
        }

        // Check from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void add(int upperBound) {
        if (upperBound < FIRST_PRIME) {
            throw new IllegalArgumentException("The upper bound cannot be less than " + FIRST_PRIME);
        }

        // generate the primes
        int[] primes = new int[upperBound];
        int indexRef = 0;
        for (int i = 1; i < upperBound + 1; i++) {
            if (isPrime(i)) {
                primes[indexRef++] = i;
            }
        }

        if (upperBound <= primes[primes.length - 1]) {
            throw new IllegalArgumentException("The upper bound must be greater than the last prime in the list: " + primes[primes.length - 1]);
        }

        // add all primes
        for (int prime : primes) {
            super.add(prime);
        }
    }

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

    @Override
    public void insert(int index, int integer) {
        throw new UnsupportedOperationException();
    }
}
