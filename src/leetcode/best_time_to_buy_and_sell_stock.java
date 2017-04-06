package leetcode;

/**
 * Created by Taewoo Kim on 4/4/2017.
 */
public class best_time_to_buy_and_sell_stock {
    public class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int min = Integer.MAX_VALUE;
            for (int p : prices){
                min = Math.min(min, p);
                maxProfit = Math.max(maxProfit, p - min);
            }
            return maxProfit;
        }
    }
}
