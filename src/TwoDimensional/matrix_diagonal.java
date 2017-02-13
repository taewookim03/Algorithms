package TwoDimensional;

/**
 * Created by Taewoo Kim on 2/10/2017.
 *
 */
public class matrix_diagonal {
    static void printDiagonal(int[][] matrix){
        int r = matrix.length;
        if (r == 0) return;
        int c = matrix[0].length;
        if (c == 0) return;

        for (int k = 0; k < r; k++){
            int i = k;
            int j = 0;
            while (i >= 0 && j < c){
                System.out.print(matrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

        for (int k = 1; k < c; k++){
            int i = r - 1;
            int j = k;
            while (i >= 0 && j < c){
                System.out.print(matrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

//        int r = matrix.length;
//        int c = matrix[0].length;
//
//        for(int i = 0; i < r; ++i) {
//            int j = i;
//            int k = 0;
//            while(j >= 0 && k < c) {
//                System.out.print(matrix[j][k] + " ");
//                --j;
//                ++k;
//            }
//            System.out.println();
//        }
//
//        for(int j = 1; j < c; ++j) {
//            int i = r-1;
//            int k = j;
//            while(i >= 0 && k < c) {
//                System.out.print(matrix[i][k] + " ");
//                --i;
//                ++k;
//            }
//            System.out.println();
//        }
    }
    public static void main(String[] args){
        int arr[][] = new int[][]{{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20},
        };
        printDiagonal(arr);
    }
}
