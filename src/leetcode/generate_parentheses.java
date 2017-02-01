package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class generate_parentheses {
    //simple recursive solution - consider next available string to append
    public class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            genParenRec("", n, n, result);
            return result;
        }
        void genParenRec(String s, int open, int close, List<String> result){
            //base case
            if (open == 0 && close == 0){
                result.add(s);
                return;
            }

            if (open > 0) genParenRec(s + "(", open - 1, close, result);
            if (close > open) genParenRec(s + ")", open, close - 1, result);
        }
    }
}
