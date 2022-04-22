import java.util.ArrayList;
import java.util.*;
public class IntegerSet{
    private List<Integer> set;

    public IntegerSet(){
        set = new ArrayList<Integer>();
    }

    public void clear(){
        set.clear();
    }

    public int length(){
        return set.size();
    }

    public boolean equals(IntegerSet b){
        for(int i=0;i<set.size();i++){
            boolean found = false;
            for(int j=0;j<b.length();j++){
                if(set.get(i) == b.set.get(j))
                    found = true;
            }
            if(!found)
                return false;
        }
        return true;
    }

    public boolean contains(int value){
        return set.contains(value);
    }

    public int largest() throws IntegerSetException{
        if(set.isEmpty())
            throw new IntegerSetException();
        int large = Integer.MIN_VALUE;
        for(int i=0;i<set.size();i++){
            if(set.get(i) > large)
                large = set.get(i);
        }
        return large;
    }

    public int smallest() throws IntegerSetException{
        if(set.isEmpty())
            throw new IntegerSetException();
        int small = Integer.MAX_VALUE;
        for(int i=0;i<set.size();i++){
            if(set.get(i) < small)
                small = set.get(i);
        }
        return small;
    }

    public void add(int item){
        if(!set.contains(item))
            set.add(item);
    }

    public void remove(int item) throws IntegerSetException{
        if(set.isEmpty())
            throw new IntegerSetException();
        set.remove(item);
    }

    public void union(IntegerSet intSetb){
        for(int i=0;i<intSetb.length();i++){
            if(!set.contains(intSetb.set.get(i)))
                set.add(intSetb.set.get(i));
        }
    }

    public void intersect(IntegerSet intSetb){
        for(int i=0;i<intSetb.length();i++){
            if(!set.contains(intSetb.set.get(i)))
                set.remove(intSetb.set.get(i));
        }
    }

    public void diff(IntegerSet intSetb){
        for(int i=0;i<intSetb.length();i++){
            if(set.contains(intSetb.set.get(i)))
                set.remove(intSetb.set.get(i));
        }
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    @Override
    public String toString(){
        return set.toString();
    }
}
