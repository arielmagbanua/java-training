public class Main {
    public static void main(String[] args) {
        // basic test
        var integers = new Queue<Integer>();
        integers.enqueue(1);
        integers.enqueue(3);
        integers.enqueue(4);
        integers.enqueue(6);

        System.out.println(integers.getFront());
        System.out.println(integers.getSize());
        integers.dequeue();
        System.out.println(integers.reverseQueue());

        var copiedIntegers = new Queue<>(integers);
        System.out.println(copiedIntegers.reverseQueue());

        var names = new String[] {"John", "Jane", "Max", "Zoe"};
        var strings = new Queue(names);
        System.out.println(strings.reverseQueue());
    }
}
