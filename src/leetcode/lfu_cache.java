package leetcode;

import java.util.*;

/**
 * Created by Taewoo Kim on 4/1/2017.
 */
public class lfu_cache{
    public class LFUCache {
        private int capacity;
        private int size;
        private Map<Integer,ValNode> valMap;//key->val
        private Map<Integer,FreqNode> freqMap;//freq->node containing keys
        private FreqNode head;

        class ValNode{
            int val;
            int freq;
            ValNode(int val, int freq){
                this.val = val;
                this.freq = freq;
            }
        }
        class FreqNode{
            int freq;
            FreqNode prev, next;
            Set<Integer> keys;
            FreqNode(int freq){
                this.freq = freq;
                keys = new LinkedHashSet<>();//keeps insertion order
            }
        }

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.valMap = new HashMap<>();
            this.freqMap = new HashMap<>();
        }

        public int get(int key) {
            if(valMap.containsKey(key)){
                increaseCount(key);
                return valMap.get(key).val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity <= 0) return;//           EDGE CASE (LFUCache(0), add something to LFU cache with capacity 0)
            if(valMap.containsKey(key)){
                valMap.get(key).val = value;
                increaseCount(key);
            }
            else{
                if(size >= capacity){
                    removeLeastFreq();
                }
                if (!freqMap.containsKey(1)){
                    FreqNode fnode = new FreqNode(1);
                    fnode.next = head;
                    if (head != null) head.prev = fnode;
                    freqMap.put(1, fnode);
                    head = fnode;
                }
                valMap.put(key, new ValNode(value, 1));
                linkFnodeKey(1, key);
                size++;
            }
        }

        private void increaseCount(int key){
            ValNode vnode = valMap.get(key);
            FreqNode fnode = freqMap.get(vnode.freq);
            FreqNode next = fnode.next;

            //create a node for the new freq if necessary
            if (!freqMap.containsKey(vnode.freq+1)){
                FreqNode newNode = new FreqNode(vnode.freq+1);
                freqMap.put(vnode.freq+1, newNode);
                newNode.prev = fnode;
                newNode.next = next;
                fnode.next = newNode;
                if (next != null) next.prev = newNode;
            }
            unlinkFnodeKey(vnode.freq, key);
            vnode.freq++;
            linkFnodeKey(vnode.freq, key);
        }

        private void linkFnodeKey(int freq, int key){
            FreqNode fnode = freqMap.get(freq);
            fnode.keys.add(key);
        }

        private void unlinkFnodeKey(int freq, int key){
            FreqNode fnode = freqMap.get(freq);
            fnode.keys.remove(key);
            if (fnode.keys.isEmpty()){
                deleteFreqNode(fnode);
            }
        }

        private void removeLeastFreq(){
            if(head.keys.isEmpty()) return;

            int key = head.keys.iterator().next();
            valMap.remove(key);
            unlinkFnodeKey(head.freq, key);
            size--;
        }
        private void deleteFreqNode(FreqNode node){
            FreqNode prev = node.prev;
            FreqNode next = node.next;
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
            if (node == head) head = next;
            freqMap.remove(node.freq);
        }
    }
    public static void main(String[] args){
        LFUCache c = new lfu_cache().new LFUCache(2);

        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        c.put(4,4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}