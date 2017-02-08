package leetcode;

import java.util.Random;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class shuffle_an_array {
    //simple fisher-yates shuffle algorithm
    public class Solution {
        int[] arr;
        public Solution(int[] nums) {
            arr = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return arr;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            Random rand = new Random();
            int[] shuffled = arr.clone();
            for (int i = shuffled.length - 1; i >= 0; i--){
                int k = i + 1;
                int r = rand.nextInt(k);
                int temp = shuffled[i];
                shuffled[i] = shuffled[r];
                shuffled[r] = temp;
            }
            return shuffled;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
