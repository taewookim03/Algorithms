package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/7/2017.
 */
public class word_break_ii {
    public class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            return wordBreakUtil(s, wordDict, new HashMap<String, List<String>>());
        }

        private List<String> wordBreakUtil(String s, List<String> wordDict, Map<String, List<String>> memo){
            if (s.length() == 0){
                List<String> base = new ArrayList<>();
                base.add("");
                return base;
            }
            if (memo.containsKey(s)){
                return memo.get(s);
            }

            List<String> res = new ArrayList<>();

            for (String word : wordDict){
                if (isPrefix(word, s)){
                    List<String> breakRest = wordBreakUtil(s.substring(word.length()), wordDict, memo);
                    for (String rest : breakRest){
                        res.add(word + (rest.length() == 0 ? "" : " " + rest));
                    }
                }
            }
            memo.put(s, res);
            return res;
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
