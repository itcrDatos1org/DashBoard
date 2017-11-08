//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package datastructures.Arboles;

public class AVLNode<T extends Comparable<T>> {
    public T data;
    public int balanceFactor;
    public AVLNode<T> left;
    public AVLNode<T> right;

    public AVLNode() {
    }

    public AVLNode(T data) {
        this.data = data;
        this.balanceFactor = 0;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getBalanceFactor() {
        return this.balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public AVLNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return this.right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
}
