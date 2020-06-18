package ch12;

import ch10.s4.impl.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversal {

    public static void traverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.println(node);
            if (node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if (node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        //print(nodes);
    }

    /*private static void print(List<BinaryTreeNode> nodes) {
        int level = 0;
        int spaces = 50;
        for (int i = 0; i < nodes.size(); i++) {

            for (int j = 0; j < spaces - 2 * level; j++)
                System.out.println(" ");
            for (int k = 0; k < Math.pow(2, level); k++) {
                System.out.println(nodes.get(i) == null ? "x" : nodes.get(i).getValue());
                System.out.println("  ");
            }
            System.out.println();
        }
    }*/
}
