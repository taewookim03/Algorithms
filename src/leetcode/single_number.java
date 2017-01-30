package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class single_number {
    public class Solution {
        public int singleNumber(int[] nums) {
            //using the fact that XOR is associative and x ^ x = 0
            int x = 0;
            for (int n : nums){
                x ^= n;
            }
            return x;
        }
    }
}
