package leetcode;

/**
 * Created by Taewoo Kim on 4/14/2017.
 */
public class minimum_path_sum {
    public class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            if (n < 1) return 0;
            int m = grid[0].length;
            if (m < 1) return 0;

            int[] above = new int[m];
            //initialize
            above[0] = grid[0][0];
            for (int j = 1; j < m; j++){
                above[j] = above[j-1] + grid[0][j];
            }

            for (int i = 1; i < n; i++){
                int[] cur = new int[m];
                cur[0] = above[0] + grid[i][0];
                for (int j = 1; j < m; j++){
                    cur[j] = Math.min(cur[j-1], above[j]) + grid[i][j];
                }
                above = cur;
            }
            return above[m-1];
        }
    }
}
