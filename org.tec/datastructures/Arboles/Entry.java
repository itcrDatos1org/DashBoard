package datastructures.Arboles;


public class Entry {
    public Comparable key;
    public final Object val;
    public Node next;

    public Entry(Comparable key, Object val, Node next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
