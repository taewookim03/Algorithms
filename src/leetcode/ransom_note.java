package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class ransom_note {
    public class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] charCount = new int[256];
            for (int i = 0; i < magazine.length(); i++){
                charCount[magazine.charAt(i)]++;
            }

            for (int i = 0; i < ransomNote.length(); i++){
                char c = ransomNote.charAt(i);
                charCount[c]--;
                if (charCount[c] < 0) return false;
            }
            return true;
        }
    }
}
