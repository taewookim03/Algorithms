//class Solution{
//
//    static int[] func(int[] arr){
//        int n = arr.length;
//        if (n <= 1) return arr;
//
//        int[] P = new int[n];
//        P[0] = 1;
//        for (int i = 1; i < n; i++){
//            P[i] = P[i-1] * arr[i-1];
//        }
//
//        int[] Q = new int[n];
//        Q[n-1] = 1;
//        for (int i = n-2; i >= 0; i--){
//            Q[i] = Q[i+1] * arr[i+1];
//        }
//
//        int[] M = new int[n];
//        for (int i = 0; i < n; i++){
//            M[i] = P[i] * Q[i];
//        }
//        return M;
//    }
//
//    public static void main(String[] args){
//        int[] X = new int[]{1, 2, 3, 4};
//        int[] M = func(X);
//
//        for (int i : X) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        for (int i : M){
//            System.out.print(i + " ");
//        }
//
//    }
//}