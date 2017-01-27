package CTCI.p4;

class p4_10_check_subtree {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    static boolean isSubtree(Node root, Node subroot){
        if (subroot == null) return true;
        if (root == null) return false;
        return equals(root, subroot) || isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
    static boolean equals(Node a, Node b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right));
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(9);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        Node sub = new Node(4);
        sub.left = new Node(9);
        System.out.println(isSubtree(root, sub));
    }
}
