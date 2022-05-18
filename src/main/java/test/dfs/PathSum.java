package test.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = null;
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        final List<TreeNode> resultPath = getPathWithSum(root, 23, new ArrayList<>());

        for (TreeNode node : resultPath) {
            System.out.print(node.val + "->");
        }

    }

    private static List<TreeNode> getPathWithSum(final TreeNode root, final int targetSum, List<TreeNode> path) {
        if(root == null)
            return new ArrayList<>();

        if(root.val == targetSum){
            path.add(root);
            return path;
        }

        if(root.left == null && root.right == null)
            return new ArrayList<>();

        final List<TreeNode> leftPath = getPathWithSum(root.left, targetSum - root.val, path);
        if(!leftPath.isEmpty()){
            leftPath.add(root);
            return leftPath;
        }

        final List<TreeNode> rightPath = getPathWithSum(root.right, targetSum - root.val, path);
        if(!rightPath.isEmpty()){
            rightPath.add(root);
            return rightPath;
        }
        return new ArrayList<>();
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
