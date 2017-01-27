package CTCI.p1;

class p1_7_matrix_rotation {
    static void rotate(int[][] m){
        //n*n matrix (assumed square)
        //in place
        int i = 0, n = m.length;
        int j = i;
        while (i < n / 2){
            for (j = i; j < n-1-i; j++){
                int temp = m[i][j];
                m[i][j] = m[n-1 - j][i];
                m[n-1-j][i] = m[n-1-i][n-1-j];
                m[n-1-i][n-1-j] = m[j][n-1-i];
                m[j][n-1-i] = temp;
            }
            i++;
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
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] b = new int[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        rotate(a);
        print(a);
        rotate(b);
        print(b);
    }
}
