package DynamicProgramming;
import java.util.*;
import java.io.*;

/**
 * Created by Taewoo Kim on 2/7/2017.
 * given n unique integers, find number of pairs whose difference is k
 * e.g. n = 5, k = 2
 * 1 5 3 4 2
 * ans: 3
 */
public class count_pairs_with_difference_k {
    static int countPairsWithDiff(int[] arr, int k){
        //O(n) with hash
        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }

        int count = 0;
        for (int num : arr){
            if (set.contains(num + k)) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countPairsWithDiff(arr, k));
    }
}
