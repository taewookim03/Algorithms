package leetcode;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class partition_equal_subset_sum {
    public class Solution {
        public boolean canPartition(int[] nums) {
            int maxSum = 0;
            for (int num : nums) maxSum += num;
            if (maxSum%2 == 1) return false;
            if (nums.length <= 1) return false;

            boolean[] dp = new boolean[maxSum + 1];
            dp[0] = true;

            for (int i = 0; i < nums.length; i++){
                for (int k = dp.length - 1; k >= 0; k--){
                    if (dp[k]){
                        dp[k + nums[i]] = true;
                    }
                }
                if (dp[maxSum/2]) return true;
            }
            return false;
        }
    }
}
