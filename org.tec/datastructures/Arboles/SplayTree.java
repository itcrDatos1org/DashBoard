package datastructures.Arboles;

import java.io.PrintStream;

public class SplayTree<Key extends Comparable<Key>, Value>
{
    public SplayTree<Key, Value>.Node root;

    private class Node
    {
        public Key key;
        public Value value;
        public SplayTree<Key, Value>.Node left;
        public SplayTree<Key, Value>.Node right;

        public Node(Key value, Value key)
        {
            this.key = (Key) key;
            this.value = (Value) value;
        }
    }

    public boolean contains(Key key)
    {
        return getElement(key) != null;
    }

    public Value getElement(Key key)
    {
        this.root = splay(this.root, key);
        int cmp = key.compareTo(this.root.key);
        if (cmp == 0) {
            return (Value)this.root.value;
        }
        return null;
    }

    public void insert(Key key, Value value)
    {
        if (this.root == null)
        {
            this.root = new Node(key, value);
            return;
        }
        this.root = splay(this.root, key);

        int cmp = key.compareTo(this.root.key);
        if (cmp < 0)
        {
            SplayTree<Key, Value>.Node n = new Node(key, value);
            n.left = this.root.left;
            n.right = this.root;
            this.root.left = null;
            this.root = n;
        }
        else if (cmp > 0)
        {
            SplayTree<Key, Value>.Node n = new Node(key, value);
            n.right = this.root.right;
            n.left = this.root;
            this.root.right = null;
            this.root = n;
        }
        else
        {
            this.root.value = value;
        }
    }

    public void remove(Key key)
    {
        if (this.root == null) {
            return;
        }
        this.root = splay(this.root, key);

        int cmp = key.compareTo(this.root.key);
        if (cmp == 0) {
            if (this.root.left == null)
            {
                this.root = this.root.right;
            }
            else
            {
                SplayTree<Key, Value>.Node x = this.root.right;
                this.root = this.root.left;
                splay(this.root, key);
                this.root.right = x;
            }
        }
    }

    private SplayTree<Key, Value>.Node splay(SplayTree<Key, Value>.Node h, Key key)
    {
        if (h == null) {
            return null;
        }
        int cmp1 = key.compareTo(h.key);
        if (cmp1 < 0)
        {
            if (h.left == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.left.key);
            if (cmp2 < 0)
            {
                h.left.left = splay(h.left.left, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0)
            {
                h.left.right = splay(h.left.right, key);
                if (h.left.right != null) {
                    h.left = rotateLeft(h.left);
                }
            }
            if (h.left == null) {
                return h;
            }
            return rotateRight(h);
        }
        if (cmp1 > 0)
        {
            if (h.right == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.right.key);
            if (cmp2 < 0)
            {
                h.right.left = splay(h.right.left, key);
                if (h.right.left != null) {
                    h.right = rotateRight(h.right);
                }
            }
            else if (cmp2 > 0)
            {
                h.right.right = splay(h.right.right, key);
                h = rotateLeft(h);
            }
            if (h.right == null) {
                return h;
            }
            return rotateLeft(h);
        }
        return h;
    }

    public int height()
    {
        return height(this.root);
    }

    private int height(SplayTree<Key, Value>.Node x)
    {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public int size()
    {
        return size(this.root);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    private int size(SplayTree<Key, Value>.Node x)
    {
        if (x == null) {
            return 0;
        }
        return 1 + size(x.left) + size(x.right);
    }

    private SplayTree<Key, Value>.Node rotateRight(SplayTree<Key, Value>.Node h)
    {
        SplayTree<Key, Value>.Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private SplayTree<Key, Value>.Node rotateLeft(SplayTree<Key, Value>.Node h)
    {
        SplayTree<Key, Value>.Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    public void print()
    {
        print(this.root);
    }

    private void print(SplayTree<Key, Value>.Node node)
    {
        if (node != null)
        {
            print(node.left);
            System.out.print(node.value + ", ");
            print(node.right);
        }
    }
}
