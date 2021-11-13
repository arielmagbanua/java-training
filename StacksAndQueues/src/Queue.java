public class Queue {
    /** Value to return when there is nothing to remove from queue */
    private static final String NOTHING = "*QUEUE IS EMPTY*";

    /** Underlying array to hold the queue */
    private String[] foundation;

    /** How many of the array's elements are in use? */
    private int usage;

    /**
     * Basic constructor.
     * @param capacity int how many elements the queue can hold
     */
    public Queue(int capacity) {
        this.foundation = new String[capacity];
        this.usage = 0;
    } // constructor Queue

    /**
     * Retrieves the first item in line.
     *
     * @return The first item in line.
     */
    public String peek() {
        int count = utilizedSlots();

        if (count >= 1) {
            // return the first in line of the queue
            return foundation[0];
        }

        // there no store items
        return NOTHING;
    }

    /**
     * Return the number of slots occupied.
     *
     * @return The number of slots.
     */
    protected int utilizedSlots() {
        // get the actual length of occupied slots
        int count = 0;
        for (String item : foundation) {
            if (item == null) {
                break;
            }

            ++count;
        }

        return count;
    }

    /**
     * Calculates the utilization percentage. By dividing number of slots occupied
     * over length of foundation multiplied by 100.
     *
     * Example:
     * utilized slots = 3
     * length = 4
     *
     * 3/4 * 100 = 75.0
     *
     * @return Returns the utilization in percentage.
     */
    public double utilization() {
        return ((double)utilizedSlots() / (double) foundation.length) * 100.0;
    }

    /**
     * Method to add element to queue. Element is added always to the back of the queue.
     * @param string String to add to the queue
     * @return true if insertion was successful; false if there is no room for more elements
     */
    public boolean enqueue(String string) {
        // Assess if there is room in the array
        boolean roomForOneMore = this.usage < this.foundation.length;
        // If there is room, add this element to the end of the queue and update usage
        if (roomForOneMore)
            this.foundation[this.usage++] = string;
        return roomForOneMore;
    }  // method enqueue


    /**
     * Method to extract and return whatever is in the front of the queue
     *
     * @return String at front of the array or NOTHING is usage==0
     */
    public String dequeue() {
        String string = NOTHING;
        // Make sure there are elements in the queue
        if (this.usage > 0) {
            // Grab what's at the front of the queue
            string = this.foundation[0];
            // Move everyone one step forward
            for (int i = 0; i < this.usage - 1; i++)
                this.foundation[i] = this.foundation[i+1];
            // Clear the last location and update usage
            this.foundation[usage-1] = null;
            usage--;
        }
        return string;
    } // method dequeue

    /**
     * Overrride default String
     * @return String representation of the queue.
     */
    public String toString() {
        // Introducing StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nThis queue has %d elements and %d of them are used",
                this.foundation.length, this.usage));
        sb.append("\n\t[ ");
        for (int i = 0; i < this.usage; i++) {
            sb.append(String.format("%s ", foundation[i]));
        }
        sb.append("]");
        return sb.toString();
    } // method toString
}
