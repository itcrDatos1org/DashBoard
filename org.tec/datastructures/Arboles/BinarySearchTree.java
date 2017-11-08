package datastructures.Arboles;

public class BinarySearchTree<T extends Comparable<T>> {
    public TreeNode<T> root = null;

    public BinarySearchTree() {
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, TreeNode<T> node) {
        return node == null?false:(node.getData().compareTo(element) == 0?true:(node.getData().compareTo(element) > 0?this.contains(element, node.getLeft()):(node.getData().compareTo(element) < 0?this.contains(element, node.getRight()):false)));
    }

    public TreeNode<T> getElement(T element) {
        return this.getElement(element, this.root);
    }

    private TreeNode<T> getElement(T element, TreeNode<T> node) {
        return node == null?null:(node.getData().compareTo(element) == 0?node:(node.getData().compareTo(element) < 0?this.getElement(element, node.getRight()):this.getElement(element, node.getLeft())));
    }

    public void insert(T data) {
        TreeNode<T> nodeAux = new TreeNode(data);
        if(this.root == null) {
            this.root = nodeAux;
        } else {
            this.root = this.insert(nodeAux, this.root);
        }

    }

    private TreeNode<T> insert(TreeNode<T> NodeAux, TreeNode<T> aux) {
        if(NodeAux.getData().compareTo(aux.getData()) < 0) {
            if(aux.getLeft() == null) {
                aux.setLeft(NodeAux);
            } else {
                aux.setLeft(this.insert(NodeAux, aux.getLeft()));
            }
        } else if(NodeAux.getData().compareTo(aux.getData()) > 0) {
            if(aux.getRight() == null) {
                aux.setRight(NodeAux);
            } else {
                aux.setRight(this.insert(NodeAux, aux.getRight()));
            }
        } else {
            System.out.println("Nodo duplicado");
        }

        return aux;
    }

    public void remove(T element) {
        this.root = this.remove(element, this.root);
    }

    private TreeNode<T> remove(T element, TreeNode<T> node) {
        if(node == null) {
            return null;
        } else {
            if(node.getData().compareTo(element) < 0) {
                node.setRight(this.remove(element, node.getRight()));
            } else if(node.getData().compareTo(element) > 0) {
                node.setLeft(this.remove(element, node.getLeft()));
            } else if(node.getLeft() == null) {
                node = node.getRight();
            } else if(node.getRight() == null) {
                node = node.getLeft();
            }

            return node;
        }
    }

    public void print() {
        this.print(this.root);
    }

    private void print(TreeNode<T> node) {
        if(node != null) {
            this.print(node.getLeft());
            System.out.print(node.getData() + ", ");
            this.print(node.getRight());
        }

    }
}