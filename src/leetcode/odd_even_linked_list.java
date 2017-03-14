package leetcode;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class odd_even_linked_list {
    private class ListNode{
        int val;
        ListNode next;
    }

    public class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) return head;
            boolean odd = true;
            ListNode oddHead = head;
            ListNode evenHead = head.next;

            ListNode oddTail = null;
            ListNode evenTail = null;

            ListNode oddCurr = head;
            ListNode evenCurr = head.next;
            while (oddCurr != null && evenCurr != null){
                if (odd){
                    if (oddTail != null) oddTail.next = oddCurr;
                    oddTail = oddCurr;
                    evenCurr = oddTail.next;
                }
                else{
                    if (evenTail != null) evenTail.next = evenCurr;
                    evenTail = evenCurr;
                    oddCurr = evenTail.next;
                }
                odd = !odd;
            }
            oddTail.next = evenHead;
            evenTail.next = null;
            return oddHead;
        }
    }
}
