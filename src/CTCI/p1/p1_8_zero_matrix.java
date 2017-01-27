package CTCI.p1;

class p1_8_zero_matrix {
    static void setZero(int[][] matrix){
        //set all rows and columns that contain a zero element

        //M by N matrix - m rows, n columns
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] zeroRows = new boolean[m];
        boolean[] zeroCols = new boolean[n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++){
            if (zeroRows[i]){
                for (int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++){
            if (zeroCols[j]){
                for (int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void print(int[][] m){
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] a = new int[][]{
                {3, 0, 1, 4},
                {6, 7, 9, 1},
                {2, 8, 7, 0}
        };

        setZero(a);
        print(a);
    }
}
