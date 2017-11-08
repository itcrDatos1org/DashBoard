

package datastructures.Arboles.ArbolAvl;


public class AVLTree<T extends Comparable<T>> {
    public AVLNode<T> root = null;

    public AVLTree() {
    }

    public AVLNode<T> getRoot() {
        return this.root;
    }

    public boolean contains(T data) {
        return this.contains(data, this.root);
    }

    private boolean contains(T element, AVLNode<T> node) {
        return node == null?false:(node.getData().compareTo(element) == 0?true:(node.getData().compareTo(element) > 0?this.contains(element, node.getLeft()):(node.getData().compareTo(element) < 0?this.contains(element, node.getRight()):false)));
    }

    public AVLNode<T> getElement(T element) {
        return this.getElement(element, this.root);
    }

    private AVLNode<T> getElement(T element, AVLNode<T> node) {
        return node == null?null:(node.getData().compareTo(element) == 0?node:(node.getData().compareTo(element) < 0?this.getElement(element, node.getRight()):this.getElement(element, node.getLeft())));
    }

    private int getBalanceFactor(AVLNode<T> node) {
        return node == null?-1:node.getBalanceFactor();
    }

    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> aux = node.getLeft();
        node.setLeft(aux.getRight());
        aux.setRight(node);
        node.setBalanceFactor(Math.max(this.getBalanceFactor(node.getLeft()), this.getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(this.getBalanceFactor(aux.getLeft()), this.getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> aux = node.getRight();
        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setBalanceFactor(Math.max(this.getBalanceFactor(node.getLeft()), this.getBalanceFactor(node.getRight())) + 1);
        aux.setBalanceFactor(Math.max(this.getBalanceFactor(aux.getLeft()), this.getBalanceFactor(aux.getRight())) + 1);
        return aux;
    }

    private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
        node.setLeft(this.rightRotation(node.getLeft()));
        AVLNode<T> aux = this.leftRotation(node);
        return aux;
    }

    private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
        node.setRight(this.leftRotation(node.getRight()));
        AVLNode<T> aux = this.rightRotation(node);
        return aux;
    }

    public void insert(T data) {
        AVLNode<T> newNode = new AVLNode(data);
        if(this.root == null) {
            this.root = newNode;
        } else {
            this.root = this.insert(newNode, this.root);
        }

    }

    private AVLNode insert(AVLNode newNode, AVLNode subTree) {
        AVLNode<T> newFather = subTree;
        if(newNode.getData().compareTo(subTree.getData()) < 0) {
            if(subTree.getLeft() == null) {
                subTree.setLeft(newNode);
            } else {
                subTree.setLeft(this.insert(newNode, subTree.getLeft()));
                if(this.getBalanceFactor(subTree.getLeft()) - this.getBalanceFactor(subTree.getRight()) == 2) {
                    if(newNode.getData().compareTo(subTree.getLeft().getData()) < 0) {
                        newFather = this.leftRotation(subTree);
                    } else {
                        newFather = this.doubleLeftRotation(subTree);
                    }
                }
            }
        } else if(newNode.getData().compareTo(subTree.getData()) > 0) {
            if(subTree.getRight() == null) {
                subTree.setRight(newNode);
            } else {
                subTree.setRight(this.insert(newNode, subTree.getRight()));
                if(this.getBalanceFactor(subTree.getRight()) - this.getBalanceFactor(subTree.getLeft()) == 2) {
                    if(newNode.getData().compareTo(subTree.getRight().getData()) > 0) {
                        newFather = this.rightRotation(subTree);
                    } else {
                        newFather = this.doubleRightRotation(subTree);
                    }
                }
            }
        } else {
            System.out.println("BNode3 duplicado");
        }

        if(subTree.getLeft() == null && subTree.getRight() != null) {
            subTree.setBalanceFactor(subTree.getRight().getBalanceFactor() + 1);
        } else if(subTree.getRight() == null && subTree.getLeft() != null) {
            subTree.setBalanceFactor(subTree.getLeft().getBalanceFactor() + 1);
        } else {
            subTree.setBalanceFactor(Math.max(this.getBalanceFactor(subTree.getLeft()), this.getBalanceFactor(subTree.getRight())) + 1);
        }

        return newFather;
    }

    public void remove(T element) {
        this.root = this.remove(element, this.root);
    }

    private AVLNode<T> remove(T element, AVLNode<T> node) {
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
            } else if(this.getBalanceFactor(node.getLeft()) > this.getBalanceFactor(node.getRight())) {
                node = this.rightRotation(node);
                node.setLeft(this.remove(element, node.getLeft()));
            } else {
                node = this.leftRotation(node);
                node.setRight(this.remove(element, node.getRight()));
            }

            if(node != null) {
                node.setBalanceFactor(this.getBalanceFactor(node.getLeft()) + this.getBalanceFactor(node.getRight()));
            }

            return node;
        }
    }

    public void print() {
        this.print(this.root);
    }

    private void print(AVLNode<T> node) {
        if(node != null) {
            this.print(node.getLeft());
            System.out.print(node.getData() + ", ");
            this.print(node.getRight());
        }

    }
}
