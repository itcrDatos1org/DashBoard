package datastructures.Arboles;


public class Node {
    public int m;
    public Entry[] children = new Entry[4];

    public Node(int k) {
        this.m = k;
    }
}
