package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class sum_of_left_leaves {
    //read questions carefully (leaves vs nodes)
    private class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int sum = 0;
            if (root.left != null && root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }

            return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
