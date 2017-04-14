package leetcode;

/**
 * Created by Taewoo Kim on 4/11/2017.
 */
public class set_matrix_zeroes {
    public class Solution {
        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            if (n < 1) return;
            int m = matrix[0].length;
            if (m < 1) return;

            boolean col0HasZero = false;
            for (int i = 0; i < n; i++){
                if (matrix[i][0] == 0) col0HasZero = true;
                for (int j = 1; j < m; j++){
                    if (matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = n-1; i >= 0; i--){
                for (int j = m-1; j > 0; j--){
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }
                if (col0HasZero) matrix[i][0] = 0;
            }
        }
    }
}
