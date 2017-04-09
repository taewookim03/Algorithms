package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/7/2017.
 */
public class word_break {
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakUtil(s, new HashSet<String>(wordDict), new HashSet<String>());
        }

        private boolean wordBreakUtil(String s, Set<String> wordDict, Set<String> memo){
            if (s.length() == 0) return true;
            if (memo.contains(s)) return false;

            for (String word : wordDict){
                if (isPrefix(word, s)){
                    //backtracking
                    if (wordBreakUtil(s.substring(word.length()), wordDict, memo)) return true;
                    memo.add(s.substring(word.length()));
                }
            }
            return false;
        }

        //checks if small is a prefix of big
        private boolean isPrefix(String small, String big){
            int n = small.length();
            int m = big.length();
            if (n > m) return false;

            for (int i = 0; i < n; i++){
                if (small.charAt(i) != big.charAt(i)) return false;
            }
            return true;
        }
    }
}
