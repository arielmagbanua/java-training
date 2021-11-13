public class QueueImplementation {
    public static void main(String[] args) {
        Queue ourFirstQueue = new Queue(4);
        ourFirstQueue.enqueue("A");
        ourFirstQueue.enqueue("B");
        ourFirstQueue.enqueue("C");
        ourFirstQueue.enqueue("D");
        ourFirstQueue.enqueue("E");
        System.out.println(ourFirstQueue);

        // test peek and utilization
        System.out.println(ourFirstQueue.peek());
        System.out.println(ourFirstQueue.utilization() + "%");

        ourFirstQueue.dequeue();
        System.out.println(ourFirstQueue);
        ourFirstQueue.dequeue();
        System.out.println(ourFirstQueue);
        ourFirstQueue.dequeue();
        System.out.println(ourFirstQueue);
        ourFirstQueue.dequeue();
        System.out.println(ourFirstQueue);
        ourFirstQueue.dequeue();
        System.out.println(ourFirstQueue);
        System.out.println(ourFirstQueue.dequeue());

        // test peek and utilization
        System.out.println(ourFirstQueue.peek());
        System.out.println(ourFirstQueue.utilization() + "%");
    }
}
