package datastructures.Arboles;

public class BTree<Key extends Comparable<Key>, Value> {
    public static final int M = 4;
    public BTree.Node root = new BTree.Node(0);
    public int height;
    public int n;

    public BTree() {
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.n;
    }

    public int height() {
        return this.height;
    }

    public Value getElement(Key key) {
        if(key == null) {
            throw new IllegalArgumentException("Insertar Elemento");
        } else {
            return this.search(this.root, key, this.height);
        }
    }

    private Value search(BTree.Node x, Key key, int ht) {
        BTree.Entry[] children = x.children;
        int j;
        if(ht == 0) {
            for(j = 0; j < x.m; ++j) {
                if(this.eq(key, children[j].key)) {
                    return children[j].val;
                }
            }
        } else {
            for(j = 0; j < x.m; ++j) {
                if(j + 1 == x.m || this.less(key, children[j + 1].key)) {
                    return this.search(children[j].next, key, ht - 1);
                }
            }
        }

        return null;
    }

    public void insert(Key key, Value val) {
        if(key == null) {
            throw new IllegalArgumentException("argument key to put() is null");
        } else {
            BTree.Node u = this.insert(this.root, key, val, this.height);
            ++this.n;
            if(u != null) {
                BTree.Node t = new BTree.Node(2);
                t.children[0] = new BTree.Entry(this.root.children[0].key, (Object)null, this.root);
                t.children[1] = new BTree.Entry(u.children[0].key, (Object)null, u);
                this.root = t;
                ++this.height;
            }
        }
    }

    private BTree.Node insert(BTree.Node h, Key key, Value val, int ht) {
        BTree.Entry t = new BTree.Entry(key, val, (BTree.Node)null);
        int j;
        if(ht == 0) {
            for(j = 0; j < h.m && !this.less(key, h.children[j].key); ++j) {
                ;
            }
        } else {
            for(j = 0; j < h.m; ++j) {
                if(j + 1 == h.m || this.less(key, h.children[j + 1].key)) {
                    BTree.Node u = this.insert(h.children[j++].next, key, val, ht - 1);
                    if(u == null) {
                        return null;
                    }

                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for(int i = h.m; i > j; --i) {
            h.children[i] = h.children[i - 1];
        }

        h.children[j] = t;
        ++h.m;
        return h.m < 4?null:this.split(h);
    }

    private BTree.Node split(BTree.Node h) {
        BTree.Node t = new BTree.Node(2);
        h.m = 2;

        for(int j = 0; j < 2; ++j) {
            t.children[j] = h.children[2 + j];
        }

        return t;
    }

    public String getStringToPrint() {
        return this.toString(this.root, this.height, "") + "\n";
    }

    private String toString(BTree.Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        BTree.Entry[] children = h.children;
        int j;
        if(ht == 0) {
            for(j = 0; j < h.m; ++j) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        } else {
            for(j = 0; j < h.m; ++j) {
                if(j > 0) {
                    s.append(indent + "(" + children[j].key + ")\n");
                }

                s.append(this.toString(children[j].next, ht - 1, indent + "     "));
            }
        }

        return s.toString();
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    private static class Entry {
        public Comparable key;
        public final Object val;
        public BTree.Node next;

        public Entry(Comparable key, Object val, BTree.Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private static final class Node {
        public int m;
        public BTree.Entry[] children = new BTree.Entry[4];

        public Node(int k) {
            this.m = k;
        }
    }
}