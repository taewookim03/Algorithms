package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class letter_combinations_of_a_phone_number {
    public class Solution {
        String[] numLetterMap = new String[]{
                " ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits == null || digits.length() == 0) return res;

            letterCombinationsUtil(digits, new StringBuilder(), 0, res);
            return res;
        }

        private void letterCombinationsUtil(String digits, StringBuilder letters, int i, List<String> res){
            //base case
            if (i == digits.length()){
                res.add(letters.toString());
                return;
            }

            int digit = digits.charAt(i) - '0';
            for (char c : numLetterMap[digit].toCharArray()){
                letters.append(c);
                letterCombinationsUtil(digits, letters, i+1, res);
                letters.deleteCharAt(letters.length()-1);
            }
        }
    }
}
