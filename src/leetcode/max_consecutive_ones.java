package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
concise but probably less efficient solution:

 public int findMaxConsecutiveOnes(int[] nums) {
    int maxHere = 0, max = 0;
    for (int n : nums)
    max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
    return max;
 }

 */

public class max_consecutive_ones {
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int maxCount = 0;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == 1){
                    count++;
                }
                else{
                    if (count > maxCount) maxCount = count;
                    count = 0;
                }
            }
            if (count > maxCount) maxCount = count;

            return maxCount;
        }
    }
}
