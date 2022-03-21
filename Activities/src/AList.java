/*
 * Modified from Frank M. Carrano's
 * Data Structures and Abstractions with Java (3rd Edition)
 */
import java.util.Arrays;

public class AList<T>{
    private T[] list;
    private int size = 0;

    public AList(){
        list = (T[])new Object[10];
    }

    public AList(int initialCapacity){
        list = (T[])new Object[initialCapacity];
    }

    public boolean add(int newPosition, T element) {
        // immediately return false for invalid index
        if (newPosition < 0 || newPosition > (size - 1)) {
            return false;
        }

        // create a temporary array to hold the original values
        T[] temp = (T[])new Object[list.length];

        // copy the original to the temp
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        // now create a new list with increased size for the original list
        list = (T[])new Object[list.length + 1];

        // insert the element with the given position
        list[newPosition] = element;

        // then copy the rest of the original elements
        int index = 0;
        for (T originalElement : temp) {
            if (newPosition == index) {
                // avoid this position since the new element is inserted to this position
                // so nudge the current index by one
                ++index;
            }

            // insert again the original value
            list[index] = originalElement;

            // increment the current index
            ++index;
        }

        // increase the size since we inserted a value
        ++size;

        return true;
    }

    public void add(T[] list) {
        // create a temporary array to hold the original values
        T[] temp = (T[])new Object[this.list.length + list.length];

        // copy the original to the temp
        for (int i = 0; i < this.list.length; i++) {
            temp[i] = this.list[i];
        }

        // get the last index of empty position
        int lastIndex = -1;
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == null) {
                lastIndex = i;
                // break immediately since we found it
                break;
            }
        }

        // concatenate the list starting from the index with last empty value
        for (T element : list) {
            temp[lastIndex] = element;
            ++lastIndex;

            // increment size as well
            ++size;
        }

        // recreate the list with the new size
        this.list = (T[])new Object[temp.length];

        // copy everything from the temp
        int index = 0;
        for (T element : temp) {
            this.list[index] = element;
            ++index;
        }
    }

    public T remove(int givenPosition) {
        if (size > 0) {
            // get the selected position
            T selected = this.list[givenPosition];
            // make the value of that position empty
            this.list[givenPosition] = null;

            // temporary list for holding new set of values
            T[] temp = (T[])new Object[this.list.length];

            // copy everything to temp except for the given position
            int index = 0;
            for (T element : this.list) {
                if (element == null) {
                    // skip the null
                    continue;
                }

                temp[index] = element;
                ++index;
            }

            // recreate the list
            this.list = (T[])new Object[this.list.length];

            // copy the new set of values back
            index = 0;
            for (T element : temp) {
                this.list[index] = element;
                ++index;
            }

            // finally, decrement and return the selected
            --size;
            return selected;
        }

        return null;
    }

    public boolean contains(T element) {
        for (T listElement : list) {
            if (element.equals(listElement)) {
                // element found therefore return true immediately
                return true;
            }
        }

        // list was exhausted and the element was not found.
        return false;
    }

    @Override
    public String toString() {
        T[] temp = (T[])new Object[size];

        for (int i = 0; i < size; i++) {
            temp[i] = this.list[i];
        }

        return Arrays.toString(temp);
    }
}
