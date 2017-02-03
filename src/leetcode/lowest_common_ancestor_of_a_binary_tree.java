package leetcode;

/**
 * Created by Taewoo Kim on 2/2/2017.
 */
public class lowest_common_ancestor_of_a_binary_tree {
    public class TreeNode{
        int val;
        TreeNode left, right;
    }

    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //if root gets back p or q, it means they are the least common ancestor
            if (root == null || root.equals(p) || root.equals(q)) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) return right;
            if (right == null) return left;
            return root;//this is the lca if p and q have a common root that is not either of them
        }
    }
}
