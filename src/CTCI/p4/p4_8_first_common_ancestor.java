package CTCI.p4;

class p4_8_first_common_ancestor {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    //find first common ancestor in a binary tree (not BST)
    //solution differs depending on if parent pointer available
    //if parent available, start from one node and traverse upward, checking if its sibling "covers" the other
    //if not available, check until the two nodes are not on the same side of the tree as you go down the root to the
    //side that contains these nodes
    static Node commonAncestor(Node root, Node a, Node b){
        if (!covers(root, a) || !covers(root, b)) return null;
        if (covers(a, b)) return a;
        if (covers(b, a)) return b;

        boolean aLeft = covers(root.left, a);
        boolean bLeft = covers(root.left, b);
        if (aLeft != bLeft) return root;//on different sides
        Node containsAB = aLeft ? root.left : root.right;
        return commonAncestor(containsAB, a, b);
    }

    static boolean covers(Node root, Node node){
        if (root == null) return false;
        if (root == node) return true;
        return (covers(root.left, node) || covers(root.right, node));
    }

    //optimized version - need to check if both vertices exist in the tree
    static Node commonAncestorWrapper(Node root, Node a, Node b){
        if (!covers(root, a) || !covers(root, b)) return null;
        return commonAncestorOpt(root, a, b);
    }
    static Node commonAncestorOpt(Node root, Node a, Node b){
        if (root == null) return null;
        if (root == a || root == b) return root;

        Node left = commonAncestorOpt(root.left, a, b);
        Node right = commonAncestorOpt(root.right, a, b);
        if (left != null){
            if (right != null) return root;//found first common ancestor
            else return left;//pass either common ancestor or a or b
        }
        else return right;
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
        System.out.println(commonAncestorWrapper(root, root.left.left, root.left.right.left).val);
    }
}
