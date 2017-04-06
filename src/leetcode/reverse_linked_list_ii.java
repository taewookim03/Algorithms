package leetcode;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class reverse_linked_list_ii {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || head.next == null) return null;

            ListNode leftTail, reversedTail;
            ListNode prev = null, cur = head, next;
            for (int i = 1; i < m; i++){
                prev = cur;
                cur = cur.next;
            }
            leftTail = prev;
            reversedTail = cur;//tail of the reversed portion AFTER reversing
            prev = null;

            for (int i = m; i <= n; i++){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            //head of reversed portion is at prev
            if (leftTail != null) leftTail.next = prev;
            if (reversedTail != null) reversedTail.next = cur;//head of right is in cur

            if (m == 1) return prev;
            return head;
        }
    }
}
