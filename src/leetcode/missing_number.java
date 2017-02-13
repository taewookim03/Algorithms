package leetcode;

/**
 * Created by Taewoo Kim on 2/12/2017.
 */
public class missing_number {
    public class Solution {
        public int missingNumber(int[] nums) {
            //O(n) time O(1) space
            int x = nums.length;
            for (int i = 0; i < nums.length; i++){
                x = x ^ i ^ nums[i];
            }
            return x;
        }
    }
}
