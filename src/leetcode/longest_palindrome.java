package leetcode;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class longest_palindrome {
    public class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[256];
            for (int i = 0; i < s.length(); i++){
                count[s.charAt(i)]++;
            }
            int odds = 0;
            for (int cnt : count){
                if (cnt%2 == 1) odds++;
            }
            return odds == 0 ? s.length() : s.length() - odds + 1;//can have 1 odd
        }
    }
}
