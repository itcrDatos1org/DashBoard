package datastructures.Arboles;

public class BinarySearchTree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public BinarySearchTree()
    {
        this.root = null;
    }

    public TreeNode<T> getRoot()
    {
        return this.root;
    }

    public boolean contains(T data)
    {
        return contains(data, this.root);
    }

    private boolean contains(T element, TreeNode<T> node)
    {
        if (node == null) {
            return false;
        }
        if (node.getData().compareTo(element) == 0) {
            return true;
        }
        if (node.getData().compareTo(element) > 0) {
            return contains(element, node.getLeft());
        }
        if (node.getData().compareTo(element) < 0) {
            return contains(element, node.getRight());
        }
        return false;
    }

    public TreeNode<T> getElement(T element)
    {
        return getElement(element, this.root);
    }

    private TreeNode<T> getElement(T element, TreeNode<T> node)
    {
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(element) == 0) {
            return node;
        }
        if (node.getData().compareTo(element) < 0) {
            return getElement(element, node.getRight());
        }
        return getElement(element, node.getLeft());
    }

    public void insert(T data)
    {
        TreeNode<T> nodeAux = new TreeNode(data);
        if (this.root == null) {
            this.root = nodeAux;
        } else {
            this.root = insert(nodeAux, this.root);
        }
    }

    private TreeNode<T> insert(TreeNode<T> NodeAux, TreeNode<T> aux)
    {
        TreeNode<T> nodeAUX = aux;
        if (NodeAux.getData().compareTo(aux.getData()) < 0)
        {
            if (aux.getLeft() == null) {
                aux.setLeft(NodeAux);
            } else {
                aux.setLeft(insert(NodeAux, aux.getLeft()));
            }
        }
        else if (NodeAux.getData().compareTo(aux.getData()) > 0)
        {
            if (aux.getRight() == null) {
                aux.setRight(NodeAux);
            } else {
                aux.setRight(insert(NodeAux, aux.getRight()));
            }
        }
        else {
            System.out.println("Nodo duplicado");
        }
        return nodeAUX;
    }

    public void remove(T element)
    {
        this.root = remove(element, this.root);
    }

    private TreeNode<T> remove(T element, TreeNode<T> node)
    {
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(element) < 0) {
            node.setRight(remove(element, node.getRight()));
        } else if (node.getData().compareTo(element) > 0) {
            node.setLeft(remove(element, node.getLeft()));
        } else if (node.getLeft() == null) {
            node = node.getRight();
        } else if (node.getRight() == null) {
            node = node.getLeft();
        }
        return node;
    }

    public void print()
    {
        print(this.root);
    }

    private void print(TreeNode<T> node)
    {
        if (node != null)
        {
            print(node.getLeft());
            System.out.print(node.getData() + ", ");
            print(node.getRight());
        }
    }
}