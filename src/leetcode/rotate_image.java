package leetcode;

/**
 * Created by Taewoo Kim on 4/4/2017.
 */
public class rotate_image {
    public class Solution2{
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            if (n <= 1) return;

            //flip upside down
            for (int i = 0; i < n/2; i++){
                int[] temp = matrix[i];
                matrix[i] = matrix[n-1-i];
                matrix[n-1-i] = temp;
            }

            for (int i = 0; i < n; i++){
                for (int j = i+1; j < n; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            if (n <= 1) return;

            for (int i = 0; i < n/2; i++){
                for (int j = i; j < n-1-i; j++){
                    int top = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = top;
                }
            }
        }
    }

    public static void main(String[] args){
        Solution s1 = new rotate_image().new Solution();
        Solution2 s2 = new rotate_image().new Solution2();
        int[][] m = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        s2.rotate(m);
        //s1.rotate(m);

        for (int[] r : m){
            for (int c : r){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
