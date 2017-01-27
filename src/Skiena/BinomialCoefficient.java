package Skiena;

//n choose k
class BinomialCoefficient {
    static int binomial(int n, int k){
        //construct table, n rows and k columns
        int[][] bn = new int[n+1][k+1];

        //base cases where  k == 0 or k == n

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= Math.min(i, k); j++){
                if (j == 0 || j == i){
                    bn[i][j] = 1;
                }
                else{
                    bn[i][j] = bn[i-1][j-1] + bn[i-1][j];//choose j or don't
                }
            }
        }
        return bn[n][k];
    }

    public static void main(String[] args){
        System.out.println(binomial(4, 2));
    }
}
