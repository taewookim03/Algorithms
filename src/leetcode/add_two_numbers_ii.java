package leetcode;

import java.util.Stack;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class add_two_numbers_ii {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    //without modifying input lists using stacks
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }

            ListNode sumList = null;
            int carry = 0;
            while (!s1.isEmpty() || !s2.isEmpty()){
                int sum = 0;
                if (!s1.isEmpty()) sum += s1.pop();
                if (!s2.isEmpty()) sum += s2.pop();
                sum += carry;

                int digit = sum % 10;
                carry = sum / 10;
                ListNode newNode = new ListNode(digit);
                newNode.next = sumList;
                sumList = newNode;
            }
            if (carry > 0){
                ListNode newNode = new ListNode(carry);
                newNode.next = sumList;
                sumList = newNode;
            }

            return sumList;
        }
    }

    //using reverse
    public class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);

            ListNode sumNode = sum(l1, l2, 0);

            return reverse(sumNode);
        }

        public ListNode sum(ListNode l1, ListNode l2, int carry){
            if (l1 == null){
                if (l2 == null) {
                    if (carry == 1){
                        return new ListNode(1);
                    }
                    else{
                        return null;
                    }
                }
                l2.val += carry;
                if (l2.val == 10){
                    l2.val = 0;
                    l2.next = sum(null, l2.next, 1);
                }
                return l2;
            }
            if (l2 == null){
                l1.val += carry;
                if (l1.val == 10){
                    l1.val = 0;
                    l1.next = sum(l1.next, null, 1);
                }
                return l1;
            }

            ListNode sumNode = new ListNode((l1.val + l2.val + carry)%10);
            carry = (l1.val + l2.val + carry) / 10;
            sumNode.next = sum(l1.next, l2.next, carry);
            return sumNode;
        }

        public ListNode reverse(ListNode node){
            if (node == null || node.next == null) return node;//this is the tail
            ListNode tail = reverse(node.next);
            node.next.next = node;
            node.next = null;

            return tail;
        }
    }
}
