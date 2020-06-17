package ch12.s2;

import annotations.Quality;
import annotations.Stage;
import ch10.s4.impl.BinaryTreeNode;
import datastructures.Tree;

import java.util.Comparator;

@Quality(Stage.REFACTORING_REQUIRED)
public class BinarySearchTree<E, N extends BinaryTreeNode<E>> implements Tree<E, N> {
    private final Comparator<E> comparator;
    private N root;
    private int size;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
        this.size = 0;
    }

    @Override
    public void insert(E value) {
        if (value == null)
            throw new IllegalArgumentException("null");
        N parent = null;
        N curr = root;

        N node = (N) new BinaryTreeNode<E>();
        node.setValue(value);

        while (curr != null) {
            parent = curr;
            if (less(value, curr.getValue()))
                curr = (N) curr.getLeftChild();
            else
                curr = (N) curr.getRightChild();
        }
        node.setParent(parent);
        if (parent == null)
            root = node;
        else if (less(value, parent.getValue()))
            parent.setLeftChild(node);
        else
            parent.setRightChild(node);
        size++;

    }

    @Override
    public void delete(E value) {
        throw new UnsupportedOperationException("Incomplete implementation of method");
        /*N node = search(value);

size--;

        if (node == null)
            return;

        //Case 1
        if (node.getRightChild() == null && node.getLeftChild() == null) {
            N parent = (N) node.getParent();
            if (parent == null)
                this.root = null;
            else if (less(value, parent.getValue()))
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);

            node.setParent(null);

        }*/

        //Case 2

    }

    @Override
    public N search(E value) {
        if (value == null)
            throw new IllegalArgumentException("null");
        N curr = root;
        if (root == null)
            return null;
        while (curr != null) {
            int result = compare(value, curr.getValue());
            if (result == 0)
                break;
            if (result < 0)
                curr = (N) curr.getLeftChild();
            else
                curr = (N) curr.getRightChild();
        }
        return curr;
    }

    @Override
    public N predecessor(N node) {
        if (node == null)
            throw new IllegalArgumentException("null");

        //If left subtree is non empty, return the min in left subtree
        if (node.getLeftChild() != null)
            return minimum((N) node.getLeftChild());

        //Else it is the first ancestor just to the left on top
        N parent = (N) node.getParent();
        N curr = node;

        while (parent != null && parent.getLeftChild() != null && compare(parent.getLeftChild().getValue(), curr.getValue()) == 0) {
            curr = parent;
            parent = (N) parent.getParent();
        }
        return parent;
    }

    @Override
    public N successor(N node) {
        if (node == null)
            throw new IllegalArgumentException("null");
        //If right subtree is non empty, return the min in right subtree
        if (node.getRightChild() != null)
            return minimum((N) node.getRightChild());

        //Else it is the first ancestor just to the right on top
        N parent = (N) node.getParent();
        N curr = node;

        while (parent != null && parent.getRightChild() != null && compare(parent.getRightChild().getValue(), curr.getValue()) == 0) {
            curr = parent;
            parent = (N) parent.getParent();
        }
        return parent;
    }

    @Override
    public N minimum() {
        return minimum(this.root);
    }

    @Override
    public N minimum(N root) {
        if (root == null)
            return null;
        N curr = root;
        while (curr.getLeftChild() != null) {
            curr = (N) curr.getLeftChild();
        }
        return curr;
    }

    @Override
    public N maximum() {
        return maximum(this.root);
    }

    @Override
    public N maximum(N root) {
        if (root == null)
            return null;
        N curr = root;
        while (curr.getRightChild() != null) {
            curr = (N) curr.getRightChild();
        }
        return curr;
    }

    @Override
    public N getRoot() {
        return this.root;
    }

    @Override
    public int size() {
        return this.size;
    }

    private boolean less(E first, E second) {
        return compare(first, second) < 0;
    }

    private int compare(E first, E second) {
        return comparator.compare(first, second);
    }
}
