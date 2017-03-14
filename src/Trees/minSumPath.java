package Trees;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class minSumPath {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    static int minSum(Node root){
        if (root == null) return 0;

        int leftSum = minSum(root.left);
        int rightSum = minSum(root.right);

        return root.val + Math.min(leftSum, rightSum);
    }

    public static void main(String[] args){
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.right.left = new Node(22);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.left.right.left = new Node(2);
        root.left.right.right = new Node(16);
        root.left.right.left.left = new Node(0);
        root.left.right.left.right = new Node(5);
        root.left.right.right.left = new Node(3);

        System.out.println(minSum(root));
        //ans: 31 (15 + 10 + 6)
    }
}
