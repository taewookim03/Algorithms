package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class binary_tree_preorder_traversal {
    private class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            if (root != null) stack.push(root);
            List<Integer> res = new ArrayList<>();

            while (!stack.isEmpty()){
                TreeNode curr = stack.pop();
                //process
                res.add(curr.val);
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
            return res;
        }
    }
}
