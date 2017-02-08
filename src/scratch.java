import java.util.*;

class scratch{
    private static class Node{
        String label;
        Node left, right;
        Node(String label){
            this.label = label;
        }
    }
    static void preOrder(Node root){
        if (root == null) return;
        System.out.print(root.label + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.label + " ");
        inOrder(root.right);
    }
    static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.label + " ");
    }
    static void levelOrder(Node root){
        if (root == null) return;
        //BFS-esque implementation with queue
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node n = queue.remove();
            System.out.print(n.label + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node root = new Node("A");
        root.left = new Node("B");
        root.left.right = new Node("D");
        root.left.right.left = new Node("G");
        root.right = new Node("C");
        root.right.left = new Node("E");
        root.right.left.left = new Node("H");
        root.right.left.right = new Node("I");
        root.right.right = new Node("F");

        System.out.println("preorder: ");
        preOrder(root);
        System.out.println("\ninorder: ");
        inOrder(root);
        System.out.println("\npostorder: ");
        postOrder(root);
        System.out.println("\nlevelorder:");
        levelOrder(root);
    }
}
