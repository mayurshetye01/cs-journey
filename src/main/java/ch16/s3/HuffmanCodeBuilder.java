package ch16.s3;

import ch10.s4.impl.BinaryTreeNode;
import ch12.s1.InOrderTreeWalk;
import ch12.s1.TreeWalk;

import java.util.*;

public class HuffmanCodeBuilder {
    public List<CharacterCode> build(char[] characters) {
        final List<ComparableBinaryTreeNode<CharacterComponent>> nodes = buildNodes(characters);
        //Default java min-heap implementation
        PriorityQueue<ComparableBinaryTreeNode> queue = new PriorityQueue<>();
        queue.addAll(nodes);

        while (queue.size() > 1) {
            ComparableBinaryTreeNode<CharacterComponent> mergedNode = new ComparableBinaryTreeNode<>();
            ComparableBinaryTreeNode<CharacterComponent> leftChild = queue.poll();
            ComparableBinaryTreeNode<CharacterComponent> rightChild = queue.poll();
            mergedNode.setLeftChild(leftChild);
            mergedNode.setRightChild(rightChild);
            mergedNode.setValue(new CharacterComponent(null, leftChild.getValue().getFrequency() + rightChild.getValue().getFrequency()));
            queue.add(mergedNode);
        }
        return buildCharacterCodes(queue.poll());
    }

    private List<CharacterCode> buildCharacterCodes(ComparableBinaryTreeNode<CharacterComponent> root) {
        List<CharacterCode> characterCodes = new ArrayList<>();
        if (root == null)
            return characterCodes;

        TreeWalk<CharacterComponent, ComparableBinaryTreeNode<CharacterComponent>> walker = new InOrderTreeWalk();
        List<ComparableBinaryTreeNode<CharacterComponent>> nodes = walker.walk(root);
        List<ComparableBinaryTreeNode<CharacterComponent>> leaves = new ArrayList<>();
        nodes.forEach(node -> {
            if (node.isLeaf())
                leaves.add(node);
        });
        for (ComparableBinaryTreeNode<CharacterComponent> leaf : leaves) {
            final List<Integer> code = new ArrayList<>();
            final Character character = leaf.getValue().getCharacter();
            while (!leaf.isRoot()) {
                if (leaf == leaf.getParent().getLeftChild()) {
                    code.add(0, 0);
                } else {
                    code.add(0, 1);
                }
                leaf = (ComparableBinaryTreeNode<CharacterComponent>) leaf.getParent();
            }
            characterCodes.add(new CharacterCode(character, code.toArray(new Integer[code.size()])));
        }
        return characterCodes;
    }

    private List<ComparableBinaryTreeNode<CharacterComponent>> buildNodes(char[] characters) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character character : characters)
            frequencyMap.merge(character, 1, Integer::sum);
        List<ComparableBinaryTreeNode<CharacterComponent>> nodes = new ArrayList<>();
        frequencyMap.forEach((key, value) -> {
            ComparableBinaryTreeNode<CharacterComponent> node = new ComparableBinaryTreeNode<>();
            node.setValue(new CharacterComponent(key, value));
            nodes.add(node);
        });
        return nodes;
    }

    private static class ComparableBinaryTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E> implements Comparable<ComparableBinaryTreeNode<E>> {

        @Override
        public int compareTo(ComparableBinaryTreeNode<E> that) {
            return getValue().compareTo(that.getValue());
        }

    }
}
