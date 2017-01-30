package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class add_digits {
    //recognized pattern by testing n = 0 ~ 50 or so
    public class Solution {
        public int addDigits(int num) {
            if (num == 0) return 0;
            if (num % 9 == 0) return 9;
            return num % 9;
        }
    }
}
