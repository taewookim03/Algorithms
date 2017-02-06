package hackerrank;

/**
 * Created by Taewoo Kim on 2/5/2017.
 */
import java.io.*;
import java.util.*;

class candies {
    public static long minCandies(int[] scores){
        int n = scores.length;
        int[] candies = new int[n];
        int[] d = new int[n];//largest descending sequence starting at each index (including itself)

        d[n-1] = 1;
        for (int i = n-2; i >= 0; i--){
            if (scores[i] > scores[i+1]) d[i] = d[i+1] + 1;
            else d[i] = 1;
        }

        candies[0] = d[0];
        for (int i = 1; i < n; i++){
            if (scores[i] > scores[i-1]){
                candies[i] = Math.max(d[i], candies[i-1]+1);
            }
            else candies[i] = d[i];
        }

        long sum = 0;
        for (int i = 0; i < n; i++){
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(minCandies(scores));
    }
}