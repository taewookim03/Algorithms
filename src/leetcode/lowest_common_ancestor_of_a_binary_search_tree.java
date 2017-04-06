package leetcode;

/**
 * Created by Taewoo Kim on 4/3/2017.
 */
public class lowest_common_ancestor_of_a_binary_search_tree {
    public class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p == null || q == null) return null;
            if (root == null || root == p || root == q) return root;
            if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
            if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
            return root;//diverges here
        }
    }
}
