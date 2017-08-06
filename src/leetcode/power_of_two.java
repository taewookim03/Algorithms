package leetcode;

/**
 * Created by Taewoo Kim on 7/24/2017.
 */
public class power_of_two {
    public class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n-1)) == 0;
        }
    }
}
