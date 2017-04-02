package leetcode;

/**
 * Created by Taewoo Kim on 2/2/2017.
 */
public class number_of_islands {
    //more efficient solution with no extra space if allowed to modify input, also can use bfs to avoid stack overflow
    public class Solution {
        int[][] dir = new int[][]{
                {-1, 0},//up
                {1, 0},//down
                {0, -1},//left
                {0, 1}//right
        };

        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int n = grid.length;
            int m = grid[0].length;

            int count = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j){
            int n = grid.length;
            int m = grid[0].length;

            grid[i][j] = '2';

            for (int d = 0; d < dir.length; d++){
                int row = i + dir[d][0];
                int col = j + dir[d][1];
                if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1'){
                    dfs(grid, row, col);
                }
            }
        }
    }

    public class Solution2 {
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int n = grid.length;
            int m = grid[0].length;

            boolean[][] visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (grid[i][j] == '1' && !visited[i][j]){
                        count++;
                        dfs(grid, i, j, visited);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j, boolean[][] visited){
            int n = grid.length;
            int m = grid[0].length;

            visited[i][j] = true;
            //up down left right
            int[][] dir = new int[][]{
                    {-1, 0},//up
                    {1, 0},//down
                    {0, -1},//left
                    {0, 1}//right
            };

            for (int d = 0; d < dir.length; d++){
                int row = i + dir[d][0];
                int col = j + dir[d][1];
                if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == '1' && !visited[row][col]){
                    dfs(grid, row, col, visited);
                }
            }
        }
    }
}
