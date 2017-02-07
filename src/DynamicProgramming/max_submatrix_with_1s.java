package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/6/2017.
 */
public class max_submatrix_with_1s {
    static int max1Submatrix(int[][] matrix){
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;

        int maxSize = 0;
        int[][] s = new int[n][m];//max square ending here (bottom right corner)
        for (int i = 0; i < n; i++){
            s[i][0] = matrix[i][0];
            if (s[i][0] > maxSize) maxSize = s[i][0];
        }
        for (int j = 1; j < m; j++){
            s[0][j] = matrix[0][j];
            if (s[0][j] > maxSize) maxSize = s[0][j];
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][j] == 1){
                    s[i][j] = 1 + Math.min(s[i-1][j], Math.min(s[i-1][j-1], s[i][j-1]));
                    if (s[i][j] > maxSize) maxSize = s[i][j];
                }
            }
        }
        return maxSize;
    }
    public static void main(String[] args){
        int[][] matrix =  {
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}};
        //output: 9

        System.out.println(max1Submatrix(matrix));
    }
}
