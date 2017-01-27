package CTCI.p2;

import java.util.Random;

/**
 * Created by Taewoo Kim on 1/15/2017.
 */
class p2_4_partition {
    static Node partition(Node node, int p){
        if (node == null) return null;

        Node curr = node.next;
        Node head = node;
        Node tail = node;

        while (curr != null){
            Node next = curr.next;
            if (curr.val < p){
                curr.next = head;
                head = curr;
            }
            else{
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }
        tail.next = null;
        return head;
    }

    static void print(Node head){
        Node n = head;
        while (n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n = head;
        Random rand = new Random();
        for (int i = 2; i <= 9; i++){
            n.next = new Node(rand.nextInt(10));
            n = n.next;
        }

        print(head);
        head = partition(head, 5);//delete node with val 4
        print(head);
    }
}
