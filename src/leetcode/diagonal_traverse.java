package leetcode;

/**
 * Created by Taewoo Kim on 2/4/2017.
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.

 Example 1:
 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]
 Explanation: (diagram showing diagonal first going in upper right direction (1), then lower left (2, 4),
 then upper right (7, 5, 3), then lower left (6, 8), then upper right (9))

 Note:
 The total number of elements of the given matrix will not exceed 10,000.
 */
public class diagonal_traverse {
    public class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};
            int m = matrix.length;
            int n = matrix[0].length;

            int[] res = new int[m*n];
            int k = 0;

            int i = 0;
            int j = 0;
            int N = m+n-1;
            boolean upright = true;
            for (int d = 0; d < N; d++){
                if (upright){
                    while(i >= m){
                        i--;
                        j++;
                    }
                    while (i >= 0 && i < m && j >= 0 && j < n){
                        res[k++] = matrix[i--][j++];
                    }
                    i++;
                }
                else{
                    while(j >= n){
                        i++;
                        j--;
                    }
                    while(i >= 0 && j >= 0 && i < m && j < n){
                        res[k++] = matrix[i++][j--];
                    }
                    j++;

                }

                upright = !upright;
            }
            return res;
        }
    }
}
