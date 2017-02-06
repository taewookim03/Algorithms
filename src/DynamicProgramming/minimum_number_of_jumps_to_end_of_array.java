package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/5/2017.
 */
public class minimum_number_of_jumps_to_end_of_array {
    static int minJumps(int[] arr){
        int[] memo = new int[arr.length];
        int jumps = minJumpsUtil(arr, 0, memo);
        if (jumps != Integer.MAX_VALUE) return jumps;
        else return -1;
    }

    static int minJumpsUtil(int[] arr, int i, int[] memo){
        if (i >= arr.length) return 0;//arrived
        if (memo[i] != 0) return memo[i];//check cache

        int min = Integer.MAX_VALUE;
        int maxStep = arr[i];
        for (int j = 1; j <= maxStep; j++){
            int jumps = minJumpsUtil(arr, i+j, memo);
            if (jumps != Integer.MAX_VALUE) jumps++;//add jump from current position unless 0 (can't jump from there)
            if (jumps < min) min = jumps;
        }
        memo[i] = min;
        return min;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,3,6,1,0,9};//ans: 3
        System.out.println(minJumps(arr));
    }
}
