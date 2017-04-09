package leetcode;

/**
 * Created by Taewoo Kim on 4/6/2017.
 */
public class linked_list_cycle_ii {
    public class Solution {
        public class ListNode{
            int val;
            ListNode next;
            ListNode(int x){
                val = x;
            }
        }

        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) break;
            }
            if (fast == null || fast.next == null) return null;//no cycle

            fast = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
