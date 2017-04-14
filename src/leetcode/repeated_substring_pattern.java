package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class repeated_substring_pattern {
    public class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int len = 1; len <= n/2; len++){
                if (n % len != 0) continue;
                boolean eq = true;
                for (int j = 0; j < len && eq; j++){
                    char c = s.charAt(j);
                    for (int i = len; i < n && eq; i += len){
                        if (s.charAt(i+j) != c) eq = false;
                    }
                }
                if (eq) return true;
            }
            return false;
        }
    }
}
