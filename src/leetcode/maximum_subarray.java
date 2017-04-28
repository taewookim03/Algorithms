package leetcode;

/**
 * Created by Taewoo Kim on 4/17/2017.
 */
public class maximum_subarray {
    public class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n < 1) return 0;

            int maxSum = nums[0];
            int runningSum = nums[0];
            for (int i = 1; i < n; i++){
                runningSum = Math.max(runningSum + nums[i], nums[i]);
                maxSum = Math.max(maxSum, runningSum);
            }
            return maxSum;
        }
    }
}
