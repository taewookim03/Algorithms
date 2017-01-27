package CTCI.p4;

class p4_5_validate_BST {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    static boolean isBST(Node root){
        //check if a bin tree is a BST
        if (root == null) return true;
        return isBSTrec(root, null) != null;
    }
    static Node isBSTrec(Node root, Node prev){
        if (root == null) return prev;

        prev = isBSTrec(root.left, prev);
        if (prev != null && root.val < prev.val) return null;
        prev = isBSTrec(root.right, root);

        return prev;
    }

    //version using min max
    static boolean isBST2(Node root){
        return isBSTminmax(root, null, null);
    }
    static boolean isBSTminmax(Node root, Integer min, Integer max){
        if (root == null) return true;
        //check if bst property is violated
        if (min != null && root.val <= min || max != null && root.val > max) return false;

        return (isBSTminmax(root.left, min, root.val) && isBSTminmax(root.right, root.val, max));
    }

    public static void main(String[] args){
        Node nonBST = new Node(1);
        nonBST.left = new Node(2);
        nonBST.left.left = new Node(3);
        nonBST.left.right = new Node(4);
        //root.left.right.left = new Node(9);
        nonBST.right = new Node(5);
        nonBST.right.left = new Node(6);
        nonBST.right.right = new Node(7);
        nonBST.right.right.right = new Node(8);
        nonBST.right.right.right.left = new Node(10);
        System.out.println(isBST(nonBST));

        Node bst = new Node(3);
        bst.left = new Node(1);
        bst.left.left = new Node(0);
        bst.left.right = new Node(2);
        bst.right = new Node(5);
        bst.right.left = new Node(4);
        bst.right.right = new Node(6);
        System.out.println(isBST(bst));
    }
}
