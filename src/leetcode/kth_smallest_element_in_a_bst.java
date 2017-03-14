package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class kth_smallest_element_in_a_bst {
    //if multiple queries, augmenting nodes with number of left children should give O(logn) performance
    private class TreeNode{
        int val;
        TreeNode left, right;
    }

    public class Solution {
        int count = 0;
        int kthVal;

        public int kthSmallest(TreeNode root, int k) {
            inorder(root, k);
            return kthVal;
        }
        void inorder(TreeNode root, int k){
            if (count == k) return;
            if (root == null) return;

            inorder(root.left, k);
            if (++count == k) kthVal = root.val;
            inorder(root.right, k);
        }
    }

    //iterative without static variables
    public class Solution2 {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();

            TreeNode curr = root;
            while (k > 0 && (!stack.isEmpty() || curr != null)){
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (--k == 0) return curr.val;
                curr = curr.right;
            }

            return -1;
        }
    }
}
