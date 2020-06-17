package ch12.s1;

import ch10.s4.impl.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTreeWalk<E, N extends BinaryTreeNode<E>> implements TreeWalk<E, N> {

    @Override
    public List<N> walk(N root) {
        List<N> sortedList = new ArrayList<>();

        if (root != null) {
            sortedList.addAll(walk((N) root.getLeftChild()));
            sortedList.add(root);
            sortedList.addAll(walk((N) root.getRightChild()));
        }
        return sortedList;
    }
}
