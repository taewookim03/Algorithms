package CTCI.p2;

class p2_8_loop_detection {
    private static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    static Node detectLoop(Node head){
        if (head == null) return null;
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) return null;//no loop

        //there is a loop. count the loop length
        fast = fast.next;
        int count = 1;
        while (slow != fast){
            fast = fast.next;
            count++;
        }

        //offset by loop length and start from beginning
        slow = head;
        fast = head;
        for (int i = 0; i < count; i++){
            fast = fast.next;
        }

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        Node middle = new Node(3);
        head1.next.next = middle;
        middle.next = new Node(4);
        middle.next.next = new Node(5);
        middle.next.next.next = middle;//1->2->3 loop 3->4->5->3

        Node loop = detectLoop(head1);
        if (loop != null) System.out.println(loop.val);
    }
}
