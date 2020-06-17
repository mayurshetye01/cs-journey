package ch12.s2;

import ch10.s4.TreeNode;
import ch10.s4.impl.BinaryTreeNode;
import common.TreeTest;
import datastructures.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTest extends TreeTest {
    @Override
    public Tree getTreeInstance() {
        return new BinarySearchTree<>(Integer::compareTo);
    }

    @Test
    public void testBalancedBinaryTree() {
        final Tree<Integer, BinaryTreeNode<Integer>> tree = new BinarySearchTree<>(Integer::compareTo);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);

        assertEquals(5, tree.getRoot().getValue());
        assertEquals(4, tree.search(5).getLeftChild().getValue());
        assertEquals(6, tree.search(5).getRightChild().getValue());

        assertEquals(3, tree.search(4).getLeftChild().getValue());
        assertNull(tree.search(4).getRightChild());

        assertEquals(6, tree.predecessor(tree.search(7)).getValue());
        assertEquals(2, tree.successor(tree.search(1)).getValue());

        assertEquals(1, tree.minimum().getValue());
        assertEquals(9, tree.maximum().getValue());
    }
}
