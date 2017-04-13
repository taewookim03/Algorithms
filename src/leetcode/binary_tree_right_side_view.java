package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class binary_tree_right_side_view {
    private class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            rsvUtil(root, 0, list);
            return list;
        }
        void rsvUtil(TreeNode root, int depth, List<Integer> list){
            if (root == null) return;
            if (depth == list.size()){
                list.add(root.val);
            }

            rsvUtil(root.right, depth+1, list);
            rsvUtil(root.left, depth+1, list);
        }
    }
}
