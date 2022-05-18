package test.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);

        List<List<TreeNode>> result = levelOrderTraversal(root);
        for(List<TreeNode> subList: result){
            for (TreeNode node : subList) {
                System.out.print(node.val + ",");
            }
            System.out.println();
        }
    }

    private static List<List<TreeNode>> levelOrderTraversal(final TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<TreeNode>> result = new ArrayList<>();
        while (!queue.isEmpty()){
          List<TreeNode> subList = new ArrayList<>();
          int levelSize = queue.size();
          for(int i = 0; i < levelSize;i++){
              TreeNode curr = queue.poll();
              subList.add(curr);
              if(curr.left != null)
                  queue.add(curr.left);
              if(curr.right != null)
                  queue.add(curr.right);
          }
          result.add(subList);
        }
        return result;
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
