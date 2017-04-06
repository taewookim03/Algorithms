package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class sliding_window_maximum {
    public class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n < 1) return new int[0];

            int[] res = new int[n-k+1];

            Deque<Integer> maxDeque = new ArrayDeque<>();

            for (int left = 0, right = 0; right < n; right++){
                while (!maxDeque.isEmpty() && maxDeque.getLast() < nums[right]){
                    maxDeque.removeLast();
                }
                maxDeque.addLast(nums[right]);

                if (right - left == k){
                    if (nums[left] == maxDeque.getFirst()){
                        maxDeque.removeFirst();
                    }
                    left++;
                }

                res[left] = maxDeque.getFirst();
            }

            return res;
        }
    }

            /*
            alternative loop
        //initialize window
        for (int i = 0; i < k; i++){
            while (!maxDeque.isEmpty() && maxDeque.getLast() < nums[i]){
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[i]);
        }

        for (int i = 0; i < n-k; i++){
            res[i] = maxDeque.getFirst();
            if (nums[i] == maxDeque.getFirst()) maxDeque.removeFirst();
            while (!maxDeque.isEmpty() && maxDeque.getLast() < nums[i+k]){
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[i+k]);
        }
        res[n-k] = maxDeque.getFirst();
        */
}
