package leetcode;

/**
 * Created by Taewoo Kim on 2/12/2017.
 */
public class reverse_linked_list {
    private class ListNode{
        ListNode next;
    }
    public class Solution {
        public ListNode reverseList(ListNode node) {
            if (node == null || node.next == null) return node;
            ListNode tail = reverseList(node.next);
            node.next.next = node;
            node.next = null;
            return tail;
        }
    }
}
