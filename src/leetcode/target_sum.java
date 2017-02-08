package leetcode;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class target_sum {
    public class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int maxSum = 0;
            for (int num : nums) maxSum += num;
            if (S > maxSum) return 0;

            int[] prev = new int[2*maxSum + 1];
            prev[maxSum] = 1;//1 way to make 0 with 0 numbers

            for (int i = 0; i < nums.length; i++){
                int[] dp = new int[2*maxSum + 1];
                for (int k = 0; k < dp.length; k++){
                    if (prev[k] != 0){
                        dp[k - nums[i]] += prev[k];//prev[k] ways to get to k-nums[i] subsum
                        dp[k + nums[i]] += prev[k];
                    }
                }
                prev = dp;
            }
            return prev[maxSum + S];
        }
    }
}
