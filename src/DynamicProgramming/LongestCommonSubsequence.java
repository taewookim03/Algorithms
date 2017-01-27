package DynamicProgramming;

//DP
/*
find longest common subsequence of two strings - common subsequence in order, not necessarily contiguous.
e.g. "ABCBDAB" and "BDCABA" has LCS of "BCBA" or "BDAB" (or maybe some other ones)

Idea:
Find the size of the LCS. Let the function be LCS(A, B) where (A of size n and B of size m).
Realize that the problem has 3 cases:
for LCS_size(A_n, A_m)
1. if n == 0 or m == 0, LCS_size = 0;
2. if A_n == B_m, LCS_size = 1 + LCS_size(A_n-1, B_m-1)
3. if A_n != B_m, LCS_size = max(LCS_size(A_n-1, B_m), LCS_size(A_n, B_m-1))

after finding the size using DP, backtrack from the largest size (lcs[n][m]) to build string
until A_i == 0 or B_i == 0
 */
class LongestCommonSubsequence {
    static String LCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] lcs = new int[n+1][m+1];

        //find length of lcs using dp
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        //System.out.println(lcs[n][m]);

        //length of lcs is at lcs[n][m]
        //backtrack and build string
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                sb.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }
            else if (lcs[i-1][j] >= lcs[i][j-1]){//if equal, take the subproblem above (multiple solutions)
                i--;
            }
            else j--;
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";

        //System.out.println(LCS(s1, s2));
        System.out.println(LCS("republican", "democrat"));
    }
}
