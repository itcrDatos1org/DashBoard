package datastructures.Arboles;


public class AVLTree<T extends Comparable<T>> {
//--------------------------------------------------------------------------------------//
    public AVLNode<T> root;
//--------------------------------------------------------------------------------------//
    public AVLTree()
        {
            this.root = null;
        }
//--------------------------------------------------------------------------------------//
    public AVLNode<T> getRoot()
        {
            return this.root;
        }

//--------------------------------------------------------------------------------------//
    public boolean contains(T data)
    {
        return contains(data, this.root);
    }
    private boolean contains(T element, AVLNode<T> node) {
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
//--------------------------------------------------------------------------------------//
    public AVLNode<T> getElement(T element)
    {
        return getElement(element, this.root);
    }
    private AVLNode<T> getElement(T element, AVLNode<T> node) {
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
//--------------------------------------------------------------------------------------//
    private int getBalanceFactor(AVLNode<T> node){
        if (node == null) {
            return -1;
        }
        return node.getBalanceFactor();
    }
//--------------------------------------------------------------------------------------//
    private AVLNode<T> leftRotation(AVLNode<T> node){
        AVLNode<T> aux = node.getLeft();

        node.setLeft(aux.getRight());
        aux.setRight(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);

        return aux;
    }
//--------------------------------------------------------------------------------------//
    private AVLNode<T> rightRotation(AVLNode<T> node){
        AVLNode<T> aux = node.getRight();

        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);

        return aux;
    }
//--------------------------------------------------------------------------------------//
    private AVLNode<T> doubleLeftRotation(AVLNode<T> node){
        node.setLeft(rightRotation(node.getLeft()));
        AVLNode<T> aux = leftRotation(node);
        return aux;
    }
//--------------------------------------------------------------------------------------//
    private AVLNode<T> doubleRightRotation(AVLNode<T> node){
        node.setRight(leftRotation(node.getRight()));
        AVLNode<T> aux = rightRotation(node);
        return aux;
    }
//--------------------------------------------------------------------------------------//
    public void insert(T data){
        AVLNode<T> newNode = new AVLNode(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root = insert(newNode, this.root);
        }
    }
    private AVLNode insert(AVLNode newNode, AVLNode subTree){
        AVLNode<T> newFather = subTree;
        if (newNode.getData().compareTo(subTree.getData()) < 0)
        {
            if (subTree.getLeft() == null)
            {
                subTree.setLeft(newNode);
            }
            else
            {
                subTree.setLeft(insert(newNode, subTree.getLeft()));
                if (getBalanceFactor(subTree.getLeft()) - getBalanceFactor(subTree.getRight()) == 2) {
                    if (newNode.getData().compareTo(subTree.getLeft().getData()) < 0) {
                        newFather = leftRotation(subTree);
                    } else {
                        newFather = doubleLeftRotation(subTree);
                    }
                }
            }
        }
        else if (newNode.getData().compareTo(subTree.getData()) > 0)
        {
            if (subTree.getRight() == null)
            {
                subTree.setRight(newNode);
            }
            else
            {
                subTree.setRight(insert(newNode, subTree.getRight()));
                if (getBalanceFactor(subTree.getRight()) - getBalanceFactor(subTree.getLeft()) == 2) {
                    if (newNode.getData().compareTo(subTree.getRight().getData()) > 0) {
                        newFather = rightRotation(subTree);
                    } else {
                        newFather = doubleRightRotation(subTree);
                    }
                }
            }
        }
        else {
            System.out.println("BNode3 duplicado");
        }
        if ((subTree.getLeft() == null) && (subTree.getRight() != null)) {
            subTree.setBalanceFactor(subTree.getRight().getBalanceFactor() + 1);
        } else if ((subTree.getRight() == null) && (subTree.getLeft() != null)) {
            subTree.setBalanceFactor(subTree.getLeft().getBalanceFactor() + 1);
        } else {
            subTree.setBalanceFactor(Math.max(getBalanceFactor(subTree.getLeft()), getBalanceFactor(subTree.getRight())) + 1);
        }
        return newFather;
    }
//--------------------------------------------------------------------------------------//
    public void remove(T element)
    {
        this.root = remove(element, this.root);
    }
    private AVLNode<T> remove(T element, AVLNode<T> node){
        if (node == null) {
            return null;
        }
        if (node.getData().compareTo(element) < 0)
        {
            node.setRight(remove(element, node.getRight()));
        }
        else if (node.getData().compareTo(element) > 0)
        {
            node.setLeft(remove(element, node.getLeft()));
        }
        else if (node.getLeft() == null)
        {
            node = node.getRight();
        }
        else if (node.getRight() == null)
        {
            node = node.getLeft();
        }
        else if (getBalanceFactor(node.getLeft()) > getBalanceFactor(node.getRight()))
        {
            node = rightRotation(node);
            node.setLeft(remove(element, node.getLeft()));
        }
        else
        {
            node = leftRotation(node);
            node.setRight(remove(element, node.getRight()));
        }
        if (node != null) {
            node.setBalanceFactor(getBalanceFactor(node.getLeft()) + getBalanceFactor(node.getRight()));
        }
        return node;
    }
//--------------------------------------------------------------------------------------//
    public void print()
    {
        print(this.root);
    }
    private void print(AVLNode<T> node){
        if (node != null)
        {
            print(node.getLeft());
            System.out.print(node.getData() + ", ");
            print(node.getRight());
        }
    }
//--------------------------------------------------------------------------------------//
}
