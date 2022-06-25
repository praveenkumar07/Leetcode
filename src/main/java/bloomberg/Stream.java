package bloomberg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stream {
    private HashSet<Integer> elements;
    private LinkedList<Integer> firstUnique;
    public Stream() {
        // do intialization if necessary
        this.elements = new HashSet<>();
        this.firstUnique = new LinkedList<>();
    }

    /**
     * Adds integer num to a stream of integers.
     */
    public void add(int num) {

        // write your code here
        if (elements.contains(num)) {
            firstUnique.remove(Integer.valueOf(num));
        } else {
            elements.add(num);
            firstUnique.add(num);
        }
    }

    /**
     *  Returns the first unique integer in the stream if found else return null.
     */
    public Integer getFirstUnique() {
        // write your code here
        try {
            return firstUnique.getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    public static void main(String...args){
        Stream s = new Stream();
        s.add(2);
        s.getFirstUnique(); // 2
        //s.add(2);
        s.getFirstUnique(); // null
        s.add(3);
        s.getFirstUnique(); // 3
        s.add(4);
        s.getFirstUnique(); // 3
        s.add(3);
        s.getFirstUnique(); // 4
    }
}
