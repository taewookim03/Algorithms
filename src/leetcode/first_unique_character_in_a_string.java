package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class first_unique_character_in_a_string {
    public class Solution {
        public int firstUniqChar(String s) {
            int[] charFreq = new int[256];
            for (int i = 0; i < s.length(); i++){
                charFreq[s.charAt(i)]++;
            }

            int i;
            for (i = 0; i < s.length(); i++){
                if (charFreq[s.charAt(i)] == 1){
                    break;
                }
            }
            return i == s.length() ? -1 : i;
        }
    }
}
