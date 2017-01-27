package CTCI.p2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class p2_6_palindrome {
    private static class Node{
        char c;
        Node next;
        Node(char c){
            this.c = c;
        }
    }

    //store left half values in a stack, compare with right half
    static boolean palindrome(Node head){
//        int count = 0;
//        Node n = head;
//        while (n != null){
//            count++;
//            n = n.next;
//        }
        //can do without counting using slow and fast

        Node slow = head;
        Node fast = head;
        Deque<Character> stack = new ArrayDeque<>();
        while (fast != null && fast.next != null){
            stack.addFirst(slow.c);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            //then odd
            slow = slow.next;
        }
        while (slow != null){
            char top = stack.removeFirst();
            if (top != slow.c) return false;
            slow = slow.next;
        }
//        for (int i = 0; i < count/2; i++){
//            stack.addFirst(n.c);
//            n = n.next;
//        }
//        if (count % 2 == 1) n = n.next;
//        while (n != null){
//            if (n.c != stack.removeFirst()){
//                return false;
//            }
//            n = n.next;
//        }
        return true;
    }

    public static void main(String[] args){
        Node head = new Node('a');
        head.next = new Node('b');
        Node middle = new Node('c');
        head.next.next = middle;
        middle.next = new Node('c');
        middle.next.next = new Node('b');
        middle.next.next.next = new Node('a');
        System.out.println(palindrome(head));
    }

}
