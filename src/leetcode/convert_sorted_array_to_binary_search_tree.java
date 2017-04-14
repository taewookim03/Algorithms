package leetcode;

/**
 * Created by Taewoo Kim on 4/14/2017.
 */
public class convert_sorted_array_to_binary_search_tree {
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return util(nums, 0, nums.length-1);
        }
        TreeNode util(int[] nums, int i, int j){
            if (i > j) return null;
            int mid = (i + j) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = util(nums, i, mid-1);
            root.right = util(nums, mid+1, j);
            return root;
        }
    }
}
