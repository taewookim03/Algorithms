package DynamicProgramming;

//partition an array into k parts without rearranging so that the maximum partition sum is the lowest
class LinearPartition {
    static void partition(int[] arr, int k){
        int n = arr.length;

        int[] p = new int[n+1];//prefix sum to facilitate summations - note 1-based array index
        p[0] = 0;
        for (int i = 1; i <= n; i++){
            p[i] = p[i-1] + arr[i-1];
        }

        int[][] m = new int[n+1][k+1];//matrix to store the minimum partition M(i, j) where we want to know M(n, k)
        int[][] d = new int[n+1][k+1];//matrix to store the partition locations

        //initialize matrix with base case M(1, j)
        for (int j = 1; j <= k; j++){
            m[1][j] = p[1];
        }
        //base case M(i, 1)
        for (int i = 1; i <= n; i++){
            m[i][1] = p[i];
        }

        //fill array (DP)
        for (int i = 2; i <= n; i++){
            for (int j = 2; j <= k; j++){
                //iterate through M options depending on partition location and choose the minimum
                m[i][j] = Integer.MAX_VALUE;

                for (int q = 1; q <= i; q++){
                    int M_i_j = Math.max(m[q][j-1], p[i] - p[q]);
                    if (M_i_j < m[i][j]){
                        m[i][j] = M_i_j;
                        d[i][j] = q;
                    }
                }
            }
        }

        //display numbers with division
        displayPartitions(arr, d, n, k);
    }
    static void displayPartitions(int[] arr, int[][] d, int i, int j){
        if (j <= 1) {
            printArr(arr, 1, i);
            return;
        }
        int p = d[i][j];
        displayPartitions(arr, d, p, j-1);
        printArr(arr, p+1, i);
    }
    static void printArr(int[] arr, int start, int end){
        for (int i = start - 1; i <= end - 1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        partition(arr, 3);
    }
}
