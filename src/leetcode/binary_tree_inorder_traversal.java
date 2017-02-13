package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class binary_tree_inorder_traversal {
    private static class TreeNode{
        int val;
        TreeNode left, right;
    }
    //more challenging iterative solution
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            TreeNode node = root;
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            while (node != null || !stack.isEmpty()){
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
            return result;
        }
    }

    //trivial recursive solution
    public class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderUtil(root, result);
            return result;
        }
        void inorderUtil(TreeNode root, List<Integer> result){
            if (root == null) return;
            inorderUtil(root.left, result);
            result.add(root.val);
            inorderUtil(root.right, result);
        }
    }
}
