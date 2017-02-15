package leetcode;

/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class n_queens_ii {
    public class Solution {
        boolean[] col;
        boolean[] diag1;
        boolean[] diag2;

        public int totalNQueens(int n) {
            col = new boolean[n];
            diag1 = new boolean[2*n-1];
            diag2 = new boolean[2*n-1];

            return countUtil(0, n);
        }

        int countUtil(int row, int n){
            if (row == n){
                return 1;
            }

            int count = 0;
            //place on all possible spots in this row
            for (int j = 0; j < n; j++){
                int d1 = row - j + n - 1;
                int d2 = row + j;
                if (!col[j] && !diag1[d1] && !diag2[d2]){
                    col[j] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;
                    count += countUtil(row + 1, n);
                    //backtrack
                    col[j] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;
                }
            }
            return count;
        }
    }
}
