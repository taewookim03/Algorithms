package leetcode;

/**
 * Created by Taewoo Kim on 2/7/2017.
 */
public class wildcard_matching {
    public class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            if (n != 0 && m == 0) return false;//cant match anything with an empty pattern

            boolean[][] match = new boolean[n+1][m+1];
            //initialize first column (empty pattern can't match anything except empty string)
            match[0][0] = true;

            //initialize first row (only * can match empty string)
            for (int j = 1; j <= m; j++){
                if (p.charAt(j-1) == '*') match[0][j] = match[0][j-1];
            }

            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= m; j++){
                    if (p.charAt(j-1) == '*'){
                        match[i][j] = match[i][j-1] || match[i-1][j];//match empty char or any number of chars
                    }
                    else if (p.charAt(j-1) == '?'){
                        match[i][j] = match[i-1][j-1];
                    }
                    else match[i][j] = match[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }

            return match[n][m];

        }
    }
    //working recursive
    public class Solution2 {
        public boolean isMatch(String s, String p) {
            return isMatchUtil(s, p, 0, 0);
        }
        boolean isMatchUtil(String s, String p, int i, int j){
            //base cases
            if (i == s.length()){
                if (j == p.length()) return true;//every character matches
                if (p.charAt(j) == '?' || p.charAt(j) == '*') return isMatchUtil(s, p, i, j+1);//check next pattern char
                return false;
            }
            if (j == p.length()) return false;//can't match string with an empty pattern

            char c = s.charAt(i);
            char pattern = p.charAt(j);

            if (pattern == '?'){
                //return isMatchUtil(s, p, i+1, j+1) || isMatchUtil(s, p, i, j+1);
                return isMatchUtil(s, p, i+1, j+1);//apparently in this problem ? can't match ""
            }
            if (pattern == '*'){
                for (int k = i; k <= s.length(); k++){
                    if (isMatchUtil(s, p, k, j+1)) return true;
                }
                return false;
            }
            return c == pattern && (isMatchUtil(s, p, i+1, j+1));
        }
    }
}
