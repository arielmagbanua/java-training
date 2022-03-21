public class InstrumentsTest {
    public static void main(String[] args) {
        Guitar guitar1 = new Guitar(15.2, 6);
        Guitar guitar2 = new Guitar(10, 6);

        Piano piano1 = new Piano(6, 44);
        Piano piano2 = new Piano(10, 44);

        System.out.println(guitar1.play());
        System.out.println(piano1.play());

        System.out.println(guitar1.compareTo(piano1));
        System.out.println(piano1.compareTo(guitar1));
        System.out.println(guitar2.compareTo(piano2));
    }
}
