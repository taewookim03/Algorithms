package leetcode;

/*
You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   /
  3   1 5
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".



 "342(3(2))"

 "-32"

 "2(3)(1)"

 */
public class construct_binary_tree_from_string {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode str2tree(String s){
        int firstLeft = s.indexOf('(');
        if (firstLeft == -1){
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, firstLeft)));

        int paren = 0;
        int start = firstLeft;
        for (int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') paren++;
            else if (c == ')') paren--;

            if (paren == 0 && start == firstLeft){
                root.left = str2tree(s.substring(start+1, i));
                start = i+1;
            }
            else if (paren == 0){
                root.right = str2tree(s.substring(start+1, i));
            }
        }

        return root;
    }

    public static void inorder(TreeNode node){
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public static void main(String[] args){
        inorder(str2tree("4(2(3)(1))(6(5))"));
    }
}
