package datastructures;

import ch10.s4.TreeNode;

public interface Tree<E, N extends TreeNode<E>> {

    void insert(E value);

    void delete(E value);

    N search(E value);

    N predecessor(N node);

    N successor(N node);

    N minimum();

    N minimum(N root);

    N maximum();

    N maximum(N root);

    N getRoot();

    int size();

}
