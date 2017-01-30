package leetcode;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class find_the_difference {
    //could use bit manipulation since this is very similar to the "single number" problem with 1 unique element
    //and all others repeat multiple of 2 times (use xor on everything to get unique odd occurring element)
    public class Solution {
        public char findTheDifference(String s, String t) {
            char r = t.charAt(t.length() - 1);
            for (int i = 0; i < s.length(); i++){
                r ^= s.charAt(i) ^ t.charAt(i);
            }
            return r;
        }
    }

    //easy frequency count int array
    public class Solution2 {
        public char findTheDifference(String s, String t) {
            int[] charFreq = new int[26];
            for (int i = 0; i < s.length(); i++){
                charFreq[s.charAt(i) - 'a']--;
            }
            for (int i = 0; i < t.length(); i++){
                charFreq[t.charAt(i) - 'a']++;
            }
            for (int i = 0; i < charFreq.length; i++){
                if (charFreq[i] == 1) return (char)('a' + i);
            }
            return '\0';
        }
    }
}
