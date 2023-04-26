/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package probabilisticalgorithms;

/**
 *
 * @author darios
 */
public class SkipNode <T extends Comparable <T>> {
    private T elem;
    private SkipNode<T> up, right, left, down;
    
    public SkipNode() {
        this.elem=null;
        this.up=null;
        this.right=null;
        this.down=null;
        this.left=null;
    }

    public T getElem() {
        return elem;
    }

    public SkipNode<T> getUp() {
        return up;
    }

    public SkipNode<T> getRight() {
        return right;
    }

    public SkipNode<T> getLeft() {
        return left;
    }

    public SkipNode<T> getDown() {
        return down;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public void setUp(SkipNode<T> up) {
        this.up = up;
    }

    public void setRight(SkipNode<T> right) {
        this.right = right;
    }

    public void setLeft(SkipNode<T> left) {
        this.left = left;
    }

    public void setDown(SkipNode<T> down) {
        this.down = down;
    }
    
    public void linkH(SkipNode<T> node) {
        if (node == null)
            return;
        node.setLeft(this);
        node.setRight(this.getRight());
        this.setRight(node);
        node.getRight().setLeft(node);
        
    }
    
    public void linkV(SkipNode<T> node) {
        if (node == null)
            return;
        this.setUp(node);
        node.setDown(this);
    }
    
}
