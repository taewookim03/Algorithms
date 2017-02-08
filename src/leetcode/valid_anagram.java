package leetcode;

/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class valid_anagram {
    public class Solution {
        public boolean isAnagram(String s, String t) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++){
                count[t.charAt(i) - 'a']--;
                if (count[t.charAt(i) - 'a'] < 0) return false;
            }
            for (int i = 0; i < count.length; i++){
                if (count[i] != 0) return false;
            }
            return true;
        }
    }
}
