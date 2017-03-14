package TwoDimensional;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class rotateMatrix {
    static void rotate (int[][] m){
        //square matrix
        int n = m.length;
        //for k layer
        for (int k = 0; k < n / 2; k++){
            //offset
            for (int j = k; j < n-1-k; j++){
                int temp = m[k][j];
                m[k][j] = m[n-1-j][k];
                m[n-1-j][k] = m[n-1-k][n-1-j];
                m[n-1-k][n-1-j] = m[j][n-1-k];
                m[j][n-1-k] = temp;
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
        int m[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        print(m);
        System.out.println();
        rotate(m);
        print(m);
    }
}
