package leetcode;

/**
 * Created by Taewoo Kim on 1/28/2017.
 *
 * top solution uses math to find that perim = 4 * num islands - 2 * num neighbors (only counted in 2 directions
 * e.g. down and right to avoid double counting)
 */
public class island_perimeter {
    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int count = 0;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if (grid[i][j] == 1){
                        count += countPerim(grid, i , j);
                    }
                }
            }
            return count;
        }

        public int countPerim(int[][] grid, int i, int j){
            int top = (i == 0 || grid[i-1][j] == 0) ? 1 : 0;
            int bottom = (i == grid.length - 1 || grid[i+1][j] == 0) ? 1 : 0;
            int left = (j == 0 || grid[i][j-1] == 0) ? 1 : 0;
            int right = (j == grid[0].length - 1 || grid[i][j+1] == 0) ? 1 : 0;
            return top+bottom+left+right;
        }
    }
}
