package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class copy_list_with_random_pointer {
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }

        @Override
        public String toString() {
            return "label: " + label + ", next: " + (next == null ? "null" : next.label) + ", random: " + (random == null ? "null" : random.label);
        }
    }
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;

            Map<RandomListNode, RandomListNode> copyMap = new HashMap<>();
            RandomListNode cur = head;
            RandomListNode copyHead = copy(head, copyMap);
            RandomListNode copyCur = copyHead;
            while (cur != null){
                copyCur.next = copy(cur.next, copyMap);
                copyCur.random = copy(cur.random, copyMap);

                cur = cur.next;
                copyCur = copyCur.next;
            }
            return copyHead;
        }

        private RandomListNode copy(RandomListNode node, Map<RandomListNode, RandomListNode> copyMap){
            if (node == null) return null;
            if (!copyMap.containsKey(node)){
                copyMap.put(node, new RandomListNode(node.label));
            }
            return copyMap.get(node);
        }
    }

    public static void main(String[] args){
        Solution s = new copy_list_with_random_pointer().new Solution();
        RandomListNode head = new RandomListNode(-1);
        RandomListNode cp = s.copyRandomList(head);

        while (cp != null){
            System.out.println(cp);
            cp = cp.next;
        }
    }
}
