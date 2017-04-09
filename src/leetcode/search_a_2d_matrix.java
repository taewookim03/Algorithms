package leetcode;

/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class search_a_2d_matrix {
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            if (n < 1) return false;
            int m = matrix[0].length;
            if (m < 1) return false;

            int len = n*m;//number of elements in the matrix

            int left = 0, right = len - 1, mid = 0;
            while (left <= right){
                mid = (left+right)/2;
                int midVal = getMatrixValueAt(matrix, mid);
                if (midVal == target){
                    return true;
                }
                else if (target < midVal){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            return false;
        }

        private int getMatrixValueAt(int[][] matrix, int pos){
            //convert pos to row, col
            int m = matrix[0].length;
            int row = pos / m;
            int col = pos % m;
            return matrix[row][col];
        }
    }
}
