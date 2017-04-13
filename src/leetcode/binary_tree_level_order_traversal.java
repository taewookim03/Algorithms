package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/11/2017.
 */
public class binary_tree_level_order_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> list = new ArrayList<>();
            if (root != null) list.add(root);

            while (!list.isEmpty()){
                List<TreeNode> temp = new ArrayList<>();
                List<Integer> vals = new ArrayList<>();
                for (TreeNode node : list){
                    vals.add(node.val);
                    if (node.left != null) temp.add(node.left);
                    if (node.right != null) temp.add(node.right);
                }
                res.add(vals);
                list = temp;
            }

            return res;
        }
    }
}
