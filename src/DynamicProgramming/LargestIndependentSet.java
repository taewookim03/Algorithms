package DynamicProgramming;

/**
 * Created by Taewoo Kim on 3/25/2017.
 * http://www.geeksforgeeks.org/largest-independent-set-problem/
 */
public class LargestIndependentSet {
    private static class Node{
        int val;
        Integer lisv;//largest independent subset value
        Node left, right;
        Node(int val){
            this.val = val;
            lisv = null;
        }
    }

    private static int LIS(Node node){
        if (node == null) return 0;
        if (node.lisv != null) return node.lisv;

        int excl = LIS(node.left) + LIS(node.right);
        int incl = node.val;
        if (node.left != null) incl += LIS(node.left.left) + LIS(node.left.right);
        if (node.right != null) incl += LIS(node.right.left) + LIS(node.right.right);

        node.lisv =  Math.max(incl, excl);
        return node.lisv;
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(80);
        root.right = new Node(30);
        root.right.right = new Node(60);

        System.out.println(LIS(root));
    }
}
