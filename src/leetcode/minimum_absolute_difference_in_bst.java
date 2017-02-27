package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class minimum_absolute_difference_in_bst {
    class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inorder(root, vals);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < vals.size(); i++){
                int diff = vals.get(i) - vals.get(i-1);
                minDiff = Math.min(minDiff, diff);
            }
            return minDiff;
        }
        public void inorder(TreeNode node, List<Integer> list){
            if (node == null) return;

            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right, list);
        }

    }
}
