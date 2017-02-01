package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
class LRUCache {
    //doubly linked list implementation of queue with hashtable for key->node for O(1) operations
    private int capacity;
    private int size;
    private Node head, tail;
    private Map<Integer,Node> keyNodeMap;

    private class Node{
        int key;
        int value;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        keyNodeMap = new HashMap<>();
    }

    public int get(int key) {
        Node keyNode = keyNodeMap.get(key);
        //key doesn't exist
        if (keyNode == null) return -1;

        updateNode(keyNode);

        return keyNode.value;
    }

    public void put(int key, int value) {
        //check size, delete and decrement size if needed, add, increment size

        //if key already exists, just update value and update node as recently used
        if (keyNodeMap.containsKey(key)){
            Node keyNode = keyNodeMap.get(key);
            keyNode.value = value;
            updateNode(keyNode);
        }
        else{
            //must add this element to the tail
            if (size == capacity){
                //if at cap, pop off head (least recently used)
                int headKey = head.key;
                //System.out.println("removing key " + headKey);
                head = head.next;
                if (head != null) head.prev = null;
                size--;
                keyNodeMap.remove(headKey);
            }

            //add to tail and increment size
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            if (tail != null) tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            if (head == null) head = newNode;
            size++;
        }
        //System.out.println("current head: " + head.key);
    }

    public void updateNode(Node keyNode){
        //"uses" a node, meaning it is now most recently used item - take out of list and append to tail of the list
        //extract keynode out of the list (update head if needed) and append to tail and update tail
        if (size == 1) return;

        if (keyNode == head){
            head = head.next;
            head.prev = null;
        }
        else if (keyNode == tail){
            //do nothing
            return;
        }
        else{
            //else keynode is in the middle of the list
            Node before = keyNode.prev;
            Node after = keyNode.next;
            before.next = after;
            after.prev = before;
        }
        //append keynode and update tail
        tail.next = keyNode;
        keyNode.prev = tail;
        keyNode.next = null;
        tail = keyNode;
    }

    public static void main(String[] args){
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        System.out.println(obj.get(2));
        obj.put(1, 1);
        obj.put(4, 3);
        System.out.println(obj.get(2));
        System.out.println(obj.get(1));
        System.out.println(obj.get(4));
    }
}
