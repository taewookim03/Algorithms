package leetcode;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class search_a_2d_matrix_ii {
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            if (n < 1) return false;
            int m = matrix[0].length;
            if (m < 1) return false;

            int i = 0, j = m-1;
            while (i < n && j >= 0){
                int val = matrix[i][j];
                if (target == val) return true;
                if (target < val) j--;
                else if (target > val) i++;
            }
            return false;
        }
    }
}
