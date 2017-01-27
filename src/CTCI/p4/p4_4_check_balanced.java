package CTCI.p4;

class p4_4_check_balanced {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    private static class Result{
        boolean balanced;
        int depth;
        Result(boolean balanced, int depth){
            this.balanced = balanced;
            this.depth = depth;
        }
    }
    static boolean balanced(Node root){
        Result res = balancedRec(root);
        return res.balanced;
    }
    static Result balancedRec(Node root){
        if (root == null) return new Result(true, 0);

        Result left = balancedRec(root.left);
        Result right = balancedRec(root.right);

        boolean bal = left.balanced && right.balanced && Math.abs(left.depth - right.depth) <= 1;

        return new Result(bal, Math.max(left.depth, right.depth) + 1);
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        //root.left.right.left = new Node(9);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.left = new Node(10);

        System.out.println(balanced(root));
    }
}
