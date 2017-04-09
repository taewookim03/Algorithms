package leetcode;

/**
 * Created by Taewoo Kim on 4/6/2017.
 */
public class add_two_numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addUtil(l1, l2, 0);
        }

        private ListNode addUtil(ListNode a, ListNode b, int carry){
            if (a == null && b == null && carry == 0) return null;
            int sum = (a == null ? 0 : a.val) + (b == null ? 0 : b.val) + carry;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = addUtil(a == null ? null : a.next, b == null ? null : b.next, sum / 10);
            return newNode;
        }
    }
}
