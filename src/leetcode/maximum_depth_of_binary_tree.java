package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class maximum_depth_of_binary_tree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }
}
