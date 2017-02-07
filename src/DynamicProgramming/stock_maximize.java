package DynamicProgramming;

/**
 * Created by Taewoo Kim on 2/7/2017.
 * https://www.hackerrank.com/challenges/stockmax/submissions/code/37545010
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class stock_maximize {
    public static long maxProfit(int[] prices){
        int n = prices.length;
        if (n < 1) return 0;

        int[] m = new int[n];//track max past this point (max in range [i .. n-1])
        m[n-1] = prices[n-1];
        for (int i = n-2; i >= 0; i--){
            m[i] = Math.max(m[i+1], prices[i]);
        }

        //for each element, buy if theres a profit to be made in the future
        long profit = 0;
        for (int i = 0; i < n; i++){
            if (m[i] > prices[i]) profit += m[i] - prices[i];
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int N = in.nextInt();
            int[] prices = new int[N];
            for(int prices_i=0; prices_i < N; prices_i++){
                prices[prices_i] = in.nextInt();
            }
            System.out.println(maxProfit(prices));
        }
    }
}
