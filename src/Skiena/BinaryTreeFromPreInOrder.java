package Skiena;

import java.util.Arrays;
import java.util.List;

/**
 * 5-7. Given pre-order and in-order traversals of a binary tree, is it possible to reconstruct the tree?
 * If so, sketch an algorithm to do it. If not, give a counterexample.
 * Repeat the problem if you are given the pre-order and post-order traversals.
 */
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

class BinaryTree{
    TreeNode root = null;

    void preoreder(){
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(TreeNode node){
        if (node == null) return;

        System.out.print(node.val);
        preorderRec(node.left);
        preorderRec(node.right);
    }

    void inorder(){
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(TreeNode node){
        if (node == null) return;

        inorderRec(node.left);
        System.out.print(node.val);
        inorderRec(node.right);
    }

    //builds a binary tree from pre- and in-order traversals of the elements (assuming nodes with int values)
    void buildTree(List<Integer> pre, List<Integer> in){
        root = buildTreeRec(pre, in);
    }


    TreeNode buildTreeRec(List<Integer> pre, List<Integer> in){
        //base case: traversal has 0 or 1 element (assumed that pre.length == in.length)
        if (pre.size() == 0) return null;
        if (pre.size() == 1) return new TreeNode(pre.get(0));

        TreeNode newNode = new TreeNode(pre.get(0));
        //partition inorder by new node
        int partition_i = in.indexOf(pre.get(0));
        int leftSize = partition_i;

        newNode.left = buildTreeRec(pre.subList(1, 1 + leftSize), in.subList(0, leftSize));
        newNode.right = buildTreeRec(pre.subList(1 + leftSize, pre.size()), in.subList(1 + leftSize, in.size()));

        return newNode;
    }
}

class BinaryTreeFromPreInOrder {
    public static void main(String[] args){
//        String pre = "1234567";
//        String in = "2316547";

        List<Integer> pre = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> in = Arrays.asList(2, 3, 1, 6, 5, 4, 7);

        BinaryTree bt = new BinaryTree();
        bt.buildTree(pre, in);
        bt.preoreder();
        bt.inorder();
    }
}

// pre+post order can't be used to construct a tree - counter example: 1 2 3 / 3 2 1 straight lines ambiguous