import java.util.NoSuchElementException;

public class Queue<T> implements Q<T> {
    private T[] queue;
    private int curr_size;

    /****CONSTRUCTORS****/

    /**
     * Default constructor for the Queue class
     * with an initial length of 10 and
     * no elements
     */
    @SuppressWarnings("unchecked")
    public Queue() {
        queue = (T[]) new Object[10];
        curr_size = 0;

    }

    /**
     * Converts an array into a Queue
     * @param array the array to copy into the array
     */
    @SuppressWarnings("unchecked")
    public Queue(T[] array) {
        queue = array;
        curr_size = array.length;
    }

    /**
     * Copy constructor for the Queue class
     * @param original the Queue to copy
     * @postcondition a new Queue object which is
     * an identical, but distinct, copy of original
     */
    @SuppressWarnings("unchecked")
    public Queue(Queue<T> original) {
        // initialize the queue
        queue = (T[]) new Object[original.queue.length];

        // update the current size
        curr_size = queue.length;

        // now copy
        for (int i = 0; i < curr_size; i++) {
            queue[i] = original.queue[i];
        }
    }

    @Override
    public T getFront() throws NoSuchElementException {
        if (!isEmpty()) {
            return queue[0];
        }

        throw new NoSuchElementException();
    }

    @Override
    public int getSize() {
        return curr_size;
    }

    @Override
    public boolean isEmpty() {
        return curr_size == 0;
    }

    @Override
    public void enqueue(T data) {
        // increased the size since we are adding data
        ++curr_size;

        // if the current size exceeds the length of the array
        // then create a new array that matches the new size
        if (curr_size > queue.length) {
            T[] newQueue = (T[]) new Object[curr_size];

            // copy each item from the old
            for (int i = 0; i < queue.length; i++) {
                newQueue[i] = queue[i];
            }

            // assign the new queue after copying
            queue = newQueue;
        }

        // get the index of the last slot
        int lastIndex = curr_size - 1;

        // insert at the end of the array
        queue[lastIndex] = data;
    }

    @Override
    public void dequeue() throws NoSuchElementException {
        if (!isEmpty()) {
            // decrease current size since we are removing an item
            --curr_size;

            // create a new queue that will hold the updated array
            // without the top element
            T[] newQueue = (T[]) new Object[curr_size];

            // now copy beginning at index 1
            for (int i = 0; i < curr_size; i++) {
                newQueue[i] = queue[i + 1];
            }

            // assign the new queue after copying
            queue = newQueue;
            return;
        }

        // at this point queue us empty
        throw new NoSuchElementException();
    }

    @Override
    public String reverseQueue() {
        StringBuilder items = new StringBuilder();

        // reverse loop to start at the end of the array
        // creates comma separated value
        for (int i = queue.length - 1; i >= 0; i--) {
            // disregard empty or null slots
            if (queue[i] != null) {
                items.append(queue[i]).append(",");
            }
        }

        // remove last comma
        items.deleteCharAt(items.length() - 1);

        // return a array likse string
        return String.format("[%s]", items);
    }
}
