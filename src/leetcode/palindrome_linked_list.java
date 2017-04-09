package leetcode;

/**
 * Created by Taewoo Kim on 4/8/2017.
 */
public class palindrome_linked_list {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            slow.next = reverse(slow.next);
            slow = slow.next;
            fast = head;

            while (slow != null){
                if (slow.val != fast.val) return false;
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        private ListNode reverse(ListNode node){
            ListNode prev = null;
            ListNode cur = node;
            ListNode next = null;
            while (cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
