package test.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = null;
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        final List<List<TreeNode>> resultPath = new ArrayList<>();
        getPathsWithSum(root, 23, new ArrayList<>(), resultPath);

        for(List<TreeNode> path: resultPath) {
            for (TreeNode node : path) {
                System.out.print(node.val + "->");
            }
            System.out.println("-------");
        }

    }

    private static void getPathsWithSum(final TreeNode root, final int targetSum, List<TreeNode> path, List<List<TreeNode>> resultPaths) {
        if(root == null)
            return;

        if(root.val == targetSum){
            path.add(root);
            resultPaths.add(path);
            return;
        }

        if(root.left == null && root.right == null)
            return;

        List<List<TreeNode>> leftResultPaths = new ArrayList<>();
        getPathsWithSum(root.left, targetSum - root.val, path, leftResultPaths);

        List<List<TreeNode>> rightResultPaths = new ArrayList<>();
        getPathsWithSum(root.right, targetSum - root.val, path, rightResultPaths);

        if(!leftResultPaths.isEmpty()){
            leftResultPaths.forEach(p -> p.add(0, root));
            resultPaths.addAll(leftResultPaths);
        }
        if(!rightResultPaths.isEmpty()){
            rightResultPaths.forEach(p -> p.add(0, root));
            resultPaths.addAll(rightResultPaths);
        }
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
