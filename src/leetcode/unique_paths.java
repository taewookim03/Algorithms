package leetcode;

/**
 * Created by Taewoo Kim on 8/5/2017.
 */
public class unique_paths {
    public class Solution {
        public int uniquePaths(int m, int n) {
            int[][] paths = new int[m][n];
            if (m < 1 || n < 1) return 0;

            //straight lines - 1 path
            for (int i = 0; i < m; i++){
                paths[i][n-1] = 1;
            }
            for (int j = 0; j < n; j++){
                paths[m-1][j] = 1;
            }

            for (int i = m-2; i >= 0; i--){
                for (int j = n-2; j >= 0; j--){
                    paths[i][j] = paths[i+1][j] + paths[i][j+1];
                }
            }

            return paths[0][0];
        }
    }
}
