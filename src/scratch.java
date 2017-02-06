import java.util.*;

class scratch{
    static private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    static void print(Node root){
        Node n = root;
        while (n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    static Node reverse(Node node){
        if (node == null || node.next == null) return node;

        Node tail = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return tail;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);

        print(root);
        root = reverse(root);
        print(root);

    }
}
