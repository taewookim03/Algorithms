package CTCI.p4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class p4_9_BST_sequences {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }
    static void BST_seq(Node root){
        List<Node> moves_taken = new ArrayList<>();
        Set<Node> available_moves = new HashSet<>();
        moves_taken.add(root);
        seq(root, moves_taken, available_moves);
    }

    static void seq(Node root, List<Node> moves_taken, Set<Node> available_moves){
        if (root == null) return;

        //update available moves based on root just taken
        if (root.left != null){
            available_moves.add(root.left);
        }
        if (root.right != null){
            available_moves.add(root.right);
        }

        //base case - no more moves available
        if (available_moves.isEmpty()) {
            //print path
            for (Node node : moves_taken){
                System.out.print(node.val + " ");
            }
            System.out.println();
            return;
        }

        //iterate over possible moves, take move, recurse, backtrack
        for (Node node : available_moves){
            moves_taken.add(node);
            Set<Node> temp = new HashSet<>(available_moves);
            temp.remove(node);

            seq(node, moves_taken, temp);

            moves_taken.remove(moves_taken.size() - 1);//O(1) removal
        }
    }

    public static void main(String[] args){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(3);
        BST_seq(root);
    }
}
