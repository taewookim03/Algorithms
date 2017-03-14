import java.util.*;

class scratch {

    static int maxContinuousSum(int[] arr){
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        int maxOverall = arr[0];

        for (int i = 1; i < n; i++){

        }

//        int[] prefixSum = new int[n+1];
//        prefixSum[0] = 0;
//        for (int i = 1; i <= n; i++){
//            prefixSum[i] = prefixSum[i-1] + arr[i-1];
//        }

//        for (int i = 1; i <= n; i++){
//            for (int j = i; j <= n; j++){
//                int sum = prefixSum[j] - prefixSum[i-1];
//                max = Math.max(sum, max);
//            }
//        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 7, -8, 5, 0};
        //

        //                    0  1  4  11  3  8  8
        System.out.println(maxContinuousSum(arr));//should give 11

    }
}
