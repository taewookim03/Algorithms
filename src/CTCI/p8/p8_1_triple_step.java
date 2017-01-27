package CTCI.p8;

class p8_1_triple_step {
    static int ways(int n){
        int[] w = new int[n+1];
        w[0] = 1;
        w[1] = 1;
        w[2] = 2;
        for (int i = 3; i <= n; i++){
            w[i] = w[i-1] + w[i-2] + w[i-3];
        }
        return w[n];
    }
    public static void main(String[] args){
        System.out.println(ways(4));
    }
}
