package Skiena;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
}

class LinkedList{
    ListNode head;
    void add(int i){
        ListNode node = new ListNode(i);
        node.next = head;
        head = node;
    }
    void print(){
        ListNode node = head;
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}


class Solution {
    static ListNode mergeKLists(ListNode[] lists){
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode l : lists){
            minHeap.add(l);
        }
        //save head of the resulting list
        ListNode head = minHeap.peek();
        while (!minHeap.isEmpty()){
            ListNode current = minHeap.remove();
            //add the next element of the removed list
            if (current.next != null) minHeap.add(current.next);

            //connect to the next if heap isn't empty
            if (!minHeap.isEmpty()) current.next = minHeap.peek();
        }
        return head;
    }

//goerge's solution for merging k linked lists
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0)
//        {
//            return null;
//        }
//        Queue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
//        for (int i = 0; i < lists.length; ++i) {
//            if (lists[i] != null) {
//                heap.add(lists[i]);
//            }
//        }
//        if (heap.isEmpty()) {
//            return null;
//        }
//        ListNode head = heap.peek();
//        while (!heap.isEmpty()) {
//            ListNode current = heap.remove();
//            if (current.next != null) {
//                heap.add(current.next);
//            }
//            if (!heap.isEmpty()) {
//                current.next = heap.peek();
//            }
//        }
//        return head;
//    }

    public static void main(String[] args){
        int[] arr1 = new int[]{1, 3, 5, 9, 14};
        int[] arr2 = new int[]{2, 4, 6, 8, 13};
        int[] arr3 = new int[]{1, 7, 10, 11, 12};

        LinkedList list1 = new LinkedList();
        for (int i = arr1.length - 1; i >= 0; i--) list1.add(arr1[i]);

        LinkedList list2 = new LinkedList();
        for (int i = arr2.length - 1; i >= 0; i--) list2.add(arr2[i]);

        LinkedList list3 = new LinkedList();
        for (int i = arr3.length - 1; i >= 0; i--) list3.add(arr3[i]);

        list1.print();
        list2.print();
        list3.print();

        ListNode[] lists = new ListNode[]{list1.head, list2.head, list3.head};
        ListNode result = mergeKLists(lists);

        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}