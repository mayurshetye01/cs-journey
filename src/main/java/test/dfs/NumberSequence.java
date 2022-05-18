package test.dfs;

public class NumberSequence {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = null;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(16);
        root.right.right.left.left = new TreeNode(3);


        int[] sequence = {1,1,5,16,3};
        System.out.println(isSequencePresent(root,sequence));
    }

    private static boolean isSequencePresent(final TreeNode root, final int[] sequence) {
        if(root == null || root.val != sequence[0])
            return false;

        TreeNode curr = root;
        int level = 1;

        while( curr != null && level < sequence.length ) {
            if(curr.left != null && curr.left.val == sequence[level] )
                curr = curr.left;
            else if(curr.right != null && curr.right.val == sequence[level] )
                curr = curr.right;
            else
                return false;
            level++;
        }
        return true;
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

