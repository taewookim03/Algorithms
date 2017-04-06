package leetcode;

/**
 * Created by Taewoo Kim on 4/4/2017.
 */
public class longest_palindromic_subsequence {
    public class Solution {
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            if (n <= 1) return n;

            int[][] dp = new int[n][n];

            for (int i = n-1; i >= 0; i--){
                for (int j = i; j < n; j++){
                    if (i == j) {
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = Math.max((s.charAt(i) == s.charAt(j) ? 2 : 0) + dp[i+1][j-1], Math.max(dp[i+1][j], dp[i][j-1]));
                }
            }
            return dp[0][n-1];
        }
    }
}
