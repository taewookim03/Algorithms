package leetcode;

/**
 * Created by Taewoo Kim on 7/9/2017.
 */
public class merge_two_binary_trees {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) return t2;
            if (t2 == null) return t1;
            TreeNode newNode = new TreeNode(t1.val + t2.val);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
            return newNode;
        }
    }
}
