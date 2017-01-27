package DynamicProgramming;

//n choose k
class BinomialCoefficient {
    static int binomial(int n, int k){
        //construct table, n rows and k columns
        int[][] bn = new int[n+1][k+1];

        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= Math.min(i, k); j++){
                //base cases where  k == 0 or k == n
                if (j == 0 || j == i){
                    bn[i][j] = 1;
                }
                else{
                    //choose j or don't (n-1 items to choose from and either k-1 or k choices left)
                    bn[i][j] = bn[i-1][j-1] + bn[i-1][j];
                }
            }
        }
        return bn[n][k];
    }

    public static void main(String[] args){
        System.out.println(binomial(4, 2));
    }
}
