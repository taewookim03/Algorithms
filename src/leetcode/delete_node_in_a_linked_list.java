package leetcode;

/**
 * Created by Taewoo Kim on 2/1/2017.
 */
public class delete_node_in_a_linked_list {
    private class ListNode{
        int val;
        ListNode next;
    }
    public class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) return;
            if (node.next == null) return;
            //problem specifies given a node except the tail, node.next is then not null until we get to the node before the tail
            //base case: copy tail value to new tail and delete tail
            if (node.next.next == null){
                node.val = node.next.val;
                node.next = null;//delete tail
                return;
            }

            //copy value from the next
            node.val = node.next.val;
            deleteNode(node.next);
        }
    }
}
