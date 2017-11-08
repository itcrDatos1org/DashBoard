package datastructures.Arboles;

public class SplayTree<Key extends Comparable<Key>, Value> {
    public SplayTree<Key, Value>.Node root;

    public SplayTree() {
    }

    public boolean contains(Key key) {
        return this.getElement(key) != null;
    }

    public Value getElement(Key key) {
        this.root = this.splay(this.root, key);
        int cmp = key.compareTo(this.root.key);
        return cmp == 0?this.root.value:null;
    }

    public void insert(Key key, Value value) {
        if(this.root == null) {
            this.root = new SplayTree.Node(key, value);
        } else {
            this.root = this.splay(this.root, key);
            int cmp = key.compareTo(this.root.key);
            SplayTree.Node n;
            if(cmp < 0) {
                n = new SplayTree.Node(key, value);
                n.left = this.root.left;
                n.right = this.root;
                this.root.left = null;
                this.root = n;
            } else if(cmp > 0) {
                n = new SplayTree.Node(key, value);
                n.right = this.root.right;
                n.left = this.root;
                this.root.right = null;
                this.root = n;
            } else {
                this.root.value = value;
            }

        }
    }

    public void remove(Key key) {
        if(this.root != null) {
            this.root = this.splay(this.root, key);
            int cmp = key.compareTo(this.root.key);
            if(cmp == 0) {
                if(this.root.left == null) {
                    this.root = this.root.right;
                } else {
                    SplayTree<Key, Value>.Node x = this.root.right;
                    this.root = this.root.left;
                    this.splay(this.root, key);
                    this.root.right = x;
                }
            }

        }
    }

    private SplayTree<Key, Value>.Node splay(SplayTree<Key, Value>.Node h, Key key) {
        if(h == null) {
            return null;
        } else {
            int cmp1 = key.compareTo(h.key);
            int cmp2;
            if(cmp1 < 0) {
                if(h.left == null) {
                    return h;
                } else {
                    cmp2 = key.compareTo(h.left.key);
                    if(cmp2 < 0) {
                        h.left.left = this.splay(h.left.left, key);
                        h = this.rotateRight(h);
                    } else if(cmp2 > 0) {
                        h.left.right = this.splay(h.left.right, key);
                        if(h.left.right != null) {
                            h.left = this.rotateLeft(h.left);
                        }
                    }

                    return h.left == null?h:this.rotateRight(h);
                }
            } else if(cmp1 > 0) {
                if(h.right == null) {
                    return h;
                } else {
                    cmp2 = key.compareTo(h.right.key);
                    if(cmp2 < 0) {
                        h.right.left = this.splay(h.right.left, key);
                        if(h.right.left != null) {
                            h.right = this.rotateRight(h.right);
                        }
                    } else if(cmp2 > 0) {
                        h.right.right = this.splay(h.right.right, key);
                        h = this.rotateLeft(h);
                    }

                    return h.right == null?h:this.rotateLeft(h);
                }
            } else {
                return h;
            }
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(SplayTree<Key, Value>.Node x) {
        return x == null?-1:1 + Math.max(this.height(x.left), this.height(x.right));
    }

    public int size() {
        return this.size(this.root);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    private int size(SplayTree<Key, Value>.Node x) {
        return x == null?0:1 + this.size(x.left) + this.size(x.right);
    }

    private SplayTree<Key, Value>.Node rotateRight(SplayTree<Key, Value>.Node h) {
        SplayTree<Key, Value>.Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    private SplayTree<Key, Value>.Node rotateLeft(SplayTree<Key, Value>.Node h) {
        SplayTree<Key, Value>.Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    public void print() {
        this.print(this.root);
    }

    private void print(SplayTree<Key, Value>.Node node) {
        if(node != null) {
            this.print(node.left);
            System.out.print(node.value + ", ");
            this.print(node.right);
        }

    }

    private class Node {
        public Key key;
        public Value value;
        public SplayTree<Key, Value>.Node left;
        public SplayTree<Key, Value>.Node right;

        public Node(Key var1, Value key) {
            this.key = (Key) key;
            this.value = value;
        }
    }
}
