package ch12.s1;

import annotations.Quality;
import annotations.Stage;
import ch10.s4.impl.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

@Quality(Stage.INCOMPLETE)
public class PreOrderTreeWalk<E, N extends BinaryTreeNode<E>> implements TreeWalk<E, N> {

    @Override
    public List<N> walk(N root) {
        List<N> result = new ArrayList<>();

        if (root != null) {
            result.add(root);
            result.addAll(walk((N) root.getLeftChild()));
            result.addAll(walk((N) root.getRightChild()));
        }
        return result;
    }
}
