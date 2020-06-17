package common;

import datastructures.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class TreeTest {
    public abstract Tree getTreeInstance();

    @Test
    void testInsert() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);

        assertEquals(10, tree.size());

        assertThrows(IllegalArgumentException.class, () -> tree.insert(null));
        assertEquals(10, tree.size());
    }

    @Test
    void testDelete() {
        /*Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);

        for (int i = 0; i < 10; i++)
            tree.delete(i);

        assertEquals(0, tree.size());*/
    }

    @Test
    void testSearch() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);

        for (int i = 0; i < 10; i++)
            assertNotNull(tree.search(i));

        assertNull(tree.search(11));
        assertNull(tree.search(-1));
        assertNull(tree.search(100));
        assertNull(tree.search(-5));
        assertThrows(IllegalArgumentException.class, () -> tree.search(null));

    }

    @Test
    void testPredecessor() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);

        assertNull(tree.predecessor(tree.search(0)));
        for (int i = 1; i < 10; i++)
            assertEquals(i - 1, tree.predecessor(tree.search(i)).getValue());

        assertThrows(IllegalArgumentException.class, () -> tree.predecessor(null));

    }

    @Test
    void testSuccessor() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);

        assertNull(tree.successor(tree.search(9)));
        for (int i = 0; i < 9; i++)
            assertEquals(i + 1, tree.successor(tree.search(i)).getValue());

        assertThrows(IllegalArgumentException.class, () -> tree.successor(null));
    }

    @Test
    void testMinimum() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);
        assertEquals(0, tree.minimum().getValue());

        tree.insert(20);
        assertEquals(0, tree.minimum().getValue());

        tree.insert(-20);
        assertEquals(-20, tree.minimum().getValue());

        Tree emptyTree = getTreeInstance();
        assertNull(emptyTree.minimum());
    }


    @Test
    void testMaximum() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);
        assertEquals(9, tree.maximum().getValue());

        tree.insert(-20);
        assertEquals(9, tree.maximum().getValue());

        tree.insert(20);
        assertEquals(20, tree.maximum().getValue());

        Tree emptyTree = getTreeInstance();
        assertNull(emptyTree.maximum());
    }

    @Test
    void testRoot() {
        final Tree tree = getTreeInstance();
        for (int i = 0; i < 10; i++)
            tree.insert(i);
        assertEquals(0, tree.getRoot().getValue());

        tree.insert(-20);
        assertEquals(0, tree.getRoot().getValue());

        tree.insert(20);
        assertEquals(0, tree.getRoot().getValue());

        Tree emptyTree = getTreeInstance();
        assertNull(emptyTree.getRoot());
    }

}
