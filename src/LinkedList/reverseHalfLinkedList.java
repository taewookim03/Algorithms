package LinkedList;

/**
 * Created by Taewoo Kim on 3/25/2017.
 */
public class reverseHalfLinkedList {
    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            next = null;
        }
    }
    public static Node reverseHalf(Node node){
        if (node == null || node.next == null) return node;
        Node slow = node;
        Node fast = node.next;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);
        return node;
    }
    public static Node reverse(Node node){
        if (node == null) return node;

        Node prev = null;
        Node cur = node;
        Node next = cur.next;

        while (cur != null){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void print(Node node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        print(head);
        head = reverseHalf(head);
        print(head);
    }
}
