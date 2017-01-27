package CTCI.p2;

import java.util.HashSet;
import java.util.Set;

class Node{
    int val;
    Node next = null;
    Node(int val){
        this.val = val;
    }
}

class p2_1_remove_dups {
    static void removeDups(Node head){
        //no need to return node because head can't be a non-first duplicate (1 element)

        //store values in a set and if a node's value is already in the set, delete the node
        Set<Integer> numSet = new HashSet<>();
        Node node = head;
        Node prev = null;

        while (node != null){
            if (numSet.contains(node.val)){
                prev.next = node.next;
            }
            else{
                numSet.add(node.val);
                prev = node;
            }
            node = node.next;
        }
    }

    static void print(Node head){
        Node node = head;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node h = new Node(2);
        h.next = new Node(3);
        h.next.next = new Node(1);
        h.next.next.next = new Node(2);
        h.next.next.next.next = new Node(3);

        print(h);
        removeDups(h);
        print(h);
    }
}
