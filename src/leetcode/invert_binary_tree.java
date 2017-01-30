package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class invert_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private static class TreeNode{
        TreeNode left, right;
    }
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }
}
