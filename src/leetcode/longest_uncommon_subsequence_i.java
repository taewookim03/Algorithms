package leetcode;

/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class longest_uncommon_subsequence_i {
    public class Solution {
        public int findLUSlength(String a, String b) {
            if (a.equals(b)) return -1;
            if (a.length() != b.length()) return Math.max(a.length(),b.length());
            return a.length();
        }
    }
}
