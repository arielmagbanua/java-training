import java.util.ArrayList;

public class QuickSorting {
    /**
     * This method takes the last item as pivot, places the pivot element at it's correct position in sorted list,
     * and places all smaller items (smaller than pivot) to left of pivot and all bigger items to the right of pivot.
     *
     * @param list The list to sort
     * @param startIndex The starting index
     * @param endIndex The ending index
     * @return Returns the partition index.
     */
    public int partition(ArrayList<Integer> list, int startIndex, int endIndex) {
        // pivot item
        int pivot = list.get(endIndex);

        // Index of smaller element and indicates the right position of pivot found so far
        int i = (startIndex - 1);

        for(int j = startIndex; j <= endIndex - 1; j++) {
            // If current element is smaller than the pivot
            if (list.get(j) < pivot) {
                // Increment index of smaller element
                i++;

                // swap
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // swap
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(endIndex));
        list.set(endIndex, temp);

        return (i + 1);
    }

    /**
     * The method that executes quick sort.
     *
     * @param list The list to sort
     * @param startIndex The starting index
     * @param endIndex The ending index
     */
    public void partitionQuickSort(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // pi is partitioning index, list at index pi is now at right place
            int pi = partition(list, startIndex, endIndex);

            // Separately sort elements before partition and after partition
            partitionQuickSort(list, startIndex, pi - 1);
            partitionQuickSort(list, pi + 1, endIndex);
        }
    }

    /**
     * The main method for doing quick sort.
     *
     * @param list The list to sort.
     * @return Returns the sorted list.
     */
    public ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        partitionQuickSort(list, 0, list.size() - 1);
        return list;
    }

    public static void main(String[] args) {
        QuickSorting sorting = new QuickSorting();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(-4);
        list.add(9);
        list.add(2);
        list.add(88);
        list.add(23);
        list.add(4);
        list.add(0);

        System.out.println(list);
        ArrayList<Integer> sorted = sorting.quickSort(list);
        System.out.println(sorted);
    }
}
