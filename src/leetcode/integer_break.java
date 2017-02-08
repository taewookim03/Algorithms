package leetcode;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class integer_break {
    public class Solution {
        public int integerBreak(int n) {
            if (n <= 3) return n-1;

            int threes = n / 3;
            int rem = n % 3;
            if (rem == 1){
                threes--;
                rem = 4;
            }
            if (rem == 0) return (int)Math.pow(3, threes);
            else return rem * (int)Math.pow(3, threes);
        }
    }
}
