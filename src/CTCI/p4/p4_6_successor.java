//package CTCI.p4;
//
///**
// * Created by Taewoo Kim on 1/18/2017.
// */
//class p4_6_successor {
//    private static class Node{
//        int val;
//        Node left, right;
//        Node(int val){
//            this.val = val;
//        }
//    }
//
//    //find successor of a node
//    static Node successor(Node root){
//        if (root == null) return null;
//        if (root.right != null){
//            Node n = root.right;
//            while (n.left != null) n = n.left;
//            return n;
//        }
//
//    }
//
//    public static void main(String[] args){
//        Node root = new Node(3);
//        root.left = new Node(1);
//        root.left.left = new Node(0);
//        root.left.right = new Node(2);
//        root.right = new Node(5);
//        root.right.left = new Node(4);
//        root.right.right = new Node(6);
//        System.out.println(successor(root.right).val);
//    }
//}
