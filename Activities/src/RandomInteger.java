import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import static java.util.Collections.list;
import static java.util.Collections.unmodifiableSortedSet;

public class RandomInteger
{

    public static void main(String[] arg)
    {

        LinkedList<Integer> list =new LinkedList<Integer>();
        Random rand = new Random();

        // Selecting the random integers
        for(int i = 0 ;i<25;i++)
        {
            list.add(rand.nextInt(100));
        }

        // Calculating the sum of the sorted list
        int sum = 0;

        for(Integer i : list)
        {
            sum+=i;
        }

        // Calculating the average of the sorted list
        float average = sum / 25;

        System.out.println("Random integers selected unsorted:");
        for (int i = 0; i < list.size(); i ++)
        {
            System.out.print(list.get(i) + " ");
        }

        // sort the list
        Collections.sort(list);

        System.out.println("\nRandom integers selected and sorted:");
        for (int i = 0; i < list.size(); i ++)
        {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        System.out.println("Sum of random integers selected: "+sum+"\nAverage of random integers selected: "+average);
    }
}