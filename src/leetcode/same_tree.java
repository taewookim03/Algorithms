package leetcode;

/**
 * Created by Taewoo Kim on 2/1/2017.
 */
public class same_tree {
    private class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null) return q == null;
            if (q == null) return false;

            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
