package ch12.s1;

import ch10.s4.impl.BinaryTreeNode;
import ch12.s2.BinarySearchTree;
import datastructures.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InOrderTreeWalkTest {

    @Test
    void testInOrderTreeWalk() {
        Tree<Integer, BinaryTreeNode<Integer>> tree = new BinarySearchTree<>(Integer::compareTo);
        List<Integer> entries = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int value = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            entries.add(value);
            tree.insert(value);
        }
        TreeWalk<Integer, BinaryTreeNode<Integer>> treeWalker = new InOrderTreeWalk<>();
        List<BinaryTreeNode<Integer>> result = treeWalker.walk(tree.getRoot());
        List<Integer> resultValues = new ArrayList<>();
        result.forEach(node -> resultValues.add(node.getValue()));

        assertEquals(entries.size(), result.size());
        entries.sort(Comparator.naturalOrder());
        assertArrayEquals(entries.toArray(), resultValues.toArray());

    }
}
