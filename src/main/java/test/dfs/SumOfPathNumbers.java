package test.dfs;

public class SumOfPathNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = null;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println(getPathSum(root, 0));

    }

    private static int getPathSum(final TreeNode root, int sum) {
        if(root == null)
            return 0;

        sum = 10 * sum + root.val;

        if(root.left == null && root.right == null)
            return sum;

        return getPathSum(root.left, sum) + getPathSum(root.right, sum);
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
