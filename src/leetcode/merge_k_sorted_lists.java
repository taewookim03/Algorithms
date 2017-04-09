package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/9/2017.
 */
public class merge_k_sorted_lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val - b.val);
            for (ListNode list : lists){
                if (list != null) minHeap.add(list);
            }
            if (minHeap.isEmpty()) return null;

            ListNode head = minHeap.peek();
            //ListNode tail = null;

            while (!minHeap.isEmpty()){
                /*
                ListNode cur = minHeap.remove();
                if (tail != null) tail.next = cur;
                tail = cur;
                if (cur.next != null) minHeap.add(cur.next);
                */
                //more concise:
                ListNode cur = minHeap.remove();
                if (cur.next != null) minHeap.add(cur.next);
                if (!minHeap.isEmpty()) cur.next = minHeap.peek();
            }

            return head;
        }
    }
}
