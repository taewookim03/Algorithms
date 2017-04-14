package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class convert_bst_to_greater_tree {
    class TreeNode{
        int val;
        TreeNode left, right;
    }

    //without static variable
    public class Solution {
        public TreeNode convertBST(TreeNode root) {
            convertUtil(root, 0);
            return root;
        }
        int convertUtil(TreeNode root, int sum){
            if (root == null) return sum;
            int right = convertUtil(root.right, sum);
            right += root.val;
            root.val = right;
            int left = convertUtil(root.left, right);
            return left;
        }
    }

    public class Solution2 {
        int runningSum;
        public TreeNode convertBST(TreeNode root) {
            runningSum = 0;
            convertUtil(root);
            return root;
        }
        void convertUtil(TreeNode root){
            if (root == null) return;
            convertUtil(root.right);
            runningSum += root.val;
            root.val = runningSum;
            convertUtil(root.left);
        }
    }
}
