package leetcode;

/**
 * Created by Taewoo Kim on 4/28/2017.
 */
public class combination_sum_iv {
    public class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] count = new int[target + 1];
            int n = nums.length;
            count[0] = 1;//1 way to make 0

            for (int j = 0; j <= target; j++){
                for (int i = 0; i < n; i++){
                    if (nums[i] <= j) count[j] += count[j - nums[i]];
                }
            }

            return count[target];
        }
    }
}
