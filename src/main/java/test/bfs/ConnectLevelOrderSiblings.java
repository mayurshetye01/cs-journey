package test.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);

        connectLevelOrderSiblings(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                if(curr.next !=null)
                    System.out.print(curr.val + "->" + curr.next.val + "  ");
                else
                    System.out.print(curr.val + "->" + "null" + "  ");
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            System.out.println();
        }

    }

    private static void connectLevelOrderSiblings(final TreeNode root) {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode previous = null;
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();

                if(previous != null){
                    previous.next = curr;
                }

                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);

                previous = curr;
            }
        }

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
