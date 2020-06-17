package ch12.s1;

import ch10.s4.impl.BinaryTreeNode;
import datastructures.Tree;

import java.util.List;

public interface TreeWalk<E, N extends BinaryTreeNode<E>> {
    List<N> walk(N root);
}
