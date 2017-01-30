package leetcode;

import java.util.Random;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class linked_list_random_node {
    ListNode head;
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    //reservoir sampling (k=1), faster on large lists and works on unknown size
    public int getRandom() {
        ListNode result = head;
        int size = 1;
        Random random = new Random();

        ListNode curr = head.next;
        while (curr != null){
            if (random.nextInt(++size) == 0){
                result = curr;
            }
            curr = curr.next;
        }
        return result.val;
    }


    //naive method counting length
    public int getRandom2() {
        //count length
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            count++;
            curr = curr.next;
        }

        curr = head;
        Random random = new Random();
        while (curr != null){
            if (random.nextInt(count--) == 0){
                return curr.val;
            }
            curr = curr.next;
        }
        return head.val;
    }
}
