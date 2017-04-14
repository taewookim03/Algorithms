package leetcode;
import java.util.*;
import java.util.stream.Collectors;
/**
 Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class most_frequent_sum {
    public class TreeNode{
        int val;
        TreeNode left, right;
    }
    public class Solution {
        public int[] findFrequentTreeSum(TreeNode root) {
            if (root == null) return new int[0];
            Map<Integer,Integer> freqMap = new HashMap<>();
            treeSum(root, freqMap);
            int maxFreq = Collections.max(freqMap.values());
            List<Integer> list = freqMap.entrySet().stream().filter(e->e.getValue().equals(maxFreq)).map(e->e.getKey()).collect(Collectors.toList());

            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++){
                arr[i] = list.get(i);
            }
            return arr;
        }

        int treeSum(TreeNode node, Map<Integer, Integer> freqMap){
            if (node == null) return 0;

            int left = treeSum(node.left, freqMap);
            int right = treeSum(node.right, freqMap);
            int sum = node.val + left + right;
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
            return sum;
        }
    }
}