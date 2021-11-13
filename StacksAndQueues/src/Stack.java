public class Stack {
    /** Constant to return instead of nulls */
    private static final String NOTHING = "*NOTHING TO REMOVE*";

    /** Underlying storage mechanism */
    private String[] foundation;

    /** How many of the array elements are used? */
    private int usage;


    /**
     * Basic constructor. Initializes underlying array and sets usage to 0.
     *
     * @param capacity int size of underlying array.
     */
    public Stack(int capacity) {
        this.foundation = new String[capacity];
        this.usage = 0;
    } // constructor Stack

    /**
     * Retrieves the last item inserted without removing it.
     *
     * @return The last item inserted
     */
    public String peek() {
        // return the last item inserted in the stack
        int count = utilizedSlots();

        if (count >= 1) {
            // return the last inserted item
            return foundation[count - 1];
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
     * Method to insert a string to the stack, if there is room.
     *
     * @param string String value to add to stack
     * @return true if insertion successful, false is there is no room in the underlying array
     */
    public boolean push(String string) {
        // Is there room in the stack?
        boolean roomForOneMore = this.usage < this.foundation.length;
        if (roomForOneMore) {
            // Insert the new string to the topmost position
            this.foundation[this.foundation.length - this.usage - 1] = string;
            // Increase the usage of the stack
            usage++;
        }
        return roomForOneMore;
    } // method push



    /**
     * Method to extract a string from the stack
     *
     * @return String with extracted value or NOTHING if stack is empty
     */
    public String pop() {
        String removed = NOTHING;
        // Is there anything in the stack to remove?
        if (usage > 0) {
            // Obtain the topmost value from the stack
            removed = this.foundation[this.foundation.length - this.usage];
            // Clean up the array location
            this.foundation[this.foundation.length - this.usage] = null;
            // Decrease usage counter
            usage--;
        }
        return removed;
    } // method pop


    /**
     * Method to represent Stack object as a string.
     *
     * @return String with Stack content.
     */
    public String toString() {
        // Introducing StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\nThis stack has %d elements and %d of them are used",
                this.foundation.length, this.usage));
        sb.append("\n\t[ ");
        for (int i = this.foundation.length - this.usage; i < this.foundation.length; i++) {
            sb.append(String.format("%s ", foundation[i]));
        }
        sb.append("]");
        return sb.toString();
    } // method toString
}
