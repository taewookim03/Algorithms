package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class validate_binary_search_tree {
    private class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public boolean isValidBST(TreeNode root) {
            return validBSTUtil(root, null, null);
        }

        boolean validBSTUtil(TreeNode root, Integer min, Integer max){
            if (root == null) return true;
            if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
            return validBSTUtil(root.left, min, root.val) && validBSTUtil(root.right, root.val, max);
        }
    }
}
