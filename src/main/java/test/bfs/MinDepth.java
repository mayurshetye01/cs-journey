package test.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);

        int minDepth = getMinimumDepthOfBinaryTree(root);
        System.out.println(minDepth);
    }

    private static int getMinimumDepthOfBinaryTree(final TreeNode root) {
        if(root == null)
            return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null)
                    return level;
                if(curr.left !=null)
                    queue.add(curr.left);
                if(curr.right !=null)
                    queue.add(curr.right);
            }
        }
        return level;
    }

    private static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
