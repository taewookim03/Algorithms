package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Taewoo Kim on 2/27/2017.
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class continuous_subarray_sum {
    public class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            k = Math.abs(k);
            int n = nums.length;
            if (n < 2) return false;

            int[] prefixSum = new int[n];
            prefixSum[0] = k == 0 ? nums[0] : nums[0] % k;
            for (int i = 1; i < n; i++){
                prefixSum[i] = k == 0 ? (prefixSum[i-1] + nums[i]) : (prefixSum[i-1] + nums[i]) % k;
            }

            Set<Integer> preSet = new HashSet<>();
            preSet.add(0);
            if (prefixSum[1] == 0) return true;

            for (int i = 2; i < n; i++){
                preSet.add(prefixSum[i-2]);
                if (preSet.contains(prefixSum[i])) return true;
            }

            return false;
        }

    }
}
