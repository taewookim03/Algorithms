package CTCI.p4;


import java.util.ArrayList;
import java.util.List;

class p4_3_list_of_depths {
    private static class Node{
        int val;
        Node left, right;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    static List<Node> depths(Node root){
        List<Node> lists = new ArrayList<>();
        preorder(root, 0, lists);
        return lists;
    }
    static void preorder(Node node, int depth, List<Node> lists){
        if (node == null) return;

        //add to lists
        if (depth >= lists.size()) lists.add(node);
        else{
            node.next = lists.get(depth);
            lists.set(depth, node);//replace head with this
        }
        preorder(node.left, depth+1, lists);
        preorder(node.right, depth+1, lists);
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

        List<Node> lists = depths(root);
        for (int i = 0; i < lists.size(); i++){
            Node node = lists.get(i);
            while (node != null){
                System.out.print(node.val);
                node = node.next;
            }
            System.out.println();
        }
    }
}
