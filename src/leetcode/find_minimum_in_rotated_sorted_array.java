package leetcode;

/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class find_minimum_in_rotated_sorted_array {
    public class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];

            //check if rotation is 0
            if (nums[0] < nums[n-1]) return nums[0];

            int i = 1;
            int j = n-1;
            int m = -1;
            while (i <= j){
                m = (i + j)/2;
                if (nums[m] < nums[m-1]) return nums[m];
                if (nums[m] > nums[n-1]){
                    i = m+1;
                }
                else {
                    j = m-1;
                }
            }
            return Integer.MIN_VALUE;
        }
    }
}
