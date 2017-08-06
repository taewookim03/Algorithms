package leetcode;

/**
 * Created by Taewoo Kim on 7/9/2017.
 */
public class single_element_in_a_sorted_array {
    public class Solution {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;
            int x = 0;
            for (int i = 0; i < n; i++){
                x ^= nums[i];
            }
            return x;
        }
    }
}
